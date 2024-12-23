import scala.collection.mutable
import scala.collection.mutable.ListBuffer

val sampleInput = ".|...\\....\n|.-.\\.....\n.....|-...\n........|.\n..........\n.........\\\n..../.\\\\..\n.-.-/..|..\n.|....-|.\\\n..//.|...."
val puzzleInput = "\\.........|......./...|........................................................|............|-...\\...-/.......\n.....................\\.......\\........./...|...............|...\\................................-...|.......\\.\n.......................................-....-./............/.......-.............\\..|.......|......//.........\n...../..../.....\\.........-.........-./..-.......\\./..\\.............-.....\\..........|-..................|....\n...........\\..\\...............-.............|.......-.\\......\\...\\..........\\.......-.....|..................\\\n................|.........|........|............--........./\\....|-.....................................-.....\n........./...........\\................../...................\\././........./...-...-.\\.-.........-.............\n......|.....|............-............./...|...................-...|........./............/......./...........\n......./........../..|.....-...........\\|.................................................\\.........|..../....\n........................|..................|.......|.................-..\\...........-/.\\.................\\.|..\n.......|...|./....................................-...\\........\\.......|............................|...|.....\n\\..-................................\\.......\\........../....|.....................|........\\../.........../..\\\n....-|...............................\\....|..............\\.....................|.....\\......\\............../..\n.....\\......-.........-.\\.|..........|...............-.................|..........-............../............\n.........-...................-.............................................-.........../...................|.-\n....................\\..\\........|-.\\...............-............/....|..................../...................\n.\\.........-........................|..-.......|.......-...........-.-...................\\/...\\....|....\\.....\n.-........-./.....-.....\\.......-..........\\..-........\\..-.....................................\\..../...|....\n....-.........................|..\\.....................................\\./...............-............/.......\n..........|..\\....-........./..............................|........................-.......|./|........\\.....\n..\\.........|..|..-|........\\...-................|/..\\......../.......-|..................||.-./..............\n.--..-.......-........./.................\\....../.................-............................--.........-...\n.......|.........../......./........../..\\.........\\...\\../..\\..././.......-..................................\n.........-/...............|..\\|.................\\...........|............../............\\.....................\n..........-.........\\.-................|-..................../......../...|/...\\..-....|-........-.......-....\n.--|.\\|.......|.....-............................|.-....-...|...................|........../..................\n.....-......./..../.|...................|\\..-.........../...|.............................\\/../........../....\n......./........|.\\......-../...........\\........................./..........\\.........-...\\................|.\n./.......................\\........-......|...|............................/............\\....-.....|..../...\\..\n....................-..............-..-.............../..\\...../.\\.........\\................../.....\\.....-...\n...................../......-....-.......|....|......../..|-...............\\..\\../.-.....././..........|......\n..\\.....|...\\............................./.../...../..../......../...........................................\n./.../................................../.....-.........|.....|..........-...............................-....\n...............|..\\...-................................\\.........................|....\\...............-.-.....\n/........|.......|.....-.......-..-..-.\\.................................-.\\...-.......\\.............-..\\.....\n./......|../......|................................/.........||.-....................|..\\.........-....|../...\n|..................................................\\......|...-............................../.......-........\n....../...............-....-..................\\....-../................................./.\\.................-.\n......-...........-...../.....-......|..........\\.\\...-......../......\\................--..............-......\n.............\\/........|...../...........-.......\\...|........................................................\n...\\\\........\\..........|...\\............/........-..../....-.....................-......................../..\n.......-......../......./..........-....|....-..\\.........................\\.............../..........-.....-..\n.....|\\/..../.........|.........../|.....\\.......-........-............../..././.............|................\n.........|....|....\\..-....../............/.....\\/....|.............\\........................|.........-......\n.\\\\..........................//......................\\....\\...........................-.|/....................\n...................|...................-.|........................................../..........\\..............\n......\\..|....../...........\\.-.........-.......-..|../........../.............................../.......-...|\n..........|................/|.....-.....\\................||........./.............|.........../..-..|./.......\n............../../|.......\\...............-..../|..../-..|................................../......-....|..|..\n............\\...............\\.........................\\....-.............-..|/.....--...................-...-.\n.....|\\......\\...........................-.................-.......\\...............|............|........../..\n.....\\...-.............|............\\........\\...../.-...........|.-.................\\.........|..............\n......./......\\..-............|..-...\\......................\\..........|....../..........|........./.......\\.-\n..-.....|........./|............./.....................|...|.\\....-.......-..........|...\\.\\|-........\\....|..\n......................../............-...........|...................../............-.......\\.........-.......\n......../..............-./...................................--........................\\....-.......-..//.....\n........|.....-....................|...../..............-..........-......|..\\................................\n.......-..//.............../.....-......................./..|........./...........-..../..|.........-.........\n.-...............-...........................\\.......\\...........-..................-.|...\\..\\.....\\..\\.....\\.\n.........-../............|......|.|.........................\\.......-......\\...\\..............-../.../-\\......\n.-...........-..|.....\\/........-.|...................../.|........-...........\\..........\\.....\\/|..../...\\.\\\n.-..........\\.\\-..\\....-\\/................./.\\.......|.........................-............./....\\........./.\n.............\\.........|............/...........\\\\................./..-..........................|//.......\\..\n..../-........-.........................-\\...........|................./..........|.............|.\\..|........\n...-..|.....\\..-..\\.................\\-.................|...../.-..........|........|/...-.-.\\.................\n.-.-............................|.....\\..-..........|/|.........|....\\............\\.....\\..-...........|/...|.\n......................../...............|..-............................-.........|........../.-....../.......\n.........|-...................|.....................-...........|.../..............................|....-...-.\n..............|....................................................|.....|.......--.....\\...\\.............../.\n..-...............|........|..................-............|.........../.....\\................................\n........................|.........|............-....-..\\../..................\\..|......\\.........\\../.../.....\n.|............................./..............-....-.......--....-.../..........|.....\\.........-/.....|-./...\n....-..............|...-.....\\.....\\/.-........................................-.\\.............|...../|/......\n........./..-................/........./..............-............................................-....-.....\n...........-........./...................../.........-........-................./.|...........................\n............................................................-.............-..-......|..........-.\\............\n....\\/........................-../.../.................................\\............/..........|./-......-...\\\n....-............../..-.\\.......|......-...|...|.........../......|../...........|..-.\\.................../...\n...-......../....-........................|...-............-.........................|/.....|.........|......-\n...|........-.......-.......|...|\\.......\\............-...-...................................-|........-.....\n....\\/..-.....-.....-..--./-..-............../................|............\\.............../.......|..........\n.........-.\\.......-......|........-.............|..../..............\\-.....\\..........-..../.................\n.................-......\\|.--..../../.-......-.......-........\\....-...../....................../.............\n...../..../....../.............-......\\..........|..........\\..\\........-.-...................................\n..............................|........./........-..................|.............-.../.................\\..-..\n.....|./......-........\\...\\.................|....-........|..............|...................................\n\\...|............................-..|.............../..............|.../......-......-.........../....../.....\n..../.............................-..........\\.....\\-..................................-........../...........\n..........................\\....................-...-/.|....................../................................\n\\.......|.........-............\\\\...............-...-...................../...................................\n..\\...................................-................................................../.......\\.|..........\n...............................-................/........\\....\\.......|...................-.../.....|.........\n...-..-............-.||..../././..........-\\\\............||...............-.\\.........../...\\........|...\\...|\n....\\./.|./...................\\..-.-./..-.....||............../............|.......\\.|...../..................\n......-.......\\.\\.........\\......|..\\...\\.-|.\\..............|...|......\\......./...\\........................-.\n........./.-......../....|..............................|...|...\\........//./.................................\n.........................|...........\\...........|.....................\\........//..-.................\\-/.....\n.\\....................\\..-.-..-..........|/.\\..........\\././.....................|............\\....|...|/.....\n......./.................../...-.................\\.........../.........\\................|....................|\n......-..\\....|..................\\............\\........|......|....../........................................\n.........\\/..............|.............\\.........-............-...........\\.\\..\\./....../.....//..............\n.........../...\\.......-.../.-.............\\../....\\|./............/...-..\\........|..|/.....\\......\\\\........\n..|............/..............................................-./...-.|..........-......../...................\n...............-..|.......\\.............\\..../.....................|..........\\...................\\.....\\./\\..\n.|..........\\..\\...|......................\\...........-.......--........................-.....................\n...................../................\\.|..........-..|................-................................-.....\n...../.........|-............|.\\.|.../\\.....|../........\\../..................................................\n................/........\\../.....................\\./..../...........-............\\-......../../..\\.|.........\n..............|.........-......|/......././.....|..../.|...........-.....................|./.-.....\\...|......\n.......|..-.......\\..........|................................................/..\\.....-..........-..........."

