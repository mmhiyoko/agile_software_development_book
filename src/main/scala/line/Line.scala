package line

abstract class Line(private var itsP1: Point, private var itsP2: Point) {
  def getSlope: Double
  def getInstercept: Double
  def isOn(point: Point): Boolean

  def getP1: Point = itsP1
  def getP2: Point = itsP2
}
