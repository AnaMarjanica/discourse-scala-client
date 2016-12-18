package com.amarjanica.discourse.api.models

import java.time.OffsetDateTime
import com.amarjanica.discourse.util.SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
case class NotificationResponse (
  notifications: Array[Notification],
  @JsonProperty("total_rows_notifications")
  totalRowsNotifications: Int
) extends SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
case class Notification(
  id: Int,
  @JsonProperty("notification_type")
  notificationType: Int,
  read: Boolean,
  @JsonProperty("created_at")
  createdAt: OffsetDateTime,
  @JsonProperty("post_number")
  postNumber: Option[Int] = None,
  @JsonProperty("topic_id")
  topicId: Option[Int] = None,
  slug: Option[String] = None,
  data: Map[String, String] = Map.empty
) extends SerializableAsJson
