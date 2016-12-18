package com.amarjanica.discourse.unit

import com.amarjanica.discourse.util.SerializableAsJson
import com.amarjanica.discourse.{BaseHttpClient, DiscourseApiClient}
import com.squareup.okhttp.Request
import org.mockito.Matchers.any
import org.mockito.Mockito._

trait BaseSpec{

  def client(resource: String = "") = {
    val mockBaseHttpClient = mock(classOf[BaseHttpClient])
    val discourseClient = new DiscourseApiClient("http://localhost:3000", None, mockBaseHttpClient)

    when(mockBaseHttpClient.get(any(classOf[String]), any(classOf[Request.Builder])))
      .thenReturn(
        scala.io.Source.fromInputStream(this.getClass.getResourceAsStream(resource)).mkString
      )
    when(mockBaseHttpClient.post(any(classOf[String]), any(classOf[Request.Builder])))
      .thenReturn(
        scala.io.Source.fromInputStream(this.getClass.getResourceAsStream(resource)).mkString
      )
    when(mockBaseHttpClient.put(any(classOf[String]), any(classOf[SerializableAsJson]), any(classOf[Request.Builder])))
      .thenReturn(
        scala.io.Source.fromInputStream(this.getClass.getResourceAsStream(resource)).mkString
      )
    when(mockBaseHttpClient.delete(any(classOf[String]), any(classOf[Request.Builder])))
      .thenReturn(true)

    discourseClient
  }
}
