package com.amarjanica.discourse.api.models

import com.amarjanica.discourse.util.{HasParameters, HasQueryParameters}

case class SSOContext(
  payload: String,
  signature: String,
  secret: String
)

case class SSOUserResult(payload: String, signature: String)

/**
  * Contains params for generating user signing tokens for Discourse
  * @param email must be a verified email address.
  * @param requireActivation true If the email address has not been verified, set require_activation to "true".
  * @param externalId Your unique user id. The suggested value is your database's 'id' row number.
  * @param username will become the username on Discourse if the user is new or SiteSetting.sso_overrides_username is set.
  * @param name will become the full name on Discourse if the user is new or SiteSetting.sso_overrides_name is set.
  * @param admin boolean
  * @param moderator boolean
  * @param suppressWelcomeMessage boolean
  */
case class SSOUserRequest(
  email: String,
  @JsonProperty("require_activation")
  requireActivation: Boolean,
  @JsonProperty("external_id")
  externalId: String,
  username: String,
  name: String,
  @JsonProperty("avatar_url")
  avatarUrl: String,
  admin: Boolean,
  moderator: Boolean,
  @JsonProperty("avatar_force_update")
  avatarForceUpdate: Boolean,
  @JsonProperty("suppress_welcome_message")
  suppressWelcomeMessage: Boolean
) extends HasParameters with HasQueryParameters {
  require(Option(email).isDefined, "email can't be null!")
  require(Option(externalId).isDefined, "external_id can't be null!")
  require(Option(username).isDefined, "username can't be null!")
  require(Option(name).isDefined, "name can't be null!")
}
