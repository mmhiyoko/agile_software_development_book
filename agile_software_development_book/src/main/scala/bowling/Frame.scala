package bowling

class Frame {
  private var itsScore = 0

  def getScore: Int = itsScore

  def add(pins: Int): Unit = {
    itsScore += pins
  }

}
