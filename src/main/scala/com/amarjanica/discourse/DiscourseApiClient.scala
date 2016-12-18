package com.amarjanica.discourse

import com.amarjanica.discourse.api.models.Credentials
import com.amarjanica.discourse.api._
import com.amarjanica.discourse.util.SerializableAsJson
import com.squareup.okhttp.Request
import com.typesafe.scalalogging.StrictLogging

/**
  * Client for discourse forum api requests
  * @param endPoint discourse site url e.g. http://discourse.mysite.com
  * @param credentials api_username and api_key
  */
class DiscourseApiClient(
    endPoint: String,
    val credentials: Option[Credentials] = None,
    httpClient: BaseHttpClient = new BaseHttpClient(readTimeoutSec = 10, writeTimeoutSec = 10)
) extends StrictLogging
  with WithApiKey
  with WithBadges
  with WithCategories
  with WithNotifications
  with WithPosts
  with WithSearch
  with WithTopics
  with WithUsers {

  // TODO: this looks ugly, misses validations and not tested!
  private def getUrl(uri: String, queryParams: Map[String, String]) = {
    val queryString = credentials match {
      case None => "?" + queryParams.map(kv => kv._1 + "=" + kv._2).mkString("&")
      case Some(credentials) =>
        "?" + (queryParams ++ credentials.parameters).map(kv => kv._1 + "=" + kv._2).mkString("&")
    }
    endPoint + uri + queryString
  }

  protected def requestBuilder() = {
    val req = new Request.Builder()
    req.addHeader("Accept", "application/json")
    req.addHeader("User-Agent", "Discourse scala client")
    req
  }

  protected def get(uri: String) = {
    val url = getUrl(uri, Map.empty[String, String])
    logger.debug(s"Dispatching http get $url")
    httpClient.get(
      url = url,
      requestBuilder = requestBuilder()
    )
  }

  protected def get[T](uri: String, opts: Map[String, String]) =
    httpClient.get(
      url = getUrl(uri, opts),
      requestBuilder = requestBuilder()
    )

  protected def post[T<:SerializableAsJson](uri: String, data: T) =
    httpClient.post(
      url = getUrl(uri, Map.empty[String, String]),
      data = data,
      requestBuilder = requestBuilder()
    )

  protected def post[T<:SerializableAsJson](uri: String) =
    httpClient.post(
      url = getUrl(uri, Map.empty[String, String]),
      requestBuilder = requestBuilder()
    )

  protected def put[T<:SerializableAsJson](uri: String, data: T) =
    httpClient.put(
      getUrl(uri, Map.empty[String, String]),
      data,
      requestBuilder()
    )

  protected def put[T<:SerializableAsJson](
    uri: String,
    opts: Map[String, String],
    data: T
  ) =
    httpClient.put(
      getUrl(uri, opts),
      data,
      requestBuilder()
    )

  protected def put(uri: String) =
    httpClient.put(
      getUrl(uri, Map.empty[String, String]),
      requestBuilder()
    )

  protected def delete(uri: String): Boolean =
    httpClient.delete(getUrl(uri, Map.empty[String, String]), requestBuilder())


  protected implicit class RichString(s: String)  {
    import BaseHttpClient._
    def asEither[L,R](implicit mL: Manifest[L], mR: Manifest[R]): Either[L,R] = try {
      Right(fromJson[R](s, mR.runtimeClass.asInstanceOf[Class[R]]))
    } catch {
      case e: Exception =>
        Left(fromJson[L](s, mL.runtimeClass.asInstanceOf[Class[L]]))
    }

    def as[T]( implicit m: Manifest[T]): T =
      fromJson[T](s, m.runtimeClass.asInstanceOf[Class[T]])


  }
}
