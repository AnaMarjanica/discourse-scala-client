package com.amarjanica.discourse.unit

import org.specs2.Specification

class ApiKeySpec extends Specification with BaseSpec {

  def is = s2"""
      It should return api key list $testListApiKeys
      create api key                $testCreateApiKey
      delete api key                $testDeleteApiKey
  """

  def testListApiKeys = {
    val discourseClient = client("api.json")
    val res = discourseClient.listApiKeys()

    (res.size shouldEqual 1) and
    (res.head.key shouldEqual "test_d7fd0429940") and
    (res.head.user.isDefined should beTrue)
  }

  def testCreateApiKey = {
    val discourseClient = client("generate_api_key.json")

    val res = discourseClient.generateApiKey(1)

    (res.id shouldEqual 5) and
    (res.user.isDefined should beTrue)
  }

  def testDeleteApiKey =
    client().revokeUserApiKey(1) should beTrue
}
