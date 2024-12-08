import scala.annotation.tailrec

val sampleInput = "O....#....\nO.OO#....#\n.....##...\nOO.#O....O\n.O.....O#.\nO.#..O.#.#\n..O..#O..O\n.......O..\n#....###..\n#OO..#...."
val puzzleInput = ".OO..##.###..#O.O..O#.OOO.....#..O##O#.OO...O..##.O.O.......##O...O...O#O.O.#..O..O.#O..OO...#......\n....OO..#.#...O#.O..#O..#OO...OO..O......O#........O...#..OO..#.#.O#..OO...O####.O...O.O.#.O..O.O..O\n.O#.......O.OO#OO##O#O..O.O....#.OO..O...O.OO........O..#...O.O......##....O.....##.O.#.#.O..O......\n..##.#.....#..#.O#O...O..O...OOO.##O.O##...O#.OO.#....OOO.OO.#O.O.O#...OO.OO.....O#..#...O...OO#...O\nOO..#..OO#..#..O..#O..O.O##O#OOO.#...OO.#....#..#....O.####O.##..O......#O..OOO#O.#...#.O...OO...OO#\n#.O.#O.#.#..O.#.............#.#.OO......#.O.O##O###........#.....#.....#.....O.O.OO.O....O.......O.#\nO#...#...........#..OO...O..#.....#...O.#.......O#.....##O#.OO##.......#..O......#..O..O.#O.#.#..O.#\nOO...O##..O.#.......O#.........OO#..O..#O..#OO.O........#.O.O.O....OO#...#.#.#O...##O.#OO.#.....#..O\n#OO...O...O...O....O...............O.#O..OO##O##O.....#.##...OO.O.#.##.##.O..#..#.O..#.#..O.........\n.O..O.#...##..#.#OO....#.O#...OO#.......O..OO.#...OO##..O..O...O.O...O.#.O#.....O..OO.O.#.OO..#.##..\n...OO.O.O.O#....#...O...#....OO.#O.#O..O.OO..OOO.O....#O.#...#.O#.O............#......O.O....#OO##.#\n...#O......#O#..O....#.##..O.O.O#..#O.#O...O...#..#O..##.O#..O#....O##.O.#OOO.#........O##.OO.O..OO#\n#OOO....#O...O.O....O.......O...O..#....##.#..#.O#O#.O#....#.#.#O#....#.#.....##.#O..OOO....#.O.....\n#OO.O...#O.O....O..#..O.#....#....O#..O...##..#..OO#.....#O.O#O..O....#OO....##OO....#...OOOO.OO###.\nO..#..O#.O.#..OO.#.OO...O..O......#........#O......O.OO.#....#..O#O.......OO##O..##OOOO.#.#OOO.....O\n...#OO.#OO.O.##.O#.OO#...#..#.O##O#...#.#O...#.....#..O..O....O.OO.O.#..O.#.O...#.O#..O....O.#...O#.\n#....O.....O.O...#..O....#..O..O.OO...#....O..O...#.....#...#....O.#.OO...OO#...O....#O.O..O.OO.O..O\n..O#.....#O#....#.....OOO.#.......OO.O..#.#....#O......O.#.O.#..O...#.O...O..O.##O.O#O..#.O......#.#\n....#O#.#..O#.OO.#.#.O.#......#OO...O#OO.........OOO..##...#..##O#..OOO...O..O..O##O...#..#.O.O..#..\n..O#.O.......OOO..##..#...#....#.#..#O.OO..O..##..OO#.O...O..#OO...##O.#O..OO.....#O..#.....#O.....#\n...OO.O.#.O.O..##O#...OO...##.O..OOO##.O.O.#..#.OO..O...O.#....O.O.....O##.#O.O.O#.#.......OO#......\nO...#.O...O...#..OO...O..#..#........O...#...#......O#.#.....O.#.........#.#......O#O.O.........#...\n.......O#...#...........O.#O#.O#.#.O.O..O..OO.#......##.OO..#......OO#....#O#OO.O.#..O#..O.OO..O..##\n.O.....O.#.........O...O...O...O...OOOO..O....OO....#.#....O#.#..#.OO.OO....#.......#...#OO.....O.OO\nO....OO....O..O.OO.###..O##.OO.#......O.O...##...#O...O..O...##.O.O...O....O.#OO.....O.....O.O.OO.OO\n#O......OO....##..O..###.O....#.#.#.OO.............O.O.OOOO#.O.O..#O...O#..O......O.O.O.#.#.......O.\nO#O.....#...#..O#.#....#..###..O..O...#....O....##.....#...O#.#.O.O......O..OOOOO....OO..#...#.OO#..\n..O........OO....##...#O.....#.O.....O#.O..#.O.#.O......O#...OOO....O...#..OO....O..#...O.O..##.....\nO...O..O.O....O.OO.O.OO..OO...#O...O.#.O..#O...#...#...O..##...#...OO#.....##..O#O.O....#.....OO#..O\n...O#O..O..##.OO.......#.#O...O..#.#...#.O.#O##OOO.OOO...#.....O....##.....OOO.....O..O.O#.O....O...\nO#..#O.O....#.........O#.OO#...OO......#......O.#...............O##OO.....O.....O.O..##..O#....#.OO.\n#O..O.OO....##O......O.O...O#O..#.O..........O....#........O#.#..O..O............#..#...OO#.###..#.#\n...#...#.#O....O.O.....OO.O.O...O.#.#.O...OO..O#....O#O......O.O..##.#.O.....#..O.O.#.#O...O.#......\n.O...O#.O.......O.#....O.#...#.#..#O.....#..#..#.#O#..#.......O..#.#..O.OO.#OO.OOO..O....#.....OO#.O\nO#.#..#.O..O..#O.......O.#..#....#.O..#...#......O...O##....O..#...O....#O..#.....OO.O.O#..O.#..#O..\n#.#.....O...#O.#..O...#O..##..#O..#O...O.#OO...#....OO#..O.#O#O........OOO...O##..#..OO.O.O.O.O.....\n..OO...#..OOO.O#..#...O..O.......O.#.#.O#.##OO....#..O....#..#.O.#O...O.O#O........O#OOOO#.#..O#.#..\n.O....#.O#OOO.....O.#O............O...O#...O...O..O.#..O.O.....O#.O....O......O...O.O..OOO..O.##.O..\n#...#........#..........###.O....OO.#.....#OOOO.OO#.OO...##...OO...O#.......O...#.#..#O..#.....#O#O.\nO.O.#...O.#.....OO...O.O#......#........#..O...O..O.#..OO#.....#...O.##O#....O#..O#...##.O.O.#.#....\n............OO.....O........##O.O...#..#.O.#...OO..#.O.#O.............O..#O.....#...O.#....O..O#..#.\n.#..#.O.#......O..O##O.O.#..O..#O.O..O.O........O.......#.#.#O.#..O...O...O....O.O#...#..OO..O....OO\n#..#..O....OO#.#.O.#......O...O.O#O...O#...O...#...#O.#....#..#O...O...........#.#.#..O##..#........\n..O......O.#.OO.#O...O..#O...OO.#.....##...#.#....O....OO.#O.O.#....OO..#....#.#...#.O.....OO#..O...\n#..........#...O.O....##....OO..O..O..#...#..###....##..O#..#.........#.....O#...#.#.......#.##.##O.\n###.O.#..#.O.O.O..O..O...O...#O...O##.#..#O..O...#....O.....#..##......OO.#O...O#..O.O.O......#...OO\n....O#........O.O#.O#O#...O.......#..O.#..#........O.....O#..O..O.OOO....OO.....#....O#.#..O.....##.\n#.#O...#.O#O..#.#OOOO#.......#....O...O#.##.O....#..O.......O.##.#.OO...O...#O..O..#O.#......O.O.##.\n.#O...OO#......O...#..##............O...##...O.#O....#..OO......O.O##OO..OO....##O.##..O............\nO.O..OO.O.#.#....#..O.O.O.OOO...OO..#....O....O.#.#....#.O#.#.....O#O...O.OO..O.#O.#..OO#.O#........\n#..#.O.##.##...#OO..O...OOOO#O##..#...#.##....#O.#O#.O.O#.#.O#...#.OO.......O........O..#.#.OOO#....\n##....O...O#....O...O.#OO.O..O.....O#O#.#...OO.........#.......O.#.#..O..#O...#..O.#...#.##...O..O.O\n.........O...O.O...#..O.O..OO.#...O.#.O........O.O.O....O...O..O..........O....O......O..#O.O..#O...\n.......#.#....O#OOO.O.O..O.##...O..###.......O#.##...O.O....#.OOO..O...#.#.......#O.OO...O...OO.O...\n.O...O...O....#.O.#...#..##O....#..O....O#..O.#.O..#...........#..O..##OO.......##..#.....O#...O#..#\n...O....O....#....O..####.#O#.....#O.O..#..#O.OO...#...O.##.#.#....#...O...O..#.....OO.O....#..O..O.\n.OO#.#...#....O.#O#.##....OO............O.....#.OO#O.#O.#..#...#.O....O.O..#..##.......O..O.#..##O.O\nO...#.........#.O....O..O.....#.......#.OO...OO.#O#.#...OOO.O.O#.O.#...#O......#....O.......#.O.#.O.\n.....O.............O.#..#.#..#.#...#..OOO....#.OO.O...O..#.##O.#O...O.O.OO......#....OO..O..........\nO....#....#.#....#.........#...O.O#....OO.#..#O..#....OO...#....O...O#...O.......OOO...#......#...#O\n..O..##O.#O.OOO..#..O.#....#.OOOO..O.O.....##O.....O.#.O.###..##....O..OOOO..#.#OO.O.OO.#O#..#...#.O\nO#...O......#..#.....#..##.#OO#O#.....O...##....OO...O##...O....O.#...#O..#.O#..#O.O..#...#...OOO..O\nO...##.O..O..O#....#..O........O....O#...O..O......O...OO...OO.#OO.O..#....O#O....O..#..#..OO.OO....\nO..#.#O....O..O.O..O#...O.O...O..#.#.#..##.#O......#...OOO.#O...#..O.....O###O.....#.......O#.O.O...\nOOO#..#.#...O...O..O.O..O#O.....#O.#..O....O...O.#..O.#...O#.......#.....#O.#.#..O...##..#.....O...O\nO#...O#....O.#.#......O.....O.##.......#.O.......#.#.#...#..#O....##O......O..O.#.#..O..#..O.O#O.O..\nO.O...O##.O#.....O......#...O.#...O.O..#........O..O..O#.O..OO#O.OO.........O...O..#.O......O...O#.O\n..#......OO.#....O...O..O..##...#O#O#O..O..O......O..O.#O#..O......O..........OO..OOO#..#.OO....O...\n.......##......#.O..#....#.O#O..O#...O#....O.OOOO..#.O.O..O..O..O.........O...O#...O..#O..#.#..O...O\n.O#..OOOO.O......#O......OOO#.#.O.#O...##...O.O...##.O#.O.#.......#.......##...#O.O...#.#..O..##O..O\n....OO......#.#.....O.#.OOO.O#.#...O.##.O..OO....#OO..O..O.O.O#..OO....O.O..#.O.##..O...OO..OO..OO#.\n........#O.....#....O#.#OOO.O...........OO....#.#.....OO#..#OO..#..#.....O#O..OO..OO..O......#..O.O.\nO#O....#.#......O#...#.##O..OO.O.....#O..#..O..O......O##..#OO...OOOO.....O#....O..O.....OOO...#O..O\n...O..#..O......OO.#.....#.O...O.O.#.O..OO..#....#...#....O.#O.O...O.O......O......O..#...#O###.OO..\n#O###.....#....#.#O..#...#O..OO....#.O...#.##OO.#.#.#.....#....O.###...#....#.#...O.......O...O..#.O\n..#..O.O..#.........O#..OOOO###..O##.#........O...#.#O#..#...O...O#....O..#.#...O.O..OO.....O.......\n#...O..#.......O........O....#.O......#...##.##......O.....O.##.O..O.....##...#OOO..O...O##.O.O.....\n......#.OO....###.......#.###..OO#.OOO#O#.OOO#..O....OO........#...O...O#.OO.#....O#.......#..#..#..\n#..#OOO....#.#.O.O..........#O....O#...O..O..#...O....O#..##.O..O.#O...#.#.#..O..O.O.#O..O..O...#.#.\n.#...O.O##.....#..O.....OOO.#.....#OOO#.#..O.....O.#.O.O.#.#.O.O#.........O....#...#O.O##.##..O.O#.O\nOOO...#O.OO....#.OOO..O....O.OO.O.#.O.#.#...#....OO........O..#..OO....#O....#.#O##.OO#O#.##OO.O.O.#\n...O#..OO.....O#...#O........O....O#O....OO...#....O###..##.O..#..#.#..O..#O.OO..O........##O#.#..OO\n.O...#..#....O.##...#.........##.#..O.O.....#.##..O.#O.#..O#...#....#.#.........##.O...O...OO#..O..#\nO....##.O...O........O#..#...OO#O..OO..#.........##......O.......OO..O...O.O..#..........#.O..#...O.\n###.#.........#OO....##...O#...O....O........#...#.O.#O.#.....##..O..#O.##......#.#.O.......O...O...\n..#.OOOO..O......O#O.O.#.O.#..#.O...O..O.O..##O.O.......#...O#..#..O.#.#.O#.##...O......#.#...#.....\nO.#.OOO.#......O....O..O...O#........#....#.......#O..O.OO..#.O#.OO..#.OOO..#O.....#OOOO..#.........\n##.O...####OO#...O#.OO...O...O.......O...OO..####...OOOO..O##O....OOO....#..O.O........O....#.#.#O..\nO.O....O...O#...O.#....O.....OO#O#OO..O##.O..O...O.#.....#O...O..#O...O#.....O##...O.OO...#.........\n....#OO..OO..#O#......O#.O..#O..#..OO..#....#.....#.....O.O..O#....O.O..O.#..O#O###O....O...OO...#.#\n#..OO.##O..OO.O..O...#....O.....##O..#............##.O.#...O.#O..#O..#...#...O.O....#O.....O.....O..\n..O#..#...##.#.#.O#.OOO.O#.#....OO.#....#...#...#.....#O.....O..O...O.....#.O.O.O#...#O.#...##.O..O#\n#....#.O...O#...##O.#....O........O...O#.#.#...#O#..O..O.#O.....O..O....#....O.O#O#....#O#..#......#\n.O.O#.........O.....##.O.#..............O...#.#OOO.O.OO..O..O..O##....#.......OO....O....#OO#..OO...\n##.O#...OO...O.O...........O..O.##O..#.#...#..O..#.##....#..###O..##........OOO.#.O.#......#......#.\n#......O#..O#.#.#..#O##..OO#O...##O.#...#.OO...#.O..O##O.O...........O.##...###O..#.#.O.O..OO.O..O..\n#.....#.##.O.O.#....O..#O......O.O#...#..O.#O#OO...#.OO...O.O##.O...O.......#...##....#O.....O.##O#.\n...O.OO.O...O#..OO.O....#.#.O....O...#..#O.O..OO.#....O.O#.O#..O..O...O..O........#..#..#..#..OO.O#.\n.#O.O....#....#.OO.#.O...O......O....O#.....##...#O...##...#.#OO..O#O..O##.#.#..O...O.....#..O##.O..\nOOO....OOOO...#.#...#.....###...O......O.#.O.....O...#.O##...##O.#.#...O....O.O...#.O...#O....O....."

