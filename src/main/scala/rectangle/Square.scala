package rectangle

case class Square(private var isTopLeft: Double,
                  private var height: Double,
                  private var width: Double)
    extends Rectangle(isTopLeft, height, width)
