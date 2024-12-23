import scala.annotation.tailrec
import scala.collection.mutable

val sample1Input = "...#......\n.......#..\n#.........\n..........\n......#...\n.#........\n.........#\n..........\n.......#..\n#...#....."
val puzzleInput = "............................................#.........#.......#.................#.......#........#..........................................\n......................................#.........................................................................#.........................#.\n#........................................................................................................................#..................\n.....#...................................................#..................................................................................\n.......................................................................#..................#..............#...........#......................\n............#........#...................#..........................................................#........................#..............\n...............................#......................................................................................................#.....\n................................................#.....#.........#................................................................#..........\n#........#.......................................................................................#........................#.................\n..........................................................#...........................#.....................................................\n.......................................................................#....................................#...............................\n............#.................#.....#..............#..........................#.............................................................\n....................#........................#............................................#............#...............#....................\n...#....................................................#...................................................................................\n.................................#...............................#...................#...........................#............#.............\n.................................................................................................#..........................................\n................................................#...........................#...............#...............................................\n.#........#.............#...........................................................................................#............#..........\n................#....................#......................................................................#.............................#.\n................................#............#.....................#........................................................................\n.....................#................................................................#......................................#..............\n........................................#..........#.......#..................................#........................................#....\n.....#..........................................................#..............#.......................#.............#......................\n..............................#...........................................................#........................................#........\n.........#.......................................................................................................#..........................\n......................#............................................#........................................................................\n.......................................#.....#...................................#...............#...........#.........#....................\n..........................................................................#.............#...................................#...............\n#......#.................#.........................................................................................#........................\n...............#........................................#.....#.....................#...............#....................................#..\n...................................#..........................................#..........................................#.......#..........\n....................................................................#.......................#...............................................\n.................................................#..........................................................................................\n.........................................#................................#...........................................................#.....\n#..............................#..........................#..........................#..........................#...........................\n.....#..............#...........................................................#........................#....................#.............\n...............#............................................................................................................................\n.............................................#.....#.................................................#......................................\n............................................................................................................................................\n.....................................#.................#......#.................................#...........................................\n..........................................#.................................#.............#.................................#...............\n.................................................................................#................................#..............#..........\n..........#...........#....................................................................................#................................\n...............#..............#.....................................#................................#....................................#.\n#.....................................#.......#.......#...................................................................#.................\n............................................................................................................................................\n............................................................................................#...............................................\n........#...........#.............#.............................................#.........................#........#........................\n.............................#.............#..................................................................................#.............\n.......................................................#..........#...................................#.......#......................#......\n.....#.................................................................................#........#...........................................\n...........................................................................#................................................................\n..............#..........................#..................................................................................................\n..#.........................#.......#................#.....................................#.........................#......................\n...................................................................................#......................................#.................\n..................#.............................#.............#....................................#.........#........................#.....\n............................................................................................................................................\n.......................................................#..............................#.........................................#...........\n.............................#...................................................#............#............................................#\n............................................................................................................................................\n...................................#...........#................#..............................................#........#..............#....\n.#......#...........#.....#.............#..................#........................................#.......................................\n............................................................................................#................................#..............\n............................................................................................................................................\n....#........#...................#....................#............#......#.......#.......................................................#.\n..............................................#..............#.................................#....................#.......................\n............................................................................................................................................\n#......................#.....................................................#.............................................#................\n........#................................#..........................................#.......................#...............................\n.......................................................................................................#...........................#........\n..................#...........#................#............................................................................................\n............#.....................................................................................#.......................................#.\n......................#.....................................................................................................................\n....................................................................#..........................................#............................\n..........................................#...........#...................................#.............#...................................\n...#................................................................................................................#........#..............\n...............................#..............................#.................#...........................#...............................\n......................................#...........#.........................................................................................\n.................#...........................#........................#..............................................................#......\n........................#.............................................................................#.....................................\n..........#.......................#..............................#....................#.........#.......................#...................\n..#.........................................................................................................................................\n.................................................................................#........#..................#....................#.........\n............................................................................................................................................\n............................................................................................................................................\n...............................#......................#..............................................................................#......\n.......................#..................#.........................#.......#....................#..........................................\n....#.........................................................................................................#.................#...........\n..............#...................#...........#..............#......................#.......................................................\n............................................................................................................................................\n..............................#..............................................................#.....................................#........\n.....................................#.......................................#.........#..........#....................#....................\n......#...........................................#.................#.......................................................................\n#...........#.......#..................................#..............................................#......................#..............\n................................#...................................................................................#.......................\n............................................#................#..............................................................................\n..........................................................................#..................................#..............................\n.......#....................................................................................#..........................#.........#..........\n..#...........#......................................................................#..................................................#...\n...........................................................#.....#..........................................................................\n..................#...............#................................................................#........................................\n............................................................................................................................................\n#......................#...............................#....................#..................................#..........#........#........\n..........................................................................................#.................................................\n...........#................#..............................................................................................................#\n...........................................................#........................#.............#.........................................\n................................................#...........................................................................................\n...................#.....#..........#......................................................................#.....#...................#......\n........#......................#............................................................#.........................#.....................\n..............#..............................................................#.........#....................................................\n....................................................................#..........................................................#............\n#..............................................#............................................................................................\n.....#........................................................................................................#.............................\n......................#................#.........................#........................#.........................................#.......\n............................................#......#...............................#..............#.........................................\n.................................#..........................................................................................................\n..........................#...................................#.........#...................................................................\n..........#.................................................................................................................#...............\n#...............#...........................................................#..........................................................#....\n..............................................................................................#..................................#..........\n......................#....................#........................................#.............................#........................#\n................................................#......#....................................................................................\n.......................................................................#..............................#......#..............................\n.........................#.................................................................#.....#........................#.................\n.#..................#..........#......................................................#.....................................................\n..........#..............................................#........#.........................................................................\n.......................................#.............................................................................#..............#.......\n............................#.................#...................................#........................................................#\n.....................................................#..........................................................................#...........\n....#..........#.........................................................................................#......#...........................\n......................#.....................................................................................................................\n...........#.............................#.............................#................................................#...................\n..................#..................................................................#......................................................\n.............................#.........................................................................#.....................#.........#....\n........#..................................................................#..............#.................................................\n#........................................................#.........#........................................................................\n.......................................#........#.............................................................#.............................\n...................#..............#................................................................#.....#.........#........................\n.............#.....................................................................#.....................................#............#.....\n......#...................................................................#.....................................................#..........."

