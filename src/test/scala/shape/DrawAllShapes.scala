package shape

trait DrawAllShapes {
  def drawAllShapes(list: List[Shape]): Unit =
    list.foreach { shape =>
      shape.draw()
    }
}
