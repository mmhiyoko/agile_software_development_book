package rectangle

case class Rectangle(private var itsHeight: Double,
                     private var width: Double,
                     private var height: Double) {
  def setWidth(w: Double): Unit =
    width = w

  def setHeight(h: Double): Unit =
    height = h

  def getHeight: Double = height

  def getWidth: Double = width

  def area: Double = height * width
}
