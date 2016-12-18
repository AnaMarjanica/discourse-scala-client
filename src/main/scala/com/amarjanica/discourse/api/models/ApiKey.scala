package com.amarjanica.discourse.api.models

@JsonIgnoreProperties(ignoreUnknown = true)
case class ApiKeyContainer(
  @JsonProperty("api_key")
  apiKey: ApiKey
)
@JsonIgnoreProperties(ignoreUnknown = true)
case class ApiKey(
  id: Int,
  key: String,
  user: Option[BasicUser]
)
