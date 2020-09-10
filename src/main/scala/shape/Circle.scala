package shape

case class Circle(itsRadius: Double, itsCenter: Point) extends Shape {
  override def getType: String = "circle"
  override def draw(): Unit = ???
}
