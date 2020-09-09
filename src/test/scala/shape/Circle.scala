package shape

case class Circle(itsType: ShapeType, itsRadius: Double, itsCenter: Point)

trait DrawCircle {
  def draw(circle: Circle): Unit
}
