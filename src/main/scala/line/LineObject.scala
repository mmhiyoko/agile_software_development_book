package line

abstract class LineObject(private var itsP1: Point, private var itsP2: Point) {
  def isOn(point: Point): Boolean

  def getInstercept: Double = getP1.y - getSlope * getP1.x

  def getSlope: Double = (getP1.x - getP2.x) / (getP1.y - getP2.y)

  def getP1: Point = itsP1

  def getP2: Point = itsP2
}
