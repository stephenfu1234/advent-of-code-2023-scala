import scala.collection.mutable
import java.io._

val sampleInput = "...........\n.....###.#.\n.###.##..#.\n..#.#...#..\n....#.#....\n.##..S####.\n.##..#...#.\n.......##..\n.##.#.####.\n.##..##.##.\n..........."
val puzzleInput = "...................................................................................................................................\n.##.....#...#...#....#....#...........#................#.#...............#.........#...................#..#.............#..........\n...#.....#....#.##..................#......................#...........#.##...#.....#................#...#.....#..#..#...#.##......\n.........#.#.....####.........#...........#.....#........................#..#.#........................##........#.............#...\n..#.......#.......................##....#..........##....................#..........#..........................#...#.............#.\n..#...................#.............................#.............................#.#...#..........#......#....#...##..............\n........#....##.......#......#.....................#...............#...........#...#..................#....................##......\n.............#.#.......#......#.........#........#..#.......................#.#...##.#.........#..#.#....##........#..#.#...#......\n........#....#..#..#..#..............#.........#..............................................#..##...##.#..#............#..###....\n............#..#...........#..#.#...#.#.....#....#..............................##..#......#..#.....#...##..................##.....\n....#.#..#.....#.#..............#..#..#......#..#..........#.......#..##..............##.#......#.......#..#....#.........#..#.....\n.......#.......#...........#.....#.....##..#..............#.....#.#................#..#..........#.....................#...........\n.##.#.............................#.#...........#.............#....#.#.#..........#..........#..............#......................\n....#.#...#...#............#....................................#............................#.....................#...........##..\n...#...................#....##....#.......#.............#............###..#.........##.......#...##.........#...........#.....#....\n..............#.......#...........................................##........#.........#.#....#.##....##...#........................\n.#.........##...#..#..#...#..........#......#........#............#..........#..................#..........#.#.......#.........#...\n......................#.........#...........#................#........#.#.....#..................#...##...#.#.#.#..................\n................................#.......#............#.........#..#......#..#.#..........#...............#...#......#..............\n......#.......#............#.......#....#.#........................#........................................#.......##.#.#.......#.\n......##..........#.###..........#....#........................#.....#.#............................#.......#......#.......#.......\n..##................#...#....#........#............#.........#.............#.#....#..........................#...............##....\n............#....#........#............#............#.........#.........#...#.....................#........##...#...............##.\n...................#..#.....#.....#..#........#.##......#.#.#.#...#....#..##.......................#..##....#.........#........#...\n..#.......#.#...#..#.........#..........................#....#.......................#........#......................#........#..#.\n.#............#..............#................#....#.....................##.....##.............#.#..#...#.......................#..\n....#.......#.........#..........................#.##................#......#...##...###............#....#............#............\n....#............#..............#.#...................................#..#...##......#.................##...........#..........#...\n.....#..#.......#.#..................................#.................#..#.........................#.........#....#........#......\n.....#..#.#.............#.#............................#.#.....#......#....#......................#..........#...........#.........\n...........#.###....#.......#..........#..........#.#....#..............###...#.........##.#.....................#.................\n....................#.....##..#...............##.....#.........#.......#...............#.#..............#...#.......#..#.#......#..\n.#.....#..#...........#...............................................#...............#..#............#....#.#.##...#.........#....\n.....#..##........##.....#.#........#....#.................................#.###............#...............##................#....\n.........#........#...##...........#.##.....#.#..#.................#.#..#.#..........#.................##.......##........#.#......\n....#......#..#..#......##....................#..#.........#........#.#.#...##............................#........#.#.#...#.....#.\n....#.......#.......#............................#...........#.............#...........#...#..#...........#................#.......\n..#..#.#..#...........#...........#....................#.#..#..........#.#.........#...#..#....#..........#........#...#...........\n...#....#..#.....................#.#......#.....#...#.......#.....#....##....###...#...........#.#............#.....#.#...###......\n..##....#......#...................#.....#.........##..............#................##.......#..#..................###.......#.....\n...#................#.........#.#.#...............#..#...#.....#.................#..#..#.#.................................###.....\n.#..#.....#.....#..#..............#.#.......#....#..#.#.................#..#.##......###..............#............###..#...#......\n....#........................#.........#...................#...#..................................#................................\n................#.#..............##..#......##..#..........#....#.......##..............#...............#...............#...#......\n................#..........#..........#...#....#...#............#..#..................................##.............#........#....\n..........#.#.................##..............#.##.......#.#...#...#.......#................#..#..........#...........#..#.#.......\n.......#...............#..#.#.........#.##............#........#.......#.....#.............#..##...................#...............\n...#..................#.............#...##.......#...#.......#..........#.....#....#...............#....#...........#.......#......\n.................................#.......#..#...........#..........#...#..#...............#............#.#...#.........#...........\n.....#.#.................................#............#.....#..........#......#..#.....#...........#....#...............#..........\n.#.........................#.......#..#.............#...#.....#.#...###......#.#....#...#.......#........##.#.............#.#......\n....#...............#......#.......#...#....#....#.#..#..#..#.#.......#.................#.....#..###...#...##......................\n.........#..........#.....##.#..#...#.....#.....#.#........................#............#.##.............................##...#....\n......................#......#......#..........#.......#.......#...................#...............#...##....#...................#.\n.....#.............#...............#....#.....#................#.....................#...#..#...#..............##..................\n.#.##................#................#..............#......................#.....#...........#.................#...............##.\n.....#...........#.#......#...........#####.##...............#..............#...#..##........#......#................#.............\n.##............#.........#............#.......##.....#...#..#..............#..........................#....#.#........#..........#.\n........................#.........#.#.....##.....#...........#.......#...#.........#..##.......................#..#............#...\n..............#............#..........#.......##....##..#..###.#.....#....#....#........................#.........#..#.............\n.........#.....#.........#..#..............#........#.............#......#....#......#..#...#............#...#.......#.............\n..........#.........#.....##.............#..#.......#...#.....#.............#..........##......................##....#....#........\n....................#.........................#....#...#.....#.....#..#.....##................#.###...#............................\n..............#...#..#..#.........#...........#.#.##........................#...#........................#..#..#............#......\n..............#...##.##...#.......................#................................#..........#....................#........#......\n.................................................................S.................................................................\n.............#.......#...............#.#..#..#.............#......#....#...#.#...........................#.#........#.#.#...#......\n............#.................................#....##.......#..#........#.........#..#......#....#.#.........#.#...#...#...........\n............#.#......##...##.......#..............#...............#.#.#...............###..#.........#.....................#.......\n.............#.........#..#......................#.......##........#........#...#........##........#.............#....#............\n.........................................#.............#..#.....#..#........#..#......#...##.......#...........#...................\n............#............#.#.........................##.....##..#........#..........#..............#.#...............##.........#..\n.......................#......#....................................#...#......#................#..............#....#............#..\n...............#...........##....#....#......#.................................#..#....#..#..#........#.........#...#..............\n....#..............#..#..#..#.........#............#......#..............#...#.....#.#......................#.##...................\n...#...........................#...........#......#...........................##...#..................#..#........#................\n................#..#.#...#.........#...........#...............#........#.....#............................#...#..#.........#......\n........#.......#......#...................##...#..#.......#...#........#..#......#...#.......#..##............#............#......\n..................................#........#.#...........#...#.#..#.......#..##...................#..#.........................#...\n..#...#................#......#........#.........##...#....#......##..#....................#..........##...........................\n....#..#..............#..........#....#.#....................##...#......##......#..................####.....................#.....\n...#.#....................#.#.#.#.......#.............#...##.#.......................#....................................##.......\n.......#..................#..#...#...#....#...#....#....#.........#.............................#......#...........................\n.............#...............................##.#...#........#.........##......#................#..#.#.....#.......................\n.....#...#.................#..#.#.............#.........#.....##..........#..#..#.................#.....#..#...........#...........\n.#...#.##..................#..##..............#....##..........#....#.....#.....#....#......#.......#..#...................#.....#.\n...#..#.......#..........#...#..#......##......#....#.........###....#...#.......#........#...#......#................#............\n..............#.............#...............#..........#.......#............................#.##..#..........................#.##..\n.#.##........#...................#........##.....#.....#...#......#.............#.#.#..#.##....###.....#..........#...##.#.#.......\n.#...#........#..#.#................#..#.#.#.#.....#..........#....................#...............#..#...........###..............\n....#.................................................#...........#......###....#.##.............#.............#...........#.##....\n...#...#..#.#..#...#..#........#...................#........................................................#....#....###..........\n...........#..#.......##............#..#........#.#...........#...##.........#........#.........#.............#............#.......\n................#.#.................................................#....#......#...#......#..#..................#........#....#...\n....##.........##...................##............#.........#...#.....................#........................#.......#....#...#..\n.....#.....#.......#.#...#.....................................#......#.......#..........................#.#........#.#..#...#..#..\n................#.....#.#..#........##..................#.......#.....#.....#.......#.#......#............................#........\n.#.#.......#........#.....#.................#..#.###..#........#..#.............##............#.......#....#.......#..#.#..#.#.....\n........#..#.........................#.........#..#.......#.................#..........#.....#.........#....#...............#.#....\n...........#..##.........#..................................#.#..............#..............#.......#.........................#....\n.#.....#...#..................#.........#..............#.#.......................#..#..............#.....#.#.....#......#.....#..#.\n.......#.......###...#...#......#.............#....#....#.###.#................#..........#................#.#...#.................\n.......#......#..............##..#................................#............#.#.................#...............................\n...........#................#...#.........#.......................#.....##...#......................#.##....##................##...\n.......##.................#....#...#...................#..##..#.........#........##..................#..........#..#.......#.......\n.....#............#...#.....#...............##....#.............#......#...#........#.........#..#.....#...#.........#.##......#...\n......#.#.....#............###.#......................................#.#..#.#.......................#..#...........#.#.......#....\n.....#..##........#.##..............#......................#...#...#...........................##......##.....#...........#........\n..##.#...#......#....###.#.#.....................#.#.........#............#.#..#.##........#.........#.........#...#...............\n......##...............#.#.........#..............#...............................#.......#........##.....#.#..#.........##........\n.#..#......#...#....#..#.........................#......#........................#.............#.#.........#............#.....#....\n.#..#..#......#..#.......#..##.#....#.#.#..........###..........................................#....#.............#.............#.\n.#.....#...#.#........#.#......##........#.........#...#........#........#.....#................#.......#...............###........\n......#..#......#...#...........#........#..........##.........##.......##...#..............................#.#..................#.\n....#................#..#.#..#.........................###...........##..#...........#.......#.....#......##......#........#.......\n...#...#...#..............#....#......##...............#.....#.........#.#................##..........#........#................#..\n.#.............#...................#.....#.#.................#..#.........#.............#.......#.......#.....#...#.........#......\n........#........#...........#...#...#.....#............#....#.#..#....................................##...#......#..#..........#.\n.................#.#.....#........#..........#.#.#.......#.#..##....#.................#........#......#..#..#..#.....#.....#.#.....\n...#.....#....#.....#....#...#..#.......#....#...#......................#............#..........#......................#...........\n....#....#......#............#..#.#.......#......#..........#.#.......#..............................#..#....##..#.......#.....#.#.\n.#.......#.#......##.#..#..#.......#.#........#.................#......................................#.......................#...\n..........................#......#..............##..#.........#.....#..............#............#.....#..........##....##........#.\n....#....#.##........#..#.......................#.................................#.#.##................##...........#.........#...\n...#......#...#............#...#.....#...#..#.##.....#............#.....................#...#.....................#.....#..........\n................##........#...#.................##..................................#.......##...............##....#...........#...\n.....................##...............#.........#.............................#........#.........#...........#.........#.#.....#...\n...#.....#........#.#............#...##.#.#.#.......#........................#.........#.......##......#.........#..#..##....#.....\n.....#...........#...#..........#..#.#.........................................#....................#.........#....#.....#.....##..\n...#..................................#..........#.......#................#.....##.#....#.#........#........#................#.#...\n..................................................................................................................................."

