package com.amarjanica.discourse.util

trait HasParameters extends Product {

  val parameters: Map[String, Any] = {
    getClass.getDeclaredFields.map( _.getName ) // all field names
                .zip( productIterator.to ).toMap
  }

}
