package com.amarjanica.discourse.models

import com.amarjanica.discourse.util.SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
class BasicUser(
  id: Int,
  username: String,
  @JsonProperty("avatar_template")
  avatarTemplate: Option[String]
) extends Serializable with SerializableAsJson
