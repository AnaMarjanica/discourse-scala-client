package com.amarjanica.discourse

package object api {
  implicit class RichString(s: String) {

    import BaseHttpClient._

    def asEither[L, R](implicit mL: Manifest[L], mR: Manifest[R]): Either[L, R] = try {
      Right(fromJson[R](s, mR.runtimeClass.asInstanceOf[Class[R]]))
    } catch {
      case e: Exception =>
        Left(fromJson[L](s, mL.runtimeClass.asInstanceOf[Class[L]]))
    }

    def as[T](implicit m: Manifest[T]): T =
      fromJson[T](s, m.runtimeClass.asInstanceOf[Class[T]])

    def asList[T](implicit m: Manifest[T]): List[T] =
      fromJsonList[T](s, m.runtimeClass.asInstanceOf[Class[T]])
  }

}
