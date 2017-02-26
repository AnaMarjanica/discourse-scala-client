package com.amarjanica.discourse
package api

import java.net.URLEncoder

import com.amarjanica.discourse.models._

class UserApi(client: BaseDiscourseClient) {

  /*This will not work if you have local logins disabled!*/
  def create(createUserRequest: CreateUser): CreateUserResponse =
  client.post("/users", createUserRequest).as[CreateUserResponse]

  def get(username: String): UserDetail =
    client.get(s"/users/${URLEncoder.encode(username, "UTF-8")}.json").as[UserDetail]

  def update(user: User): UpdateUserStatus =
    client.put(s"/users/${URLEncoder.encode(user.username, "UTF-8")}", user).as[UpdateUserStatus]

  def updateEmail(username: String, email: String) {
    client.put(s"/users/${URLEncoder.encode(username, "UTF-8")}/preferences/email",
      UpdateEmail(
        email = email,
        apiKey = client.credentials.get.api_key,
        apiUsername = client.credentials.get.api_username
      )
    )
  }

  def updateUsername(currentUsername: String, newUsername: String) {
    client.put(s"/users/${URLEncoder.encode(currentUsername, "UTF-8")}/preferences/username",
      UpdateUsername(
        newUsername = newUsername,
        apiKey = client.credentials.get.api_key
      )
    )
  }

  /*Admin access needed*/
  def updateTrustLevel(userId: Int, level: Int) {
    client.put(s"/admin/users/$userId/trust_level",
      UpdateTrustLevel(
        userId = userId,
        level = level
      )
    )
  }

  def suspend(userId: Int, suspendUser: SuspendUser) {
    client.put(s"/admin/users/$userId/suspend",
      suspendUser
    )
  }

  def unsuspend(userId: Int, level: Int) {
    client.put(s"/admin/users/$userId/unsuspend")
  }

  def list(kind: String): List[User] =
    client.get(s"/admin/users/list/$kind.json").asList[User]

}
