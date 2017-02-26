package com.amarjanica.discourse
package api

import models._

class PostApi(client: BaseDiscourseClient){
    def create(createPost: CreatePost): Post =
      client.post(uri="/posts", createPost).as[Post]

    def get(id: Int, args: Map[String, String] = Map.empty): Post =
      client.get(s"/posts/$id.json", args).as[Post]

    def update(id: Int, createPost: CreatePost): Post =
      client.put(s"/posts/$id", createPost).as[Post]

    def delete(id: Int): Unit =
      client.delete(s"/posts/$id.json")
}
