package bowling

class Game {
  private var itsScore: Int = 0
  private var itsThrows: Vector[Int] = Vector.empty

  def score: Int = itsScore

  def add(pins: Int): Unit = {
    itsThrows = itsThrows :+ pins
    itsScore += pins
  }

  def scoreForFrame(frame: Int): Int = {
    itsThrows.take(frame * 2).sum
  }
}
