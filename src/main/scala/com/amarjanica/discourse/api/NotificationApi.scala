package com.amarjanica.discourse
package api

import models._

class NotificationApi(client: BaseDiscourseClient){

  def list(): NotificationResponse =
    client.get("/notifications.json").as[NotificationResponse]
}