def parse(line: String): String =
  val (s"$input") = line: @unchecked
  input

def elementIndexes(line: String, element: Char) : List[Int] =
  line.zipWithIndex.filter(pair => pair._1 == element).map(pair => pair._2).toList

def tiltLeft(line: String): String =
  // split by rocks
  val sections = line.split("#").toList
  //  println(f"$sections sections")
  // reorder sections to the left
  val reorderedSections = sections.map( section =>
    section.sorted.reverse
  )

  // then stitch back together adding back in the rocks
  val stitchedSections = reorderedSections.mkString("#")

  // add back the ending rock to handle it dropping after during list processing
  val missingRocks = line.length - stitchedSections.length
  val endRock = "#"*missingRocks

  val finalStitched = stitchedSections + endRock
//  println(f"$line before tilt")
//  println(f"$finalStitched after tilt")

  finalStitched

def tiltRight(line: String): String =
  // split by rocks
  val sections = line.split("#").toList
  //  println(f"$sections sections")
  // reorder sections to the left
  val reorderedSections = sections.map( section =>
    section.sorted
  )

  // then stitch back together adding back in the rocks
  val stitchedSections = reorderedSections.mkString("#")

  // add back the ending rock to handle it dropping after during list processing
  val missingRocks = line.length - stitchedSections.length
  val endRock = "#"*missingRocks

  val finalStitched = stitchedSections + endRock
  //  println(f"$line before tilt")
  //  println(f"$finalStitched after tilt")

  finalStitched

