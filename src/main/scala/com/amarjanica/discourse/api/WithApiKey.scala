package com.amarjanica.discourse.api

import com.amarjanica.discourse.DiscourseApiClient
import com.amarjanica.discourse.api.models.{ApiKey, ApiKeyContainer}

trait WithApiKey { self: DiscourseApiClient =>

  def listApiKeys(): Array[ApiKey] =
    get(s"/admin/api.json").as[Array[ApiKey]]

  def generateApiKey(userId: Int): ApiKey =
    post(s"/admin/users/${userId}/generate_api_key.json").as[ApiKeyContainer].apiKey

  def revokeUserApiKey(userId: Int): Boolean =
    delete(s"/admin/users/${userId}/revoke_api_key.json")
}
