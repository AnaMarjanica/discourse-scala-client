package com.amarjanica.discourse.models

case class SignatureNotMatchedException(msg: String) extends Exception(msg)
case class DiscourseApiException(msg: String, err: Throwable) extends Exception(msg, err) {
  def this(msg: String) = this(msg, null)
}
case class DiscourseApiJsonException(msg: String, err: Throwable) extends Exception(msg, err) {
  def this(msg: String) = this(msg, null)
}
case class DiscourseApiUnauthenticatedException(msg: String, err: Throwable) extends Exception(msg, err) {
  def this(msg: String) = this(msg, null)
}
case class DiscourseApiNotFoundException(msg: String, err: Throwable) extends Exception(msg, err) {
  def this(msg: String) = this(msg, null)
}