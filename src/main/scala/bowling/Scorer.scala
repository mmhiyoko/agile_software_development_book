package bowling

class Scorer {
  private var itsThrows: List[Int] = List.empty
  private var itsCurrentThrow: Int = 0

  private var ball: Int = 0

  def addThrow(pins: Int): Unit = {
    itsThrows = itsThrows :+ pins
    itsCurrentThrow += 1
  }

  def scoreForFrame(frame: Int): Int = {
    ball = 0
    var score = 0
    for (currentFrame <- 1 to frame) {
      if (strike) {
        score += 10 + nextTwoBallsForStrike
        ball += 1
      } else if (spare) {
        score += 10 + nextBallForSpare
        ball += 2
      } else {
        score += twoBallsInFrame
        ball += 2
      }
    }
    score
  }

  private def strike: Boolean = itsThrows.apply(ball) == 10

  private def nextTwoBallsForStrike: Int =
    itsThrows.apply(ball + 1) + itsThrows(ball + 2)

  private def spare: Boolean =
    (itsThrows.apply(ball) + itsThrows.apply(ball + 1)) == 10

  private def nextBallForSpare: Int = itsThrows.apply(ball + 2)

  private def twoBallsInFrame: Int =
    itsThrows.apply(ball) + itsThrows.apply(ball + 1)
}
