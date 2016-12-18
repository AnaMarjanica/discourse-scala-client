package com.amarjanica.discourse.api

import java.net.URLEncoder

import com.amarjanica.discourse.DiscourseApiClient
import com.amarjanica.discourse.api.models._


trait WithUsers {
  self: DiscourseApiClient =>

  /*This will not work if you have local logins disabled!*/
  def createUser(createUserRequest: CreateUser): CreateUserResponse =
    post("/users", createUserRequest).as[CreateUserResponse]

  def getUser(username: String): UserDetail =
    get(s"/users/${URLEncoder.encode(username, "UTF-8")}.json").as[UserDetail]

  def updateUser(user: User): UpdateUserStatus =
    put(s"/users/${URLEncoder.encode(user.username, "UTF-8")}", user).as[UpdateUserStatus]

  def updateEmail(username: String, email: String) {
    put(s"/users/${URLEncoder.encode(username, "UTF-8")}/preferences/email",
      UpdateEmail(
        email = email,
        apiKey = self.credentials.get.api_key,
        apiUsername = self.credentials.get.api_username
      )
    )
  }

  def updateUsername(currentUsername: String, newUsername: String) {
    put(s"/users/${URLEncoder.encode(currentUsername, "UTF-8")}/preferences/username",
      UpdateUsername(
        newUsername = newUsername,
        apiKey = self.credentials.get.api_key
      )
    )
  }

  /*Admin access needed*/
  def updateTrustLevel(userId: Int, level: Int) {
    put(s"/admin/users/$userId/trust_level",
      UpdateTrustLevel(
        userId = userId,
        level = level
      )
    )
  }

  def suspendUser(userId: Int, suspendUser: SuspendUser) {
    put(s"/admin/users/$userId/suspend",
      suspendUser
    )
  }

  def unsuspendUser(userId: Int, level: Int) {
    put(s"/admin/users/$userId/unsuspend")
  }

  def listUsers(kind: String): Array[User] =
    get(s"/admin/users/list/$kind.json").as[Array[User]]

}
