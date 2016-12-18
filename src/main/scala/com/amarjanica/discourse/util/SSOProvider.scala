package com.amarjanica.discourse.util

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

import com.amarjanica.discourse.api.models.{SSOContext, SSOUserRequest, SSOUserResult, SignatureNotMatchedException}
import java.util.Base64
/**
 * Helper class for providing single sign on integration with Discourse.
 *
 * How the SSO works:
 *
 * 1. User clicks "Login" on your site while your site has sso enabled.
 *
 * 2. User is redirected to the link you have provided in the Discourse SSO settings.
 * Using SSOProvider, you verify the incoming SSO request(via the configured SSO secret),
 * then you authenticate the user that is trying to log in(by letting them log in
 * to your system or by using their existing session in your system).
 *
 * 3. You get the user information for the authenticated user, and use SSOProvider
 * to build a query string that will be sent back to discourse/session/sso_login
 *
 * For example:
 * {{{
 *   val ctx: SSOContext = ???
 *   val req: SSOUserRequest = ???
 *   val sso = new SSOProvider(ctx).generate(req)
 *   val discourseSite = "http://discourse.example.com"
 *   // use redirectUrl to authenticate to your discourseSite
 *   val redirectUrl = s"\${discourseSite}/session/sso_login?sso=\${sso.payload}&sig=\${sso.signature}"
 * }}}
 * @see [[https://meta.discourse.org/t/official-single-sign-on-for-discourse/13045 Discourse]] for more information
 */
class SSOProvider(ctx: SSOContext) {

  def provide(req: SSOUserRequest): SSOUserResult = {
    val signedPayload = signPayload(ctx.payload)
    if (signedPayload == ctx.signature) {
      val oldPayload = new String(Base64.getDecoder.decode(ctx.payload.getBytes))
      val newPayload = s"$oldPayload&${req.queryParameters}"
      val base64String = Base64.getEncoder.encodeToString(newPayload.getBytes("UTF-8"))
      SSOUserResult(base64String, signPayload(base64String))
    } else {
      throw SignatureNotMatchedException(s"SSO ${ctx.payload}, signature $signedPayload did not match signature ${ctx.signature}!")
    }
  }

  private[this] def calculateRFC2104HMAC(data: String, key: String): String = {
    val HMAC_SHA1_ALGORITHM = "HmacSHA256"
    val mac = Mac.getInstance(HMAC_SHA1_ALGORITHM)
    val signingKey = new SecretKeySpec(key.getBytes("UTF-8"), HMAC_SHA1_ALGORITHM)
    mac.init(signingKey)
    mac.doFinal(data.getBytes)
    bytesToHex(mac.doFinal(data.getBytes("UTF-8")))
  }

  private[this] def signPayload(payload: String): String = calculateRFC2104HMAC(payload, ctx.secret)

  private[this] def bytesToHex(bytes: Array[Byte]) = bytes.map("%02X" format _).mkString
}