def transpose2dString(input: String) : String =
  input.linesIterator.map(_.toCharArray).toList.transpose.map(line =>
    line.mkString("")
  ).mkString("\n")

def calculateTotalLoad(input: String) : Int =
  val totalRows = input.linesIterator.toList.size
  val rowLoads = input.linesIterator.zipWithIndex.map {
    case (row, rowIdx) =>
      val totalRocks = row.count(_ == 'O')
//      println(f"$totalRocks found on row ${totalRows - rowIdx}")
      // row number
      // for the puzzle the row number is descending from the top 10.9.8.7 etc
      totalRocks * (totalRows - rowIdx)
  }

  val totalLoad = rowLoads.sum
  totalLoad

def solution(input: String): Int =
    // transpose
//    println("ORIGINAL")
//    println(input)
    var totalScore = 0
    var stringToProcess = input
    (1 to 1000).foreach( i =>

      // NORTH
      val tiltedNorthTransposed = transpose2dString(stringToProcess).linesIterator.toList.map(line =>
        tiltLeft(line)
      ).mkString("\n") + '\n'

      val afterNorthTilt = transpose2dString(tiltedNorthTransposed)
//      println("\nTILTED NORTH")
//      println(afterNorthTilt)

      // WEST
      val afterWestTilt = afterNorthTilt.linesIterator.toList.map(line =>
        tiltLeft(line)
      ).mkString("\n") + '\n'

//      println("\nTILTED WEST")
//      println(afterWestTilt)

      // SOUTH
      val tiltedSouthTransposed = transpose2dString(afterWestTilt).linesIterator.toList.map(line =>
        tiltRight(line)
      ).mkString("\n") + '\n'

      val afterSouthTilt = transpose2dString(tiltedSouthTransposed)
//      println("\nTILTED SOUTH")
//      println(afterSouthTilt)

      // EAST
      val afterEastTilt = afterSouthTilt.linesIterator.toList.map(line =>
        tiltRight(line)
      ).mkString("\n") + '\n'

//      println("\nTILTED EAST")
//      println(afterEastTilt)
      println(f"${calculateTotalLoad(stringToProcess)}")

      stringToProcess = afterEastTilt
    )

//    println(stringToProcess)
    // then get positions of row indexes for every rock

    val totalLoad = calculateTotalLoad(stringToProcess)

    totalLoad

var startTime = System.currentTimeMillis()
solution(sampleInput)
var timeTaken = System.currentTimeMillis() - startTime
println(f"Time taken: $timeTaken ms")

startTime = System.currentTimeMillis()
solution(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Time taken: $timeTaken ms")

// had to detect the inital period and how long the cycling was
//(1_000_000_000 - transient) % period + transient, where transient is the number of cycles before periodicity starts
//
//i.e. taken cycle index number ((1000000000 - 10) % 7 + 10) if counting from zerp
//which is cycle number ((1000000000 - 10) % 7 + 10) +1