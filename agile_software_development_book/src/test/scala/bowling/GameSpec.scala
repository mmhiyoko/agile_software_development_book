package bowling

import helper.ScalaTestSpec

class GameSpec extends ScalaTestSpec {
  trait SetUp {
    val g = new Game()
  }

  "ゲームのスコア計算について" should {
    "1度投げた時" in new SetUp {
      g.add(5)
      g.score shouldEqual 5
    }

    "2度投げて一度もマークが取れない時" in new SetUp {
      g.add(5)
      g.add(4)
      g.score shouldEqual 9
    }

    "4度投げて一度もマークが取れない時" in new SetUp {
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
