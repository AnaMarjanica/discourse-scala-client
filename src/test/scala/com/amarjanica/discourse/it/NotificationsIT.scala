package com.amarjanica.discourse.it

import org.specs2.Specification

class NotificationsIT extends Specification with BaseIT{
  def is = s2"""
      List notifications $listNotifications
  """

  def listNotifications =
    discourseClient.listNotifications.notifications.nonEmpty should beTrue
}
