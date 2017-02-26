package com.amarjanica.discourse.unit

import java.util.UUID

import com.amarjanica.discourse.models._
import com.amarjanica.discourse.{BaseHttpClient, DiscourseClient}
import com.squareup.okhttp.Request
import org.mockito.Matchers
import org.specs2.Specification
import org.specs2.mock._

import scala.io.Source.fromInputStream

class BadgeApiSpec extends Specification with Mockito with BaseSpec {
  def is =
    s2"""
      It should list badges $testListBadges
      should list badge types $testListBadgeTypes
      should list all user badges $testListUserBadges
      should throw exception if user not found $testListUserBadgeNotFound
      should create badge $testCreateBadge
  """

  def testListBadges = {
    val (httpClient, discourseClient) = mockContext
    (httpClient.get("/admin/badges.json", any[Request.Builder])
      returns
      resourceAsStream("badges.json"))

    val badges = discourseClient.badgeApi.list()

    (badges.badges.size shouldEqual 23) and
      (badges.badgeTypes.size shouldEqual 3) and
      (badges.badges.head.id shouldEqual 9)
  }

  def testListBadgeTypes = {
    val (httpClient, discourseClient) = mockContext
    (httpClient.get("/admin/badges/types.json", any[Request.Builder])
      returns
      resourceAsStream("badge_types.json"))

    val badgeTypes = discourseClient.badgeApi.listTypes()

    val expected = BadgeTypes(List(
      BadgeType(id = 1, name = "Gold", sortOrder = 9),
      BadgeType(id = 2, name = "Silver", sortOrder = 8),
      BadgeType(id = 3, name = "Bronze", sortOrder = 7)))
    badgeTypes shouldEqual expected
  }

  def testListUserBadges = {
    val (httpClient, discourseClient) = mockContext
    val username = "test"
    (httpClient.get(s"/users/$username/activity/badges.json", any[Request.Builder])
      returns
      resourceAsStream("user_badges.json"))

    val badges = discourseClient.badgeApi.listForUser(username)

    (badges.badges.size shouldEqual 2) and
      (badges.badgeTypes.size shouldEqual 1) and
      (badges.badges.head.id shouldEqual 10)
  }

  def testListUserBadgeNotFound = {
    val (httpClient, discourseClient) = mockContext
    val username = "test"
    (httpClient.get(s"/users/$username/activity/badges.json", any[Request.Builder])
      throws new DiscourseApiNotFoundException(""))

    discourseClient.badgeApi.listForUser(username) must throwA[DiscourseApiNotFoundException]
  }

  def testCreateBadge = {
    val (httpClient, discourseClient) = mockContext
    val createBadge = CreateBadge(name = UUID.randomUUID().toString, badgeTypeId = 1)
    (httpClient.post("/user_badges", Matchers.eq(createBadge), any[Request.Builder])
      returns
      resourceAsStream("create_badge.json"))

    val response = discourseClient.badgeApi.create(createBadge)

    response.badgeTypes shouldEqual List(BadgeType(id = 1, name = "Gold", sortOrder = 9))
  }

  def mockContext = {
    val httpClient = mock[BaseHttpClient]
    val discourseApiClient = new DiscourseClient(any[String], None, httpClient)

    (httpClient, discourseApiClient)
  }

  def resourceAsStream(resource: String) = fromInputStream(getClass.getResourceAsStream(resource)).mkString
}