val sampleInput2 = ".................................\n.....###.#......###.#......###.#.\n.###.##..#..###.##..#..###.##..#.\n..#.#...#....#.#...#....#.#...#..\n....#.#........#.#........#.#....\n.##...####..##...####..##...####.\n.##..#...#..##..#...#..##..#...#.\n.......##.........##.........##..\n.##.#.####..##.#.####..##.#.####.\n.##..##.##..##..##.##..##..##.##.\n.................................\n.................................\n.....###.#......###.#......###.#.\n.###.##..#..###.##..#..###.##..#.\n..#.#...#....#.#...#....#.#...#..\n....#.#........#.#........#.#....\n.##...####..##..S####..##...####.\n.##..#...#..##..#...#..##..#...#.\n.......##.........##.........##..\n.##.#.####..##.#.####..##.#.####.\n.##..##.##..##..##.##..##..##.##.\n.................................\n.................................\n.....###.#......###.#......###.#.\n.###.##..#..###.##..#..###.##..#.\n..#.#...#....#.#...#....#.#...#..\n....#.#........#.#........#.#....\n.##...####..##...####..##...####.\n.##..#...#..##..#...#..##..#...#.\n.......##.........##.........##..\n.##.#.####..##.#.####..##.#.####.\n.##..##.##..##..##.##..##..##.##.\n................................."

