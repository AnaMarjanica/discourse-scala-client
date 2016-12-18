package com.amarjanica.discourse.unit

import com.amarjanica.discourse.api.models.SSOUserRequest
import org.specs2.Specification

class SSOProviderSpec extends Specification {def is =s2"""
  Spec for SSO
  should throw an error if provided null params  $testUserRequest
  """

  def testUserRequest = {
    new SSOUserRequest(
      email = null,
      requireActivation = false,
      externalId = null,
      username = null,
      name = null,
      avatarUrl = null,
      admin = false,
      moderator = false,
      avatarForceUpdate = false,
      suppressWelcomeMessage = false
    ).parameters must throwA[Exception]
  }


}
