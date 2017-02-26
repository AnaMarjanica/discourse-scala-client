package com.amarjanica.discourse

import com.amarjanica.discourse.api._
import com.amarjanica.discourse.util.SerializableAsJson
import com.squareup.okhttp.Request

/** Client for discourse api requests
  *
  * @see <a href="https://meta.discourse.org/t/discourse-api-documentation/22706">Discourse Api Documentation.</a>
  * @example
  * {{{
  *  import com.amarjanica.discourse.{Credentials, DiscourseClient}
  *  val discourseUrl = "http://127.0.0.1:80" // replace it
  *  val credentials = Credentials(
  *    api_username = "your_discourse_username",
  *    api_key = "very_long_string"
  *  )
  *  val discourseClient = new DiscourseClient(discourseUrl, Some(credentials))
  * }}}
  * @param endPoint    discourse site url e.g. http://discourse.mysite.com
  * @param credentials api_username and api_key */
class DiscourseClient(
  endPoint: String,
  credentials: Option[Credentials] = None,
  httpClient: BaseHttpClient = new BaseHttpClient(readTimeoutSec = 10, writeTimeoutSec = 10)
) extends BaseDiscourseClient(endPoint, credentials, httpClient) {
  val badgeApi = new BadgeApi(this)
  val apiKeyApi = new ApiKeyApi(this)
  val categoryApi = new CategoryApi(this)
  val notificationApi = new NotificationApi(this)
  val postApi = new PostApi(this)
  val searchApi = new SearchApi(this)
  val topicApi = new TopicApi(this)
  val userApi = new UserApi(this)
}

class BaseDiscourseClient(
  endPoint: String,
  val credentials: Option[Credentials] = None,
  httpClient: BaseHttpClient
) {

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
    httpClient.get(
      url = url,
      requestBuilder = requestBuilder()
    )
  }

  def get[T](uri: String, opts: Map[String, String] = Map.empty[String, String]) =
    httpClient.get(
      url = getUrl(uri, opts),
      requestBuilder = requestBuilder()
    )

  def post[T <: SerializableAsJson](uri: String, data: T) =
    httpClient.post(
      url = getUrl(uri, Map.empty[String, String]),
      data = data,
      requestBuilder = requestBuilder()
    )

  def post[T <: SerializableAsJson](uri: String) =
    httpClient.post(
      url = getUrl(uri, Map.empty[String, String]),
      requestBuilder = requestBuilder()
    )

  def put[T <: SerializableAsJson](uri: String, data: T) =
    httpClient.put(
      getUrl(uri, Map.empty[String, String]),
      data,
      requestBuilder()
    )

  def put[T <: SerializableAsJson](
    uri: String,
    opts: Map[String, String],
    data: T
  ) =
    httpClient.put(
      getUrl(uri, opts),
      data,
      requestBuilder()
    )

  def put(uri: String) =
    httpClient.put(
      getUrl(uri, Map.empty[String, String]),
      requestBuilder()
    )

  def delete(uri: String): Boolean =
    httpClient.delete(getUrl(uri, Map.empty[String, String]), requestBuilder())


}
