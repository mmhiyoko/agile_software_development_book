package line

abstract class LineSegment(private var itsP1: Point, private var itsP2: Point)
    extends LineObject(itsP1, itsP2) {
  def getLength: Double
}
