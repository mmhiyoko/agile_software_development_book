package bowling

class Game {
  private var itsCurrentFrame: Int = 1
  private var firstThrowInFrame: Boolean = true

  private val itsScorer = new Scorer

  def score: Int = scoreForFrame(getCurrentFrame-1)

  def add(pins: Int): Unit = {
    itsScorer.addThrow(pins)
    adjustCurrentFrame(pins)
  }

  private def adjustCurrentFrame(pins: Int): Unit = {
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

  def scoreForFrame(frame: Int): Int = itsScorer.scoreForFrame(frame)

  def getCurrentFrame: Int = itsCurrentFrame
}
