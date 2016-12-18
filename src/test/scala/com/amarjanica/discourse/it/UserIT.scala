package com.amarjanica.discourse.it

import java.util.UUID

import com.amarjanica.discourse.api.models.CreateUser
import org.specs2.Specification


class UserIT extends Specification with BaseIT{
  def is = s2"""
      User controller api spec
      Create user - invalid data        $createUserInvalidData
      Create user                       $createUser
      Update user                       $updateUser
      Update user - username            $updateUserUsername
      Update user - level               $updateUserLevel
      List users                        $listUsers
  """

  def createUserInvalidData() =
    discourseClient.createUser(
      CreateUser(name = "",username="", email="",password="", active=false)
    ).success === false


  def createUser() = {
    getRandomUser._2
  }

  def updateUserUsername() = {
    val (userRes, isUserFound) = getRandomUser
    val newUsername = UUID.randomUUID().toString.take(20)
    val updatedUserUsername = {
      discourseClient.updateUsername(
        userRes.user.username,
        newUsername
      )
      discourseClient.getUser(newUsername)
    }
    val isUsernameUpdated = updatedUserUsername.user.username shouldEqual newUsername
    isUserFound and isUsernameUpdated
  }

  def updateUserLevel() = {
    val (userRes, isUserFound) = getRandomUser
    val updatedUserLevel = {
      discourseClient.updateTrustLevel(
        userRes.user.id,
        2
      )
      discourseClient.getUser(userRes.user.username)
    }
    val isTrustLevelUpdated = updatedUserLevel.user.trustLevel shouldEqual 2

    isUserFound and isTrustLevelUpdated
  }

  def updateUser() = {
    val (userRes, isUserFound) = getRandomUser
    val modifiedUser = userRes.user.copy(
      trustLevel = 2,
      email = Some("aaa@example.com"),
      name = Some("aaaa")
    )

    val updatedUser = discourseClient.updateUser(modifiedUser)

    val isUserUpdated =
      (updatedUser.success shouldEqual "OK") and
      (updatedUser.user.id should beGreaterThan(0)) and
      (updatedUser.user.name shouldEqual "aaaa") and
      (updatedUser.user.id shouldEqual modifiedUser.id) and
      (updatedUser.user.trustLevel shouldNotEqual modifiedUser.trustLevel) and
      (updatedUser.user.email shouldNotEqual modifiedUser.email)

    isUserFound and isUserUpdated
  }

  def listUsers = discourseClient.listUsers("active").nonEmpty should beTrue

  // -- Helper methods
  private def getRandomUser = {
    /*20 is default max chars for username*/
    val uuid = UUID.randomUUID.toString.take(20)
    val res = discourseClient.createUser(
      CreateUser(
        name = uuid,
        username = uuid,
        email = uuid+"@example.com",
        password = "testiramNesto123",
        active = true,
        staged = true
      )
    )
    val isUserCreated =
      (res.success and res.active.get) and
        (res.message shouldEqual "Your account is activated and ready to use.")

    val userRes = discourseClient.getUser(uuid)

    val isUserFound = userRes.user.username shouldEqual uuid and (userRes.user.id should beGreaterThan(0))
    (userRes, isUserCreated and isUserFound)
  }
}
