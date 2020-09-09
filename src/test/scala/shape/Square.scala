package shape

case class Square(itsType: ShapeType, itsSide: Double, itsTopLeft: Point)

trait DrawSquare {
  def draw(square: Square): Unit
}