val cache = mutable.HashMap[(Int,Int,Int), Int]()

def getStartingPosition(mapMatrix: Array[Array[Char]]): (Int,Int) =
  mapMatrix.zipWithIndex.map{
    (row, rowIndex) => row.zipWithIndex.map {
      (colChar, colIndex) =>
        if(colChar == 'S')
          return (rowIndex, colIndex)
    }
  }
  (-1,-1) // no starting position found, should never get here unless bad puzzle input

def isLegalMove(maze: Array[Array[Char]], row:Int, col:Int) : Boolean =
  if row <0 || col <0 then
    false
  else if row >= maze.length || col >= maze(0).length then
    false
  else
    true

def floodFill(maze: Array[Array[Char]], row: Int, col: Int, stepCounter: Int, maxSteps: Int) : Unit =
  if !isLegalMove(maze, row, col) then
    return

  if cache.contains((row,col,stepCounter)) then
    return

  if "0#".contains(maze(row)(col)) then
    return

  cache((row,col,stepCounter)) = 1

  if stepCounter == maxSteps then
    maze(row)(col) = 'O' // mark the final step
    return
//  else
//    maze(row)(col) = ' ' // mark the point so that I know if I passed through it.

  floodFill(maze, row + 1, col, stepCounter + 1, maxSteps) // south
  floodFill(maze, row - 1, col, stepCounter + 1, maxSteps) // north
  floodFill(maze, row, col + 1, stepCounter + 1, maxSteps) // east
  floodFill(maze, row, col - 1, stepCounter + 1, maxSteps) // west


