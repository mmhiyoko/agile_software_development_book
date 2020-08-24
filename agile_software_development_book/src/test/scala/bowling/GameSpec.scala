package bowling

import helper.ScalaTestSpec

class GameSpec extends ScalaTestSpec {
  "ゲームのスコア計算について" should {
    "1度投げた時" in {
      val g = new Game()
      g.add(5)
      g.score shouldEqual 5
    }

    "2度投げて一度もマークが取れない時" in {
      val g = new Game()
      g.add(5)
      g.add(4)
      g.score shouldEqual 9
    }

    "4度投げて一度もマークが取れない時" in {
      val g = new Game()
      g.add(5)
      g.add(4)
      g.add(7)
      g.add(2)
      g.score shouldEqual 18
      g.scoreForFrame(1) shouldEqual 9
      g.scoreForFrame(2) shouldEqual 18
    }
  }
}
