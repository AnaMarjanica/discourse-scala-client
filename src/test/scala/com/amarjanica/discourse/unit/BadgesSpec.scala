package com.amarjanica.discourse.unit

import org.specs2.Specification

class BadgesSpec extends Specification with BaseSpec {

  def is = s2"""
      It should list badges          $testListBadges
      It should list all user badges $testListUserBadges
  """

  def testListBadges = {
    val discourseClient = client("badges.json")
    val res = discourseClient.listBadges()

    res.head.id shouldEqual 9
  }

  def testListUserBadges = {
    val discourseClient = client("badges.json")

    val res = discourseClient.listUserBadges("test")

    res.head.id shouldEqual 9
  }

}
