package com.amarjanica.discourse.it

import com.amarjanica.discourse.api.models.Credentials
import com.amarjanica.discourse.{BaseHttpClient, DiscourseApiClient}

trait BaseIT {
  val httpClient = new BaseHttpClient(
    readTimeoutSec = 10,
    writeTimeoutSec = 10
  )
  val creds = Credentials("test", "1b723140958a1a376909c4b8e574945f606fe0ac415e982ea7c5c68480e6b103")
  val discourseClient = new DiscourseApiClient("http://127.0.0.1:80", Some(creds), httpClient)
}
