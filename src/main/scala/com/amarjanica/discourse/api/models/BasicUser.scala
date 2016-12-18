package com.amarjanica.discourse.api.models

import com.amarjanica.discourse.util.SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
class BasicUser(
  id: Int,
  username: String,
  @JsonProperty("avatar_template")
  avatarTemplate: Option[String]
) extends Serializable with SerializableAsJson