case class Universe (universeMap:Array[Array[Char]], galaxyLocation: Map[Int, (Int,Int)]) {
  def totalGalaxies: Int =
    galaxyLocation.keys.size
}

@tailrec
def parse(universeRowIdx:Int, lineToParse: String, universe: Universe): Universe =
  val galaxyColIndex = lineToParse.indexOf('#')

//  println("parsing row " + universeRowIdx)

  // replace each galaxy # with incremental ID and also a map of ID <- (rowIdx, colIdx)
  if galaxyColIndex != -1 then

    val galaxyId = universe.galaxyLocation.keySet.size + 1
    val replacedStr = lineToParse.replaceFirst("#", "-")

    val updatedUniverseMap = universe.universeMap.clone()
    updatedUniverseMap(universeRowIdx) = replacedStr.toCharArray

//    println(f"found galaxy ID $galaxyId at position $galaxyColIndex")

    val updatedUniverse = universe.copy(
      universeMap = updatedUniverseMap,
      galaxyLocation = universe.galaxyLocation + (galaxyId -> (universeRowIdx, galaxyColIndex) )
    )
//    println("updated universe")
//    println(updatedUniverse.galaxyLocation.keySet)
//    println(updatedUniverse.universeMap(universeRowIdx).mkString("Array(", ", ", ")"))

    parse(universeRowIdx, replacedStr, updatedUniverse)
  else
    // no more galaxies in this row so just copy the line into the parsed university map as is
    val updatedUniverseMap = universe.universeMap.clone()
    updatedUniverseMap(universeRowIdx) = lineToParse.toCharArray

    universe.copy(universeMap = updatedUniverseMap)

def getMapDimensions(universeMapRaw: String): (Int, Int) =
  (universeMapRaw.linesIterator.size, universeMapRaw.indexOf("\n"))

def getIdxOfEmptyPaths(mapRows: Int, mapCols: Int, galaxyLocation: Map[Int,(Int, Int)]): (List[Int], List[Int]) =
  val (populatedRows, populatedCols) = galaxyLocation.values.unzip

  val emptyRows = (0 until mapRows).diff(populatedRows.toList)
  val emptyCols = (0 until mapCols).diff(populatedCols.toList)

  println(f"mapRows $mapRows")
  println(f"mapCols $mapCols")

  println(f"populatedRows $populatedRows")
  println(f"populatedCols $populatedCols")

  println(f"emptyRows $emptyRows")
  println(f"emptyCols $emptyCols")

  (emptyRows.toList, emptyCols.toList)

