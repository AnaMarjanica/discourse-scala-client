package com.amarjanica.discourse
package api

import com.amarjanica.discourse.models._

class BadgeApi(client: BaseDiscourseClient) {

  def list(): Badges =
    client.get("/admin/badges.json").as[Badges]

  def listTypes(): BadgeTypes =
    client.get("/admin/badges/types.json").as[BadgeTypes]

  def listForUser(username: String): Badges =
    client.get(s"/users/$username/activity/badges.json").as[Badges]

  def grant(grantBadge: GrantBadge) {
    client.post("/user_badges", grantBadge)
  }

  def create(createBadge: CreateBadge): CreateBadgeResponse =
    client.post("/user_badges", createBadge).as[CreateBadgeResponse]
}
