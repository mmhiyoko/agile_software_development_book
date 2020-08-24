package bowling

class Game {
  private var itsScore: Int = 0
  private var itsThrows: List[Int] = List.empty
  private var itsCurrentFrame: Int = 1
  private var firstThrow: Boolean = true

  def score: Int = scoreForFrame(getCurrentFrame-1)

  def add(pins: Int): Unit = {
    itsThrows = itsThrows :+ pins
    itsScore += pins
    adjustCurrentFrame(pins)
  }

  def adjustCurrentFrame(pins: Int): Unit = {
    if (firstThrow) {
      if (pins == 10)
        itsCurrentFrame += 1
      else
        firstThrow = false
    } else {
      firstThrow = true
      itsCurrentFrame += 1
    }
  }

  def scoreForFrame(frame: Int): Int = {
    var ball = 0
    var score = 0
    for (currentFrame <- 1 to frame) {
      val firstThrow = itsThrows.apply(ball)
      ball += 1
      if (firstThrow == 10) {
        score += 10 + itsThrows.apply(ball) + itsThrows.apply(ball+1)
      } else {
        val secondThrow = itsThrows.apply(ball)
        ball += 1
        val frameScore = firstThrow + secondThrow
        if (frameScore == 10)
          score += frameScore + itsThrows.apply(ball)
        else
          score += frameScore
      }
    }
    score
  }

  def getCurrentFrame: Int = itsCurrentFrame
}
