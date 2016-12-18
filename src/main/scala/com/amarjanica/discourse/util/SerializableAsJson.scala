package com.amarjanica.discourse.util

trait SerializableAsJson { self: Serializable =>
  def asJson(): String = Json.mapper.writeValueAsString(this)
}