def computePairs[T](data: List[T]): List[(T, T)] =
  data
    .tails
    .filter(_.nonEmpty)
    .flatMap(xs => xs.tail.map((xs.head, _)))
    .toList

def calculateNumberOfIntersects(x1: Int, x2: Int, boundaries: List[Int]): Int =
//  println(f"boundary calc $x1 $x2")
//  boundaries.foreach(println)
  if x1 < x2 then // so it doesn't matter if coordinates are 1, 4 or 4, 1
    boundaries.count(n => n > x1 && n < x2)
  else
    boundaries.count(n => n > x2 && n < x1)

def calculateDistanceBetweenEachGalaxy(universe: Universe, emptyRows: List[Int], emptyCols:List[Int], expansionFactor: Int): List[Long] =
  // get all pair combinations of each galaxy
  val galaxyPairs = computePairs(universe.galaxyLocation.keySet.toList).sortBy(u => (u._1, u._2))
  println("number of pairs " + galaxyPairs.size)

  // for each pair, lookup the coordinates and calculate the distance, applying expansion factor if passing one of empty col/row
  galaxyPairs.map( (galaxy1, galaxy2) =>
    val galaxy1rowCoord = universe.galaxyLocation(galaxy1)._1
    val galaxy1colCoord = universe.galaxyLocation(galaxy1)._2

    val galaxy2rowCoord = universe.galaxyLocation(galaxy2)._1
    val galaxy2colCoord = universe.galaxyLocation(galaxy2)._2

//    println(f"${universe.galaxyLocation(galaxy1)} ${universe.galaxyLocation(galaxy2)} passing ${(calculateNumberOfIntersects(galaxy1rowCoord, galaxy2rowCoord, emptyRows) )} row boundaries")
//    println(f"${universe.galaxyLocation(galaxy1)} ${universe.galaxyLocation(galaxy2)} passing ${(calculateNumberOfIntersects(galaxy1colCoord, galaxy2colCoord, emptyCols) )} col boundaries")

    val xDistance = ((galaxy2rowCoord - galaxy1rowCoord).abs + (calculateNumberOfIntersects(galaxy1rowCoord, galaxy2rowCoord, emptyRows) * expansionFactor)).toLong
    val yDistance = ((galaxy2colCoord - galaxy1colCoord).abs + (calculateNumberOfIntersects(galaxy1colCoord, galaxy2colCoord, emptyCols) * expansionFactor)).toLong

    val distance = xDistance + yDistance
    println(f"$galaxy1, $galaxy2 distance $distance")
//    println()
    distance
  )

def printMatrix(matrix: Array[Array[Char]]) =
  matrix.map(elem =>
    println(elem.mkString(" "))
  ).mkString("Array(", ", ", ")")


def solution(input: String, expansionFactor: Int): Long =
  val (mapRows, mapCols) = getMapDimensions(input)

//  println("Starting Universe")
//  println(input)
//  println()

  // need to refactor to val but need to avoid bug of passing in same universe into parse for each row to overwrite the nulls
  var universe = Universe(universeMap = Array.ofDim[Char](mapRows, mapCols), galaxyLocation = Map())
  universe = input.linesIterator.zipWithIndex.map {
    case (line, universeRowIdx) =>
      universe = parse(universeRowIdx, line, universe)
      universe
  }.toList.last

  println(f"Total galaxies: ${universe.totalGalaxies}")
//  printMatrix(universe.universeMap)
//  println(universe.galaxyLocation)

//  val galaxyLocations = calculateGalaxyLocations(input)
  val (emptyRows, emptyCols) = getIdxOfEmptyPaths(mapRows, mapCols, universe.galaxyLocation)
  val distances = calculateDistanceBetweenEachGalaxy(universe, emptyRows, emptyCols, expansionFactor)
  println(universe.galaxyLocation)
  distances.sum


//println(solution(sample1Input, 1))
//println(solution(puzzleInput, 1))
//
//println(solution(sample1Input, 9))
//println(solution(sample1Input, 99))

println(solution(puzzleInput, 999999))
