// get positions of element in a string
"abcdefgccc".zipWithIndex.filter(pair => pair._1 == 'c').map(pair => pair._2)

// get positions of element in list
List(1,2,3,2,1).zipWithIndex.filter(pair => pair._1 == 2).map(pair => pair._2)

// count char occurences
string.count(_ == char)

// get largest elements from a list
List(4,1,1,4,1,3).groupBy(identity).maxBy(_._1)

// get most common elements from a list
List(4,1,1,1,3).groupBy(identity).maxBy(_._2.size)


// get the index whilst iterating
"a,b,c".split(",").zipWithIndex.map {
  case (elem, idx) => println(f"$idx: $elem")
}

// get all the pair combinations from two lists
def computePairs[T](data: List[T]): List[(T, T)] =
  data
    .tails
    .filter(_.nonEmpty)
    .flatMap(xs => xs.tail.map((xs.head, _)))
    .toList

def printMatrix(matrix: Array[Array[Char]]) =
  matrix.map(elem =>
    println(elem.mkString(" "))
  ).mkString("Array(", ", ", ")")

def isLegalMove(maze: Array[Array[Char]], row:Int, col:Int) : Boolean =
  if row <0 || col <0 then
    false
  else if row >= maze.length || col >= maze(0).length then
    false
  else
    true

def floodFill(maze: Array[Array[Char]], row: Int, col: Int) : Unit =
  if !isLegalMove(maze, row, col) then
    return

  if "0 #".contains(maze(row)(col)) then
    return

  maze(col)(row) = ' ' // mark the point so that I know if I passed through it.

  floodFill(maze, row + 1, col) // south
  floodFill(maze, row - 1, col) // north
  floodFill(maze, row, col + 1) // east
  floodFill(maze, row, col - 1) // west

  return ()


