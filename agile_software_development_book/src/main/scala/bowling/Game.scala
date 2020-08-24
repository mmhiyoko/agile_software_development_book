package bowling

class Game {
  private var itsCurrentFrame: Int = 1
  private var firstThrowInFrame: Boolean = true

  private val itsScorer = new Scorer

  def score: Int = scoreForFrame(itsCurrentFrame-1)

  def add(pins: Int): Unit = {
    itsScorer.addThrow(pins)
    adjustCurrentFrame(pins)
  }

  private def adjustCurrentFrame(pins: Int): Unit = {
    if (firstThrowInFrame) {
      if (adjustFrameForStrike(pins) == false)
        firstThrowInFrame = false
    } else {
      firstThrowInFrame = true
      advanceFrame
    }
  }

  private def adjustFrameForStrike(pins: Int): Boolean = {
    if (pins == 10) {
      advanceFrame
      true
    } else
      false

  }

  private def advanceFrame: Unit =
    itsCurrentFrame = Math.min(11, itsCurrentFrame + 1)

  def scoreForFrame(frame: Int): Int = itsScorer.scoreForFrame(frame)

  def getCurrentFrame: Int = itsCurrentFrame
}
