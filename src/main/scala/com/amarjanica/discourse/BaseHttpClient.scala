package com.amarjanica.discourse

import java.util.concurrent.TimeUnit

import com.amarjanica.discourse.api.models._
import com.amarjanica.discourse.util.{Json, SerializableAsJson}
import com.squareup.okhttp._

import scala.collection.JavaConversions._

object BaseHttpClient {
  def fromJson[T](raw: String, clazz: Class[T]): T = try {
    Json.mapper.readValue(raw, clazz)
  } catch {
    case err: Throwable =>
      throw new DiscourseApiJsonException(s"Could not serialize to $clazz", err)
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

  def get(url: String, requestBuilder: Request.Builder): String = {
    reqToResString(
      requestBuilder
        .url(url)
        .get()
        .build()
    )
  }

  def delete(url: String, requestBuilder: Request.Builder): Boolean = {
    client.newCall(
      requestBuilder
        .url(url)
        .delete()
        .build()
    ).execute().isSuccessful
  }

  def post[T<:SerializableAsJson](url: String, data: T, requestBuilder: Request.Builder): String = {
    reqToResString(
      requestBuilder
        .url(url)
        .post(RequestBody.create(JSON, data.asJson()))
        .build()
    )
  }

  def post(url: String, requestBuilder: Request.Builder): String = {
    reqToResString(
      requestBuilder
        .url(url)
        .post(null)
        .build()
    )
  }

  def put[T<:SerializableAsJson](url: String, data: T, requestBuilder: Request.Builder): String = {
    reqToResString(
      requestBuilder
        .url(url)
        .put(RequestBody.create(JSON, data.asJson()))
        .build()
    )
  }

  def put(url: String, requestBuilder: Request.Builder): String = {
    reqToResString(
      requestBuilder
        .url(url)
        .put(null)
        .build()
    )
  }

  def reqToResString(req: Request): String = {
    val res  = client.newCall(req).execute()
    val body = res.body().string()
    if (res.isSuccessful && res.headers("Content-Type").mkString.contains("application/json")){
      body
    } else if (res.code == 403) {
      throw new DiscourseApiUnauthenticatedException("Not authenticated!")
    } else if (res.code == 404 || res.code == 410) {
      throw new DiscourseApiNotFoundException(s"${req.url().toString} Not found!")
    } else {
      throw new DiscourseApiException(
        s"Could not retrieve json response. Status code: ${res.code}. Body of response: $body"
      )
    }
  }
}
