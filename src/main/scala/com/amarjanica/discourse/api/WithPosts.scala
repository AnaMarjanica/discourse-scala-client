package com.amarjanica.discourse.api

import com.amarjanica.discourse.DiscourseApiClient
import com.amarjanica.discourse.api.models.{CreatePost, Post}

trait WithPosts {
  self: DiscourseApiClient =>
    def createPost(createPost: CreatePost): Post =
      post(uri="/posts", createPost).as[Post]

    def getPost(id: Int, args: Map[String, String] = Map.empty): Post =
      get(s"/posts/$id.json", args).as[Post]

    def editPost(id: Int, createPost: CreatePost): Post =
      put(s"/posts/$id", createPost).as[Post]

    def deletePost(id: Int): Unit =
      delete(s"/posts/$id.json")
}
