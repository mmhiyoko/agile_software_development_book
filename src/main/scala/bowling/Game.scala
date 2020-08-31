package bowling

class Game {
  private var itsCurrentFrame: Int = 0
  private var firstThrowInFrame: Boolean = true

  private val itsScorer = new Scorer

  def score: Int = scoreForFrame(itsCurrentFrame)

  def add(pins: Int): Unit = {
    itsScorer.addThrow(pins)
    adjustCurrentFrame(pins)
  }

  private def adjustCurrentFrame(pins: Int): Unit = {
    if (lastBallInFrame(pins)) {
      advanceFrame
    } else
      firstThrowInFrame = false
  }

  private def lastBallInFrame(pins: Int): Boolean =
    strike(pins) || !firstThrowInFrame

  private def strike(pins: Int): Boolean = firstThrowInFrame && pins == 10

  private def advanceFrame: Unit = {
    firstThrowInFrame = true
    itsCurrentFrame = Math.min(10, itsCurrentFrame + 1)
  }

  def scoreForFrame(frame: Int): Int = itsScorer.scoreForFrame(frame)

  def getCurrentFrame: Int = itsCurrentFrame
}
