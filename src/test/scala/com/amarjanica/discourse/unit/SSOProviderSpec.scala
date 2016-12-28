package com.amarjanica.discourse.unit

import com.amarjanica.discourse.api.models.SSOUserRequest
import org.specs2.Specification

class SSOProviderSpec extends Specification {def is =s2"""
  Spec for SSO
  should throw an error if provided null params  $testUserRequest
  should return queryparams  $testUserRequestQueryParameters
  """

  def testUserRequest = {
    new SSOUserRequest(
      email = null,
      require_activation = false,
      external_id = null,
      username = null,
      name = null,
      avatar_url = null,
      admin = false,
      moderator = false,
      avatar_force_update = false,
      suppress_welcome_message = false
    ).parameters must throwA[Exception]
  }

  def testUserRequestQueryParameters = {
    val qp = new SSOUserRequest(
      email = "ana@example.com",
      require_activation = false,
      external_id = "ana",
      username = "ane",
      name = "ana ana",
      avatar_url = "//",
      admin = false,
      moderator = false,
      avatar_force_update = false,
      suppress_welcome_message = false
    ).queryParameters

    (qp should contain("email=ana%40example.com")) and
    (qp should contain("external_id=ana")) and
    (qp should contain("external_id=ana"))
  }


}
