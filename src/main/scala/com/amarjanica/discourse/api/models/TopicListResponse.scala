package com.amarjanica.discourse.api.models

import java.time.OffsetDateTime
import com.amarjanica.discourse.util.SerializableAsJson

case class TopicListContainer(@JsonProperty("topic_list") topicList: TopicList)
case class TopicList(@JsonProperty("topics") topics: Array[Topic])

case class Topic(
  @JsonProperty("id")
  id: Int,
  @JsonProperty("title")
  title: String,
  @JsonProperty("slug")
  slug: String,
  @JsonProperty("category_id")
  categoryId: Int,
  @JsonProperty("created_at")
  createdAt: OffsetDateTime,
  @JsonProperty("post_stream")
  postStream: Option[PostStream] = None
)

case class PostStream(
  @JsonProperty("posts") posts: Array[Post]
)

case class Post(
  @JsonProperty("id") id: Int,
  @JsonProperty("cooked") cooked: String,
  @JsonProperty("topic_id") topic_id: Int,
  @JsonProperty("updated_at") updated_at: OffsetDateTime,
  @JsonProperty("created_at") created_at: OffsetDateTime
)

case class CreatePost(
  title: String,
  raw: String,
  @JsonProperty("topic_id")
  topicId: Option[Long] = None,
  archetype: Option[String] = None,
  category: String,
  /*Notify what usernames. Add "username1,username2"*/
  @JsonProperty("target_usernames")
  targetUsernames: Option[String] = None,
  @JsonProperty("reply_to_post_number")
  replyToPostNumber: Option[Int] = None,
  @JsonProperty("auto_track")
  autoTrack: Boolean = true
) extends SerializableAsJson
