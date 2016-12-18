package com.amarjanica.discourse.util

import java.net.URLEncoder

trait HasQueryParameters { self: HasParameters =>

  val queryParameters = {
    val sb = new StringBuilder()
    parameters.foldLeft(sb) {
      case (agg, (key, value)) =>
        if (Option(value).isDefined) {
          agg.append(key)
            .append("=")
            .append(URLEncoder.encode(value.toString, "UTF-8"))
            .append("&")
        } else {
          agg
        }
    }.toString().init
  }
}
