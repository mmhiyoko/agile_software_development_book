package shape

trait Shape {
  def draw(): Unit
  def getType: String

  private val typeOrderTable: List[String] = List("square", "circle")

  def preceeds(shape: Shape): Boolean =
    typeOrderTable.indexOf(this.getType) < typeOrderTable.indexOf(shape.getType)
}
