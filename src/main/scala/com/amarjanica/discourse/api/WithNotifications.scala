package com.amarjanica.discourse.api

import com.amarjanica.discourse.DiscourseApiClient
import com.amarjanica.discourse.api.models.NotificationResponse

trait WithNotifications {
  self: DiscourseApiClient =>

  def listNotifications(): NotificationResponse =
    get("/notifications.json").as[NotificationResponse]
}