def parse(input: String): Array[Array[Char]] =
  input.linesIterator.map(_.toCharArray).toArray

def parseAndExtend(input: String, multiplier: Int): Array[Array[Char]] =
  val extendedInput = ((input.replace('S', '.') + "\n") * multiplier) + input + "\n" + ((input.replace('S', '.') + "\n") * multiplier)

  extendedInput.linesIterator.map( line =>
    (line.replace('S', '.') * multiplier).toCharArray.concat(line.toCharArray).concat((line.replace('S', '.') * multiplier).toCharArray)
  ).toArray

def printMatrix(matrix: Array[Array[Char]]) =
  matrix.map(elem =>
    println(elem.mkString(" "))
  ).mkString("Array(", ", ", ")")

def countFinalStepLocations(matrix: Array[Array[Char]]) : Int =
  matrix.map( line =>
    line.count(_ == 'O')
  ).sum

def partOne(input: String, maxSteps: Int): Int =
  cache.clear()
  val maze = parse(input)
  val (rowIndex, colIndex) = getStartingPosition(maze)

  floodFill(maze, rowIndex, colIndex, 1, maxSteps+1)
  printMatrix(maze)
  countFinalStepLocations(maze)


def partTwo(input: String, maxSteps: Int, boardMultiplier: Int): Array[Array[Char]] =
  cache.clear()
  val maze = parse(input)

  val extendedMaze = parseAndExtend(input, boardMultiplier)
  val (rowIndex, colIndex) = getStartingPosition(extendedMaze)
//  println(f"starting pos $rowIndex $colIndex")
//  extendedMaze(1+(rowIndex*boardMultiplier))(1+(colIndex*boardMultiplier)) = 'S'
  // extend the maze by 10 and try to detect the increase

  floodFill(extendedMaze, rowIndex, colIndex, 1, maxSteps+1)
//  printMatrix(extendedMaze)
//  println()
  val finalStepLocations = countFinalStepLocations(extendedMaze)
//  println(f"maxSteps: $maxSteps = $finalStepLocations")
  println(f"$finalStepLocations")
//  val pw = new PrintWriter(new File("maze.txt"))
//  extendedMaze.foreach(line =>
//    pw.write(line)
//  )
//
//  pw.close

  extendedMaze






//vr startTime = System.currentTimeMillis()
//partOne(sampleInput, 6)
//var timeTaken = System.currentTimeMillis() - startTime
//println(f"Part One Sample Input Time Taken: $timeTaken ms")
//
//startTime = System.currentTimeMillis()
//partOne(puzzleInput, 64)
//timeTaken = System.currentTimeMillis() - startTime
//println(f"Part One Puzzle Input Time Taken: $timeTaken ms")a

//printMatrix(partTwo(sampleInput, 100, 25))
//val mazes = (1 to 75).map( i=>
//  partTwo(sampleInput, i, 25)
//)


//printMatrix(mazes.last)
//printMatrix(partTwo(sampleInput, 100, 25))
//printMatrix(partTwo(puzzleInput, 196, 2))
//partTwo(puzzleInput, 458, 4)
//val mazes = (1 to 588).map( i=>
//  partTwo(puzzleInput, i, 3)
//)
// the board is constructed that the mod is equal to the number of steps required to go from
// starting position to edge of first board
// then the remainder is Math.floor(maxSteps / size) which is the number of subsequent complete boards
// therefore this is a quadratic equation
// use part 2 to extend the board and calculate steps 65, 196 and 327 (i.e. 65 +131+131 board size)
// this gives us a quadratic sequence for which we can use https://sequencecalculators.com/sequence-formula-calculator/
// to give us the formula.  Then plug in the number of cycles which becomes the formula below
Math.floor(26501365 / 131) = 202300
n = 202300 +1 = 202301
(202301L*202301L*15173L)-(202301L*15054L)+3740L = 620962518745459

def partTwoCalc(input: String, maxSteps: Int) =
  val maze = parse(input)

  val size = maze.length

  val cycles = Math.floor(maxSteps / size)
  val mod = maxSteps % size