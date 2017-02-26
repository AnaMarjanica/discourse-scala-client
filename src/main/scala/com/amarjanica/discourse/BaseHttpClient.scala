package com.amarjanica.discourse

import java.util.concurrent.TimeUnit

import com.amarjanica.discourse.models._
import com.amarjanica.discourse.util.{Json, SerializableAsJson}
import com.squareup.okhttp._

object BaseHttpClient {
  def fromJson[T](raw: String, clazz: Class[T]): T = try {
    Json.mapper.readValue(raw, clazz)
  } catch {
    case err: Throwable =>
      throw new DiscourseApiJsonException(s"Could not serialize to $clazz", err)
  }

  def fromJsonList[T](raw: String, clazz: Class[T]): List[T] = try {
    import scala.collection.JavaConverters._
    val value: java.util.List[T] = Json.mapper.readValue(
      raw,
      Json.mapper.getTypeFactory.constructCollectionType(classOf[java.util.List[Any]], clazz)
    )

    value.asScala.toList
  } catch {
    case err: Throwable =>
      throw new DiscourseApiJsonException(s"Could not serialize to json list", err)
  }
}

// TODO: refactor
class BaseHttpClient(readTimeoutSec: Int, writeTimeoutSec: Int) {

  private val JSON = MediaType.parse("application/json; charset=utf-8")

  val client = {
    val c = new OkHttpClient
    c.setReadTimeout(readTimeoutSec, TimeUnit.SECONDS)
    c.setWriteTimeout(writeTimeoutSec, TimeUnit.SECONDS)
    c
  }

  @throws[DiscourseApiException]
  @throws[DiscourseApiUnauthenticatedException]
  @throws[DiscourseApiNotFoundException]
  def get(url: String, requestBuilder: Request.Builder): String = {
    requestToResponse(
      requestBuilder
        .url(url)
        .get()
        .build()
    )
  }

  @throws[DiscourseApiException]
  @throws[DiscourseApiUnauthenticatedException]
  @throws[DiscourseApiNotFoundException]
  def delete(url: String, requestBuilder: Request.Builder): Boolean = {
    client.newCall(
      requestBuilder
        .url(url)
        .delete()
        .build()
    ).execute().isSuccessful
  }

  @throws[DiscourseApiException]
  @throws[DiscourseApiUnauthenticatedException]
  @throws[DiscourseApiNotFoundException]
  def post[T <: SerializableAsJson](url: String, data: T, requestBuilder: Request.Builder): String = {
    requestToResponse(
      requestBuilder
        .url(url)
        .post(RequestBody.create(JSON, data.asJson()))
        .build()
    )
  }

  @throws[DiscourseApiException]
  @throws[DiscourseApiUnauthenticatedException]
  @throws[DiscourseApiNotFoundException]
  def post(url: String, requestBuilder: Request.Builder): String = {
    requestToResponse(
      requestBuilder
        .url(url)
        .post(null)
        .build()
    )
  }

  @throws[DiscourseApiException]
  @throws[DiscourseApiUnauthenticatedException]
  @throws[DiscourseApiNotFoundException]
  def put[T <: SerializableAsJson](url: String, data: T, requestBuilder: Request.Builder): String = {
    requestToResponse(
      requestBuilder
        .url(url)
        .put(RequestBody.create(JSON, data.asJson()))
        .build()
    )
  }

  @throws[DiscourseApiException]
  @throws[DiscourseApiUnauthenticatedException]
  @throws[DiscourseApiNotFoundException]
  def put(url: String, requestBuilder: Request.Builder): String = {
    requestToResponse(
      requestBuilder
        .url(url)
        .put(null)
        .build()
    )
  }

  def requestToResponse(req: Request): String = {
    val res = client.newCall(req).execute()
    val body = res.body().string()
    res.code match {
      case 200 | 201 => body
      case 403 =>
        throw new DiscourseApiUnauthenticatedException(s"This action might require higher level permissions! $body")
      case 404 | 410 => throw new DiscourseApiNotFoundException(s"${req.url().toString} Not found!")
      case _ =>
        throw new DiscourseApiException(
          s"Could not retrieve json response. Status code: ${res.code}. Body of response: $body"
        )
    }
  }
}
