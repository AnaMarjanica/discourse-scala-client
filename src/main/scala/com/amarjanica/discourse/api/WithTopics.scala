package com.amarjanica.discourse.api

import com.amarjanica.discourse.DiscourseApiClient
import com.amarjanica.discourse.api.models._

trait WithTopics { self: DiscourseApiClient =>

  def createTopic(createPost: CreatePost): Topic =
    post(uri="/posts", createPost).as[Topic]

  def getTopic(id: Int): Topic =
    get(s"/t/$id.json").as[Topic]

  def listLatestTopics(categorySlugOrId: String): Array[Topic] =
    get(s"/c/$categorySlugOrId/l/latest.json").as[TopicListContainer].topicList.topics

  def listTopTopics(categorySlugOrId: String): Array[Topic] =
    get(s"/c/$categorySlugOrId/l/top.json").as[TopicListContainer].topicList.topics

  def listNewTopics(categorySlugOrId: String): Array[Topic] =
    get(s"/c/$categorySlugOrId/l/new.json").as[TopicListContainer].topicList.topics
}
