package shape

case class Square(itsSide: Double, itsTopLeft: Point) extends Shape {
  override def getType: String = "square"
  override def draw(): Unit = ???
}
