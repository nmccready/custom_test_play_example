package models

trait IModel[T] {
  final def isEqualTo(other: T, useID: Boolean, idFunc: () => Boolean): Boolean =
    useID match {
      case true => idFunc.apply()
      case false =>
        true
    }

  def isEqualTo(other: T, useID: Boolean): Boolean

  def compareOption[T](opt1: Option[T], opt2: Option[T], compareFunc: () => Boolean): Boolean =
    (opt1.isDefined, opt2.isDefined) match {
      case (true, true) =>
        compareFunc.apply()
      case (false, false) =>
        true
      case _ => false
    }

  def compareOption[T](opt1: Option[T], opt2: Option[T]): Boolean = {
    compareOption(opt1, opt2, () => opt1.get == opt2.get)
  }
}
