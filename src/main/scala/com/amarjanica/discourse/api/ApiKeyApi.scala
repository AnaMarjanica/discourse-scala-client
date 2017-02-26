package com.amarjanica.discourse
package api

import models._

class ApiKeyApi(client: BaseDiscourseClient){

  def list(): List[ApiKey] =
    client.get(s"/admin/api.json").asList[ApiKey]

  def generate(userId: Int): ApiKey =
    client.post(s"/admin/users/${userId}/generate_api_key.json").as[ApiKeyContainer].apiKey

  def revoke(userId: Int): Boolean =
    client.delete(s"/admin/users/${userId}/revoke_api_key.json")
}
