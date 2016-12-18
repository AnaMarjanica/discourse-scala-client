package com.amarjanica.discourse.api.models

import com.amarjanica.discourse.util.SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
case class DiscourseStatusMessage (
  success: Boolean,
  message: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
case class UpdateUserStatus (
  success: String, // "OK"
  user: User
) extends SerializableAsJson
