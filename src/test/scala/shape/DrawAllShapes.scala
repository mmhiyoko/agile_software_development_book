package shape

trait DrawAllShapes extends DrawCircle with DrawSquare {
  def drawAllShapes(list: List[Shape], n: Int): Unit = {
    list.foreach { shape =>
      shape.itsType match {
        case CircleType => draw(shape.asInstanceOf[Circle])
        case SquareType => draw(shape.asInstanceOf[Square])
      }
    }
  }
}
