package com.amarjanica.discourse.api.models

@JsonIgnoreProperties(ignoreUnknown = true)
case class Group(
  id: Int,
  automatic: Boolean,
  name: String,
  @JsonProperty("user_count")
  userCount: Int,
  @JsonProperty("alias_level")
  aliasLevel: Int,
  visible: Boolean,
  title: Option[String] = None,
  @JsonProperty("primary_group")
  primaryGroup: Boolean
  // TODO: missing mappings
)
