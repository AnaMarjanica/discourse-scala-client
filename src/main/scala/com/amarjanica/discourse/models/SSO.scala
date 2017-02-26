package com.amarjanica.discourse.models

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
  * @param require_activation true If the email address has not been verified, set require_activation to "true".
  * @param external_id Your unique user id. The suggested value is your database's 'id' row number.
  * @param username will become the username on Discourse if the user is new or SiteSetting.sso_overrides_username is set.
  * @param name will become the full name on Discourse if the user is new or SiteSetting.sso_overrides_name is set.
  * @param admin boolean
  * @param moderator boolean
  * @param suppress_welcome_message boolean
  */
case class SSOUserRequest(
  email: String,
  require_activation: Boolean,
  external_id: String,
  username: String,
  name: String,
  avatar_url: String,
  admin: Boolean,
  moderator: Boolean,
  avatar_force_update: Boolean,
  suppress_welcome_message: Boolean
) extends HasParameters with HasQueryParameters {
  require(Option(email).isDefined, "email can't be null!")
  require(Option(external_id).isDefined, "external_id can't be null!")
  require(Option(username).isDefined, "username can't be null!")
  require(Option(name).isDefined, "name can't be null!")
}