var directionCache = mutable.HashMap[(Int, Int, String), Int]()
var maxEnergisedCache = ListBuffer[Int]()

def parse(input: String): Array[Array[Char]] =
  // add out of bounds barrier marked as x
  val mazeWidth = input.indexOf('\n')

  val extendedTopBottom = ("X" * mazeWidth) + "\n" + input + "\n" + ("X" * mazeWidth)


  extendedTopBottom.linesIterator.map( line =>
    ("X" ++ line ++ "X").toCharArray
  ).toArray

def headEastCoordinates(row: Int, col: Int): (Int, Int) =
  (row, col+1)

def headWestCoordinates(row: Int, col: Int): (Int, Int) =
  (row, col-1)

def headNorthCoordinates(row: Int, col: Int): (Int, Int) =
  (row-1, col)

def headSouthCoordinates(row: Int, col: Int): (Int, Int) =
  (row+1, col)

def forwardCoordinates(row: Int, col: Int, direction: String): (Int, Int) =
  direction match {
    case "N" => headNorthCoordinates(row, col)
    case "S" => headSouthCoordinates(row, col)
    case "E" => headEastCoordinates(row, col)
    case "W" => headWestCoordinates(row, col)
  }

def sidewaysCoordinates(row: Int, col: Int, direction: String): ((Int, Int), (Int,Int)) =
  direction match {
    case "N" | "S" => (headEastCoordinates(row, col),headWestCoordinates(row, col))
    case "E" | "W" => (headNorthCoordinates(row, col),headSouthCoordinates(row, col))
  }

