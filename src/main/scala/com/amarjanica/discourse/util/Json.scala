package com.amarjanica.discourse.util

import java.time._
import com.fasterxml.jackson.core.{JsonParser, JsonGenerator}
import com.fasterxml.jackson.databind._
import com.fasterxml.jackson.databind.DeserializationFeature._
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object Json {
  private val jtstampSerializer = new JsonSerializer[java.time.OffsetDateTime] {
    override def serialize(value: java.time.OffsetDateTime, generator: JsonGenerator, x: SerializerProvider) =
      generator.writeString(value.toString())
  }
  private val jtstampDeserializer = new JsonDeserializer[java.time.OffsetDateTime] {
    override def deserialize(parser: JsonParser, context: DeserializationContext) =
      OffsetDateTime.parse(parser.getValueAsString)
  }
  val timeModule = new SimpleModule()
    .addSerializer(classOf[java.time.OffsetDateTime], jtstampSerializer)
    .addDeserializer(classOf[java.time.OffsetDateTime], jtstampDeserializer)
  val mapper = {
    val o = new ObjectMapper()
    o.registerModule(DefaultScalaModule)
    o.registerModule(timeModule)
    o.configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
    o
  }

}
