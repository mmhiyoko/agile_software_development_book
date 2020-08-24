package bowling

import helper.ScalaTestSpec

class FrameSpec extends ScalaTestSpec {
  "スコアの計算について" should {
    "一度も投げていない時" in {
      val f= new Frame()
      f.getScore shouldEqual 0
    }
  }
}