def scan(maze: Array[Array[Char]], row: Int, col: Int, direction: String): Int =
  val key = (row, col, direction)
//  println()
  // end points
  // if current position is out of bounds
  if maze(row)(col) == 'X' then
//    println("reached barrier STOP")
    return 0

  // if current position and direction we have already visited (check cache)
  if directionCache.contains(key) then
//    println("been here before in this direction STOP")
    return 0

  // else add current position and direction to visited cache
  directionCache(key) = 1

  // then check mirror type and spin off additional scans in the relevant direction
  // continue same direction
  val current = maze(row)(col)

//  println(f"Cache key $key for current tile $current")

  if current == '.'
    || (current == '|' && "NS".contains(direction))
    || (current == '-' && "EW".contains(direction))
  then
//    println("Moving forward")
    val nextPos = forwardCoordinates(row, col, direction)
//    println(f"next coord $nextPos")
    scan(maze, nextPos._1, nextPos._2, direction)

  // split the beams
  if current == '|' && "EW".contains(direction)
  then
//    println("Splitting the beams")
    val (nextPosBeam1, nextPosBeam2) = sidewaysCoordinates(row, col, direction)
    scan(maze, nextPosBeam1._1, nextPosBeam1._2, "N")
    scan(maze, nextPosBeam2._1, nextPosBeam2._2, "S")

  if current == '-' && "NS".contains(direction)
  then
//    println("Splitting the beams")
    val (nextPosBeam1, nextPosBeam2) = sidewaysCoordinates(row, col, direction)
    scan(maze, nextPosBeam1._1, nextPosBeam1._2, "E")
    scan(maze, nextPosBeam2._1, nextPosBeam2._2, "W")

  // rotate the beam
  if (current == '/'  && direction == "N")
    || (current == '\\'  && direction == "S")
  then
//    println("Rotating the beam - go east")
    val nextPos = headEastCoordinates(row, col)
    scan(maze, nextPos._1, nextPos._2, "E")

  if (current == '/' && direction == "S")
    || (current == '\\' && direction == "N")
  then
//    println("Rotating the beam - go west")
    val nextPos = headWestCoordinates(row, col)
    scan(maze, nextPos._1, nextPos._2, "W")

  if (current == '/' && direction == "E")
    || (current == '\\' && direction == "W")
  then
//    println("Rotating the beam - go north")
    val nextPos = headNorthCoordinates(row, col)
    scan(maze, nextPos._1, nextPos._2, "N")

  if (current == '/' && direction == "W")
    || (current == '\\' && direction == "E")
  then
//    println("Rotating the beam - go south")
    val nextPos = headSouthCoordinates(row, col)
    scan(maze, nextPos._1, nextPos._2, "S")

  0

def mazeDimensions(maze: Array[Array[Char]]) : (Int,Int) =
  (maze.length, maze(0).length)

def partOne(input: String): Int =
  directionCache.clear()
  val maze = parse(input)

  scan(maze, 1, 1, "E")

//  println(directionCache)

  directionCache.keys.map(key =>
    (key._1, key._2)
  ).toSet.size

def partTwo(input: String): Int =
  val maze = parse(input)

  val (mazeRows, mazeCols) = mazeDimensions(maze)

  // scan the corners
  def runScan(startingRow: Int, startingCol: Int, direction: String) =
    directionCache.clear()
    scan(maze, startingRow, startingCol, direction)
    maxEnergisedCache.append(directionCache.keys.map(key =>
      (key._1, key._2)
    ).toSet.size)

  runScan(1,1,"E") // top left
  runScan(1,1,"S") // top left
  runScan(1, mazeCols-1, "W") // top left
  runScan(1, mazeCols-1, "S") // top right
  runScan(mazeRows-1, 1, "N") // bottom left
  runScan(mazeRows-1, 1, "E") // bottom left
  runScan(mazeRows-1, mazeCols - 1, "N") // bottom left
  runScan(mazeRows-1, mazeCols - 1, "W") // bottom right

  // start from top side
  (1 until mazeCols).map(col =>
    runScan(1, col,"S")
  )

  // start from left side
  (1 until mazeCols).map(row =>
    runScan(row, 1, "E")
  )

  // start from right side
  (1 until mazeCols).map(row =>
    runScan(row, mazeCols-1, "W")
  )

  // start from bottom side
  (1 until mazeCols).map(col =>
    runScan(mazeRows-1, col, "N")
  )

  maxEnergisedCache.max


var startTime = System.currentTimeMillis()
partOne(sampleInput)
var timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Sample Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partOne(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Puzzle Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partTwo(sampleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part Two Sample Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partTwo(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part Two Puzzle Input Time Taken $timeTaken ms")

