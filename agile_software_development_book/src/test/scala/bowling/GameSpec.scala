package bowling

import helper.ScalaTestSpec

class GameSpec extends ScalaTestSpec {
  trait SetUp {
    val g = new Game()
  }

  "ゲームのスコア計算について" should {
    "現在のフレームを取得できる" in new SetUp {
      g.getCurrentFrame shouldEqual 1
    }

    "2度投げて一度もマークが取れない時" in new SetUp {
      g.add(5)
      g.add(4)
      g.score shouldEqual 9
      g.getCurrentFrame shouldEqual 2
    }

    "4度投げて一度もマークが取れない時" in new SetUp {
      g.add(5)
      g.add(4)
      g.add(7)
      g.add(2)
      g.score shouldEqual 18
      g.scoreForFrame(1) shouldEqual 9
      g.scoreForFrame(2) shouldEqual 18
      g.getCurrentFrame shouldEqual 3
    }

    "スペアを取った時" in new SetUp {
      g.add(3)
      g.add(7)
      g.add(3)
      g.scoreForFrame(1) shouldEqual 13
      g.getCurrentFrame shouldEqual 2
    }

    "スペアを取った後のフレームについて" in new SetUp {
      g.add(3)
      g.add(7)
      g.add(3)
      g.add(2)
      g.scoreForFrame(1) shouldEqual(13)
      g.scoreForFrame(2) shouldEqual(18)
      g.score shouldEqual 18
      g.getCurrentFrame shouldEqual 3
    }

    "ストライクを取った時" in new SetUp {
      g.add(10)
      g.add(3)
      g.add(6)
      // g.scoreForFrame(1) shouldEqual 19
      g.score shouldEqual 28
      g.getCurrentFrame shouldEqual 3
    }

    "パーフェクトゲームの時" in new SetUp {
      for (_ <- 1 to 12) {
        g.add(10)
      }
      g.score shouldEqual 300
      g.getCurrentFrame shouldEqual 11
    }

    "最後にストライクの時" in new SetUp {
      for (_ <- 1 to 9) {
        g.add(0)
        g.add(0)
      }
      g.add(2)
      g.add(8)
      g.add(10)
      g.score shouldEqual 20
    }

    "サンプルケースの時" in new SetUp {
      g.add(1)
      g.add(4)
      g.add(4)
      g.add(5)
      g.add(6)
      g.add(4)
      g.add(5)
      g.add(5)
      g.add(10)
      g.add(0)
      g.add(1)
      g.add(7)
      g.add(3)
      g.add(6)
      g.add(4)
      g.add(10)
      g.add(2)
      g.add(8)
      g.add(6)
      g.score shouldEqual 133
    }
  }
}
