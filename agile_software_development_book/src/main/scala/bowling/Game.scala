package bowling

class Game {
  private var itsScore: Int = 0
  private var itsThrows: List[Int] = List.empty
  private var itsCurrentFrame: Int = 1
  private var firstThrow: Boolean = true

  def score: Int = itsScore

  def add(pins: Int): Unit = {
    itsThrows = itsThrows :+ pins
    itsScore += pins
    adjustCurrentFrame
  }

  def adjustCurrentFrame: Unit = {
    if (firstThrow) {
      firstThrow = false
    } else {
      firstThrow = true
      itsCurrentFrame += 1
    }
  }

  def scoreForFrame(frame: Int): Int = {
    val frames = itsThrows.grouped(2).take(frame)
    val nextFrames = itsThrows.grouped(2).take(frame+1).toList.tail :+ List(0, 0)
    frames.zip(nextFrames).foldLeft(0: Int)((acc: Int, v: (List[Int], List[Int])) => {
      v._1 match {
        case firstThrow :: secondThrow :: _ =>
          if (firstThrow + secondThrow == 10) {
            acc + firstThrow + secondThrow + v._2.headOption.getOrElse(0)
          }
          else {
            acc + firstThrow + secondThrow
          }
        case throws => acc + throws.sum
      }
    })
  }

  def getCurrentFrame: Int = itsCurrentFrame
}
