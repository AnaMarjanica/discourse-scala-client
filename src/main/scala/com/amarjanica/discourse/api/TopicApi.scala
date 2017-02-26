package com.amarjanica.discourse
package api

import models._

class TopicApi(client: BaseDiscourseClient){

  def create(createPost: CreatePost): Topic =
    client.post(uri="/posts", createPost).as[Topic]

  def get(id: Int): Topic =
    client.get(s"/t/$id.json").as[Topic]

  def listLatest(categorySlugOrId: String): List[Topic] =
    client.get(s"/c/$categorySlugOrId/l/latest.json").as[TopicListContainer].topicList.topics

  def listTop(categorySlugOrId: String): List[Topic] =
    client.get(s"/c/$categorySlugOrId/l/top.json").as[TopicListContainer].topicList.topics

  def listNew(categorySlugOrId: String): List[Topic] =
    client.get(s"/c/$categorySlugOrId/l/new.json").as[TopicListContainer].topicList.topics
}
