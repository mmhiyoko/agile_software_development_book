package bowling

class Game {
  private var itsScore: Int = 0
  private var itsThrows: List[Int] = List.empty
  private var itsCurrentFrame: Int = 1
  private var firstThrowInFrame: Boolean = true

  private var ball: Int = 0
  private var firstThrow: Int = 0
  private var secondThrow: Int = 0

  def score: Int = scoreForFrame(getCurrentFrame-1)

  def add(pins: Int): Unit = {
    itsThrows = itsThrows :+ pins
    itsScore += pins
    adjustCurrentFrame(pins)
  }

  def adjustCurrentFrame(pins: Int): Unit = {
    if (firstThrowInFrame) {
      if (pins == 10)
        itsCurrentFrame += 1
      else
        firstThrowInFrame = false
    } else {
      firstThrowInFrame = true
      itsCurrentFrame += 1
    }
    itsCurrentFrame = Math.min(11, itsCurrentFrame)
  }

  def scoreForFrame(frame: Int): Int = {
    ball = 0
    var score = 0
    for (currentFrame <- 1 to frame) {
      firstThrow = itsThrows.apply(ball)
      if (strike) {
        ball += 1
        score += 10 + nextTwoBalls
      } else {
        score += handleSecondThrow
      }
    }
    score
  }

  private def handleSecondThrow: Int = {
    var score = 0
    secondThrow = itsThrows.apply(ball+1)

    val frameScore = firstThrow + secondThrow
    if (spare) {
      ball += 2
      score += frameScore + nextBall
    } else {
      ball += 2
      score += frameScore
    }
    score
  }

  private def strike: Boolean = itsThrows.apply(ball) == 10

  private def nextTwoBalls: Int = itsThrows.apply(ball) + itsThrows(ball+1)

  private def spare: Boolean = itsThrows.apply(ball) + itsThrows.apply(ball+1) == 10

  private def nextBall: Int = itsThrows.apply(ball)

  def getCurrentFrame: Int = itsCurrentFrame
}
