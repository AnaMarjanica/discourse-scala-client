package com.amarjanica.discourse.api

import com.amarjanica.discourse.DiscourseApiClient
import com.amarjanica.discourse.api.models.{Badge, BadgeContainer, CreateBadge, GrantBadge}

trait WithBadges {
  self: DiscourseApiClient =>

  def listBadges(): Array[Badge] =
    get("/admin/badges.json").as[BadgeContainer].badges

  def listUserBadges(username: String): Array[Badge] =
    get(s"/users/$username/activity/badges.json").as[BadgeContainer].badges

  def grantUserBadge(grantBadge: GrantBadge): Badge =
    post("/user_badges", grantBadge).as[Badge]

  def createBadge(createBadge: CreateBadge): Badge =
    post("/admin/badges.json", createBadge).as[Badge]


}
