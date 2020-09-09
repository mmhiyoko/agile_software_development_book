package shape

trait DrawAllShapes {
  def drawAllShapes(list: List[Shape]): Unit =
    list.sortWith((lhs, rhs) => lhs.preceeds(rhs)).foreach { shape =>
      shape.draw()
    }
}
