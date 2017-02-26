package com.amarjanica.discourse.models

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
