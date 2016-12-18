package com.amarjanica.discourse.api.models

case class SignatureNotMatchedException(msg: String) extends Exception
case class DiscourseApiException(msg: String, err: Throwable) extends Exception(msg, err) {
  def this(msg: String) = this(msg, None.orNull)
}
case class DiscourseApiJsonException(msg: String, err: Throwable) extends Exception(msg, err) {
  def this(msg: String) = this(msg, None.orNull)
}
case class DiscourseApiUnauthenticatedException(msg: String, err: Throwable) extends Exception(msg, err) {
  def this(msg: String) = this(msg, None.orNull)
}
case class DiscourseApiNotFoundException(msg: String, err: Throwable) extends Exception(msg, err) {
  def this(msg: String) = this(msg, None.orNull)
}