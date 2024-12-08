import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

val sampleInput = "#.#####################\n#.......#########...###\n#######.#########.#.###\n###.....#.>.>.###.#.###\n###v#####.#v#.###.#.###\n###.>...#.#.#.....#...#\n###v###.#.#.#########.#\n###...#.#.#.......#...#\n#####.#.#.#######.#.###\n#.....#.#.#.......#...#\n#.#####.#.#.#########v#\n#.#...#...#...###...>.#\n#.#.#v#######v###.###v#\n#...#.>.#...>.>.#.###.#\n#####v#.#.###v#.#.###.#\n#.....#...#...#.#.#...#\n#.#########.###.#.#.###\n#...###...#...#...#.###\n###.###.#.###v#####v###\n#...#...#.#.>.>.#.>.###\n#.###.###.#.###.#.#v###\n#.....###...###...#...#\n#####################.#"
val puzzleInput = "#.###########################################################################################################################################\n#.....#.....#.....###...#.........#.....#...#.......#...###...###...###...#.................#...#...........#.......#...........#...........#\n#####.#.###.#.###.###.#.#.#######.#.###.#.#.#.#####.#.#.###.#.###.#.###.#.#.###############.#.#.#.#########.#.#####.#.#########.#.#########.#\n#.....#.#...#...#...#.#.#.....#...#.#...#.#...#.....#.#.#...#...#.#.#...#.#.............#...#.#.#.#.........#.....#.#.#...#...#.#...#.......#\n#.#####.#.#####.###.#.#.#####.#.###.#.###.#####.#####.#.#.#####.#.#.#.###.#############.#.###.#.#.#.#############.#.#.#.#.#.#.#.###.#.#######\n#.#...#.#...###.#...#.#.#...#.#.###.#.###.....#.#...#.#.#...#...#.#.#...#.#.......#...#.#.###.#.#.#.#...#####.....#.#.#.#...#...#...#.#...###\n#.#.#.#.###.###.#.###.#.#.#.#.#.###.#.#######.#.#.#.#.#.###.#.###.#.###.#.#.#####.#.#.#.#.###.#.#.#.#.#.#####.#####.#.#.#########.###.#.#.###\n#.#.#...#...#...#...#.#.#.#...#.#...#...>.>.#.#.#.#...#.#...#.#...#...#.#.#.....#.#.#...#.#...#.#.#...#.>.>.#.....#...#.....#...#...#...#...#\n#.#.#####.###.#####.#.#.#.#####.#.#######v#.#.#.#.#####.#.###.#.#####.#.#.#####.#.#.#####.#.###.#.#######v#.#####.#########.#.#.###.#######.#\n#.#.#.....###.....#...#.#.....#...#####...#.#.#.#.#.....#...#...#.....#.#.#...#.#.#...#...#...#.#...#.....#...#...#...#.....#.#.#...#.......#\n#.#.#.###########.#####.#####.#########.###.#.#.#.#.#######.#####.#####.#.#.#.#.#.###.#.#####.#.###.#.#######.#.###.#.#.#####.#.#.###.#######\n#...#.#...###...#.#...#.......#...###...#...#.#.#.#...#.>.>.#.....#.....#.#.#...#.#...#...#...#.....#.....#...#.#...#...#...#.#.#.#...#...###\n#####.#.#.###.#.#.#.#.#########.#.###.###.###.#.#.###.#.#v###.#####.#####.#.#####.#.#####.#.#############.#.###.#.#######.#.#.#.#.#.###.#.###\n#.....#.#...#.#...#.#...#.......#...#...#...#.#.#...#.#.#.#...#...#...#...#.....#.#...#...#...#...#...#...#.....#...#...#.#.#.#...#.###.#.###\n#.#####.###v#.#####.###.#.#########.###.###.#.#.###.#.#.#.#.###.#.###.#.#######.#.###.#.#####.#.#.#.#.#.###########.#.#.#.#.#.#####.###.#.###\n#.#...#...#.>.#...#.#...#.........#...#.#...#.#.#...#...#.#.#...#...#.#.#.>.>...#...#.#.#...#.#.#...#.#...#.........#.#.#.#...#.....#...#.###\n#.#.#.###.#v###.#.#.#.###########.###.#.#.###.#.#.#######.#.#.#####.#.#.#.#v#######.#.#.#.#.#.#.#####.###.#.#########.#.#.#####.#####.###.###\n#.#.#...#.#.....#...#...#.........#...#.#.....#...###.....#...#.....#.#.#.#.......#.#.#.#.#...#.#...#...#.#.###...###.#.#...#...#...#...#...#\n#.#.###.#.#############.#.#########.###.#############.#########.#####.#.#.#######.#.#.#.#.#####.#.#.###.#.#.###.#.###.#.###.#.###.#.###.###.#\n#...###...#.......#.....#.........#...#.........#...#.........#.....#.#...#.......#...#...#...#...#...#...#...#.#...#.#.#...#...#.#.#...#...#\n###########.#####.#.#############.###.#########.#.#.#########.#####.#.#####.###############.#.#######.#######.#.###.#.#.#.#####.#.#.#.###.###\n###...#...#.....#.#...#...........###...#.......#.#.###.......#.....#.....#.................#...#.....#...###...###...#.#.....#.#.#...#...###\n###.#.#.#.#####.#.###.#.###############.#.#######.#.###.#######.#########.#####################.#.#####.#.#############.#####.#.#.#####.#####\n#...#...#.......#.....#...#...#...#####.#.#.......#...#.......#.......#...#.........#...........#.......#.........#...#.....#.#.#.#.....#...#\n#.#######################.#.#.#.#.#####.#.#.#########.#######.#######.#.###.#######.#.###########################.#.#.#####.#.#.#.#.#####.#.#\n#.#.....#...#...........#...#.#.#...###...#.........#.........#.......#...#.......#...###.....#...................#.#.....#...#...#.......#.#\n#.#.###.#.#.#.#########.#####.#.###.###############.###########.#########.#######.#######.###.#.###################.#####.#################.#\n#...###...#.#.#.........#.....#.#...#.......#.......#.....#####.....#...#.#.......#.....#.#...#...................#.#.....#...#.....#.......#\n###########.#.#.#########.#####.#.###.#####.#.#######.###.#########.#.#.#.#.#######.###.#.#.#####################.#.#.#####.#.#.###.#.#######\n#...........#.#.........#.#.....#.....#.....#.........###.....#...#...#...#.........#...#.#...#...###.........#...#.#.....#.#.#...#.#.......#\n#.###########.#########.#.#.###########.#####################.#.#.###################.###.###.#.#.###.#######.#.###.#####.#.#.###.#.#######.#\n#.#...#...#...#.........#...#...........#...#...#.............#.#...###.......#.......###...#.#.#...#.......#...###.#.....#.#.#...#.........#\n#.#.#.#.#.#.###.#############.###########.#.#.#.#.#############.###.###.#####.#.###########.#.#.###.#######.#######.#.#####.#.#.#############\n#.#.#...#...###.#.........#...###.....#...#.#.#.#.............#...#...#.....#.#.#...###...#.#.#.#...#...###.......#.#.....#.#.#.............#\n#.#.###########.#.#######.#.#####.###.#.###.#.#.#############.###.###.#####.#.#.#.#.###.#.#.#.#.#.###.#.#########v#.#####.#.#.#############.#\n#.#.#...........#.#.......#...#...#...#...#...#.#.............#...#...#...#.#.#.#.#...#.#.#.#.#.#.#...#.#.......>.>.#.....#.#.........#...#.#\n#.#.#.###########.#v#########v#.###.#####.#####.#.#############.###.###.#.#.#.#.#.###.#.#.#.#.#.#.#.###.#.#######v###.#####.#########.#.#.#.#\n#.#.#.............#.>.#.....>.>.#...#...#.#.....#.........#...#...#...#.#.#.#.#.#...#.#.#.#.#...#.#.#...#.#.....#.###.#...#.....#.....#.#.#.#\n#.#.###############v#.#.#####v###.###.#.#.#.#############.#.#.###.###.#.#.#.#.#v###.#.#.#.#.#####.#.#.###.#.###.#.###.#.#.#####.#.#####v#.#.#\n#...###.......#...#.#.#...#...#...#...#.#.#...#...#.....#.#.#.###...#.#.#.#.#.>.>...#...#.#.#.....#.#...#.#...#...#...#.#.#.....#...#.>.#...#\n#######.#####.#.#.#.#.###.#.###.###.###.#.###.#.#.#.###.#.#.#.#####.#.#.#.#.###v#########.#.#.#####.###.#.###.#####.###.#.#.#######.#.#v#####\n#.......#...#...#...#.....#...#...#...#.#.#...#.#.#...#.#.#.#.#...#.#...#...###...#...###.#.#.....#...#...#...###...#...#.#.....###...#.....#\n#.#######.#.#################.###.###.#.#.#.###.#.###.#.#v#.#.#.#.#.#############.#.#.###.#.#####.###.#####.#####.###.###.#####.###########.#\n#.........#.............###...###.....#...#...#.#...#.#.>.>.#...#.#...#...#...#...#.#...#.#...#...#...#...#.....#...#...#.....#...#.......#.#\n#######################.###.#################.#.###.#.###v#######.###.#.#.#.#.#.###.###.#.###.#.###.###.#.#####.###.###.#####.###.#.#####.#.#\n###...#...#...........#...#.........#...#.....#...#.#...#.......#...#.#.#...#...#...#...#.#...#.....#...#.#.....#...#...###...#...#.#...#...#\n###.#.#.#.#.#########.###.#########.#.#.#.#######.#.###.#######.###.#.#.#########.###.###.#.#########.###.#.#####.###.#####.###.###.#.#.#####\n#...#...#...#.......#.#...#.......#...#.#.....#...#.....#.....#...#...#.......#...#...###...#.......#...#.#.....#.....#.....#...#...#.#.....#\n#.###########.#####.#.#.###.#####.#####.#####.#.#########.###.###.###########.#.###.#########.#####.###.#.#####.#######.#####.###.###.#####.#\n#...........#.#.....#...#...#...#.......#.....#.#.....###...#.....#.....#...#...###...#.....#.....#.###.#.#.....#.....#.......###.....#.....#\n###########.#.#.#########.###.#.#########.#####.#.###.#####.#######.###.#.#.#########.#.###.#####.#.###.#.#.#####.###.#################.#####\n#.........#...#.......###...#.#.....#####.......#.#...#...#...#...#...#.#.#.#.........#.#...#...#.#.###.#.#...###.#...#...###...###.....#...#\n#.#######.###########.#####.#.#####.#############.#.###.#.###.#.#.###.#.#.#.#.#########.#.###.#.#.#.###.#.###v###.#.###.#.###.#.###.#####.#.#\n#.......#...#...#.....#...#.#.#...#...#...#...#...#...#.#.#...#.#.###.#.#.#.#...........#.#...#.#.#...#.#.#.>.>.#.#...#.#...#.#.....#...#.#.#\n#######.###.#.#.#.#####.#.#.#.#.#.###.#.#.#.#.#.#####.#.#.#.###.#.###.#.#.#.#############v#.###.#.###.#.#.#.#v#.#.###.#.###.#.#######.#.#.#.#\n###...#...#...#...###...#.#...#.#.....#.#.#.#.#.#.....#.#.#.###.#.#...#.#.#...#...#...#.>.>.###.#...#...#...#.#...###...#...#.......#.#...#.#\n###.#.###.###########.###.#####.#######.#.#.#.#.#.#####.#.#v###.#.#.###.#.###.#.#.#.#.#.#v#####.###.#########.###########.#########.#.#####.#\n#...#.....#.........#...#.#...#.....###.#.#.#.#.#.#...#.#.>.>...#.#...#...###...#...#...#.....#.#...###...###.....#.......#...#...#...#.....#\n#.#########.#######.###.#.#.#.#####v###.#.#.#.#.#.#.#.#.###v#####.###.#######################.#.#.#####.#.#######.#.#######.#.#.#.#####.#####\n#...........#.......#...#.#.#.#...>.>.#.#...#.#.#.#.#.#.###.....#...#.....###...#.....#.......#.#.#.....#.#...#...#.#...###.#.#.#.#...#.....#\n#############.#######.###.#.#.#.###v#.#.#####.#.#.#.#.#.#######.###.#####.###.#.#.###.#.#######.#.#.#####.#.#.#.###.#.#.###.#.#.#.#.#.#####.#\n#...###.......#...###...#.#.#...#...#.#.....#.#.#.#.#.#.#.......#...#...#...#.#.#...#...#.....#...#.....#.#.#...###...#...#.#.#.#.#.#...#...#\n#.#.###.#######.#.#####.#.#.#####.###.#####.#.#.#.#.#.#.#.#######.###.#.###.#.#.###.#####.###.#########.#.#.#############.#.#.#.#.#.###.#.###\n#.#...#.........#.#...#.#...###...#...#...#.#...#...#...#...#...#.#...#...#.#.#...#.......#...#.........#.#.......###...#.#.#.#.#.#.#...#.###\n#.###.###########v#.#.#.#######.###.###.#.#.###############.#.#.#.#.#####.#.#.###.#########.###.#########.#######.###.#.#.#.#.#.#.#.#.###v###\n#...#.....###...#.>.#.#...#.....###...#.#...###...#...#####...#.#...#...#...#...#...........###.........#.#...#...#...#...#.#.#.#.#.#.#.>.###\n###.#####.###.#.#v###.###.#.#########.#.#######.#.#.#.#########.#####.#.#######.#######################.#.#.#.#.###.#######.#.#.#.#.#.#.#v###\n###.....#.....#...#...#...#.........#...#...#...#.#.#...###...#.#...#.#.#...#...#...........#...........#...#...###...#...#.#.#.#.#.#...#...#\n#######.###########.###.###########.#####.#.#.###.#.###.###.#.#.#.#.#.#.#.#.#.###.#########.#.#######################.#.#.#.#.#.#.#.#######.#\n###.....#...#.....#...#.#...........###...#...#...#...#.....#...#.#.#.#.#.#.#.....#.........#...#...#...#.......#...#.#.#...#...#...#.......#\n###.#####.#.#.###.###.#.#.#############.#######.#####.###########.#.#.#.#.#.#######.###########.#.#.#.#.#.#####.#.#.#.#.#############.#######\n#...#.....#...###...#.#.#.....#####...#.....#...#####.........###.#.#.#.#.#...#...#...#...#...#...#...#...#.....#.#.#.#.###.......#...#...###\n#.###.#############.#.#.#####.#####.#.#####.#.###############.###.#.#.#.#.###.#.#.###.#.#.#.#.#############.#####.#.#.#.###.#####.#.###.#.###\n#.....#...#.........#...#...#.....#.#.#.....#.#...#...#.......#...#.#.#.#.#...#.#.###.#.#...#...#...#.....#.#.....#.#...#...#.....#.....#...#\n#######.#.#.#############.#.#####.#.#.#.#####.#.#.#.#.#.#######.###.#.#.#.#.###.#.###v#.#######.#.#.#.###.#.#.#####.#####.###.#############.#\n#...###.#.#.......#.....#.#.......#.#.#.....#...#.#.#.#.......#...#...#.#.#...#.#.#.>.>.#.......#.#.#...#...#.#.....#...#...#.###...#...#...#\n#.#.###.#.#######.#.###.#.#########.#.#####.#####.#.#.#######.###.#####.#.###.#.#.#.#v###.#######.#.###.#####.#.#####.#.###.#.###.#.#.#.#.###\n#.#.#...#...#...#...#...#.#.....#...#.....#...#...#.#.#...#...#...#.....#.###...#...#...#.....#...#...#.....#.#...#...#...#.#...#.#.#.#.#...#\n#.#.#.#####.#.#.#####.###.#.###.#.#######.###.#.###.#.#.#.#v###.###.#####.#############.#####.#.#####.#####.#.###.#.#####.#.###.#.#.#.#.###.#\n#.#.#.....#.#.#.......###...#...#.......#...#.#...#.#.#.#.>.>.#...#.....#...#...........#.....#.#.....#.....#.#...#...#...#...#.#.#.#.#.#...#\n#.#.#####.#.#.###############.#########.###.#.###.#.#.#.###v#.###.#####.###.#.###########.#####.#.#####.#####.#.#####.#.#####.#.#.#.#.#.#v###\n#.#.....#.#...#...#...###.....###...#...#...#.###.#.#...###.#.#...###...#...#.....#.....#.#...#.#.#...#.#...#.#.#...#.#.#...#.#.#.#...#.>.###\n#.#####.#.#####.#v#.#.###.#######.#.#.###.###.###.#.#######.#.#.#####.###.#######.#.###.#.#.#.#.#.#.#.#v#.#.#.#.#.#.#.#.#.#.#.#.#.#######v###\n#.....#.#.#.....#.>.#...#.#.....#.#...###...#.#...#...#.....#...#...#...#.###...#...#...#...#.#.#.#.#.>.>.#.#.#.#.#.#.#.#.#.#.#.#.#.......###\n#####.#.#.#.#####v#####.#.#.###.#.#########.#.#.#####.#.#########.#.###.#.###.#.#####.#######.#.#.#.###v###.#.#.#.#.#.#.#.#.#.#.#.#.#########\n#.....#.#.#.#.....#.....#...#...#.......#...#.#...#...#...........#.#...#.#...#.......#.....#...#...#...###.#.#.#.#...#.#.#...#.#.#.........#\n#.#####.#.#.#.#####.#########.#########.#.###.###.#.###############.#.###.#.###########.###.#########.#####.#.#.#.#####.#.#####.#.#########.#\n#.....#.#...#...#...#...#...#.#...#...#.#...#...#.#.#.............#.#.#...#...#.........#...#.........#...#...#.#.#.....#...#...#.#####...#.#\n#####.#.#######.#.###.#.#.#.#v#.#.#.#.#.###.###.#.#.#.###########.#.#.#.#####.#.#########.###.#########.#.#####.#.#.#######.#.###.#####.#.#.#\n#.....#...#####.#...#.#.#.#.>.>.#.#.#.#...#.#...#...#...........#...#.#.#.....#...#.......###...........#.....#.#.#...#...#.#.#...#.....#...#\n#.#######.#####.###.#.#.#.###v###.#.#.###.#.#.#################.#####.#.#.#######.#.#########################.#.#.###.#.#.#.#.#.###.#########\n#.......#...#...###.#.#.#.###...#...#...#.#.#...#.....#.........#...#...#.........#.......###.....#...........#...#...#.#...#...###.....#...#\n#######.###.#.#####.#.#.#.#####.#######.#.#.###.#.###.#.#########.#.#####################.###.###.#.###############.###.###############.#.#.#\n###...#...#.#.#.....#.#...#.....#.....#...#...#.#...#.#.....#...#.#.#...#...#...#...#...#...#...#.#...............#...#.#.......#...###...#.#\n###.#.###.#.#.#.#####.#####.#####.###.#######.#.###.#.#####.#.#.#.#.#.#.#.#.#.#.#.#.#.#.###.###.#.###############.###.#.#.#####.#.#.#######.#\n#...#.....#...#...#...#...#.......#...#.....#...###.#.......#.#.#.#.#.#...#.#.#.#.#...#.....#...#...........#.....###...#.....#...#.........#\n#.###############.#.###.#.#########.###.###.#######.#########.#.#.#.#.#####.#.#.#.###########.#############.#.###############.###############\n#...............#...#...#...........###.#...###...#...#...#...#...#.#.#.....#.#.#.........###.............#...#...#...###...#.....#.........#\n###############.#####.#################.#.#####.#.###.#.#.#.#######.#.#.#####.#.#########.###############.#####.#.#.#.###.#.#####.#.#######.#\n#...............#...#.............#...#.#.#...#.#.###...#.#.#.......#.#.#...#.#...........#...............###...#...#...#.#.......#.###...#.#\n#.###############.#.#############.#.#.#.#.#.#.#.#.#######.#.#.#######.#.#.#.#.#############.#################.#########.#.#########.###.#.#.#\n#.#.....#.........#.....#.....#...#.#.#.#...#.#.#.#.....#...#.#...###.#.#.#.#.............#.........#...#...#...#.......#...........#...#...#\n#.#.###v#.#############.#.###.#.###.#.#.#####.#.#.#.###.#####.#.#.###.#.#.#.#############.#########.#.#.#.#.###.#.###################.#######\n#...###.>.#...#...#...#.#...#.#.....#.#.....#.#.#.#...#.#.....#.#.###.#.#.#.#...#...#.....#...#...#.#.#.#.#.#...#.#...###...#...#...#.......#\n#######v###.#.#.#.#.#.#.###.#.#######.#####.#.#.#.###.#.#.#####.#.###.#.#.#.#.#.#.#.#v#####.#.#.#.#.#.#.#.#.#.###.#.#.###.#.#.#.#.#.#######.#\n###...#.#...#.#.#.#.#...#...#...#.....#...#.#.#.#.###.#.#.#...#.#.#...#.#.#.#.#.#.#.>.>.###.#.#.#.#.#.#.#.#.#...#.#.#.###.#.#.#.#.#.#.....#.#\n###.#.#.#.###.#.#.#.#####.#####.#.#####.#.#.#.#.#.###.#.#v#.#.#.#.#.###.#.#.#.#.#.###v#.###.#.#.#.#v#.#.#.#.###.#.#.#.###.#.#.#.#.#.#.###.#.#\n#...#...#.###...#...#...#.....#...#...#.#.#.#.#.#.#...#.>.>.#.#.#.#...#.#.#.#.#...#...#...#.#.#.#.>.>.#.#.#...#.#.#.#...#.#...#.#.#.#...#.#.#\n#.#######.###########.#.#####.#####.#.#.#.#.#.#.#.#.#####v###.#.#.###.#.#.#.#.#####.#####.#.#.#.###v###.#.###.#.#.#.###.#.#####.#.#.###.#.#.#\n#.......#...###...#...#.#...#.....#.#...#.#.#.#.#.#...#...###...#.....#...#.#.#.....#...#.#.#.#.#...###.#.#...#.#.#...#.#.#.....#.#.###.#.#.#\n#######.###.###.#.#.###.#.#.#####.#.#####.#.#.#.#.###.#.###################.#.#.#####.#.#.#.#.#.#.#####.#.#.###.#.###.#.#.#.#####.#.###v#.#.#\n###.....###...#.#.#...#.#.#.#...#.#...###...#...#.#...#.#.....#...#...#...#...#.......#.#.#.#.#.#.#...#...#.....#.#...#.#.#.#.....#.#.>.#...#\n###.#########.#.#.###.#.#.#.#.#.#v###.###########.#.###.#.###.#.#.#.#.#.#.#############.#.#.#.#.#.#.#.###########.#.###.#.#.#.#####.#.#v#####\n#...#...#...#...#.#...#.#.#...#.>.>.#.......###...#...#...#...#.#...#.#.#.#...........#.#...#...#...#.........#...#...#.#.#.#.....#.#.#.#...#\n#.###.#.#.#.#####.#.###.#.#######v#.#######.###.#####.#####.###.#####.#.#.#.#########.#.#####################.#.#####.#.#.#.#####.#.#.#.#.#.#\n#.#...#...#.....#.#...#.#.###...#.#.#.....#...#...#...#.....#...#.....#.#.#.........#.#.........#.....#.....#.#.#.....#.#.#.#.....#...#...#.#\n#.#.###########.#.###.#.#.###.#.#.#.#.###.###.###.#.###.#####.###.#####.#.#########.#.#########.#.###.#.###.#.#.#.#####.#.#.#.#############.#\n#...#...#.......#.#...#...#...#...#...###...#...#.#.###...#...###.......#.#.........#.#.....#...#...#.#...#.#.#.#.....#...#...###...#...#...#\n#####.#.#.#######.#.#######.###############.###.#.#.#####.#.#############.#.#########.#.###.#.#####.#.###.#.#.#.#####.###########.#.#.#.#.###\n#.....#...#.....#.#.#...###...............#.#...#.#.....#...#.......#.....#.........#...###...#.....#...#.#.#.#...#...#...#.......#.#.#...###\n#.#########.###.#.#.#.#.#################.#.#.###.#####.#####.#####.#.#############.###########.#######.#.#.#.###.#.###.#.#.#######.#.#######\n#...........#...#...#.#.#.......#.......#.#.#...#.#...#.#.....#...#...###...........#...###...#...#...#...#...###...###.#.#.......#.#.......#\n#############.#######.#.#.#####.#.#####.#.#.###.#.#.#.#.#.#####.#.#######.###########.#.###.#.###.#.#.#################.#.#######.#.#######.#\n###...#...#...###.....#.#.....#.#.....#.#.#.....#...#...#.......#.......#.............#...#.#...#...#.#.........#.....#.#.#...#...#.#.......#\n###.#.#.#.#.#####.#####.#####.#.#####.#.#.#############################.#################.#.###.#####.#.#######.#.###.#.#.#.#.#.###.#.#######\n#...#...#.#.....#...#...#.....#...#...#.#.#.......#.......#.............#.....#...........#.#...#...#...#.......#...#...#...#...#...#.###...#\n#.#######.#####.###.#.###.#######.#.###.#.#.#####.#.#####.#.#############.###.#.###########.#.###.#.#####.#########.#############.###.###.#.#\n#.......#.......#...#...#.#.....#...###...#...#...#.....#.#...........###.#...#...###.....#.#...#.#...#...#.......#.....#.......#...#.....#.#\n#######.#########.#####.#.#.###.#############.#.#######.#.###########.###.#.#####v###.###.#.###.#.###.#.###.#####.#####.#.#####.###.#######.#\n#.......#...#...#...#...#...#...#...###.......#.###...#.#...#.........#...#...#.>.>.#...#.#.#...#...#.#...#.#.....#...#...#.....###.....#...#\n#.#######.#.#.#.###.#.#######v###.#.###.#######.###.#.#.###.#.#########.#####.#.###.###.#.#.#.#####.#.###v#.#.#####.#.#####.###########.#.###\n#...#...#.#.#.#...#.#...#...>.>.#.#...#.......#...#.#.#.#...#.........#.#####.#.#...#...#.#.#...#...#.#.>.>.#.#...#.#.#...#...#.......#...###\n###.#.#.#.#.#.###.#.###.#.#####.#.###.#######.###.#.#.#.#.###########.#.#####.#.#.###.###.#.###.#.###.#.#####.#.#.#.#.#.#.###v#.#####.#######\n###...#...#.#.#...#...#.#.#...#.#...#...#...#...#.#.#.#.#...#...#...#.#.....#.#.#.#...###.#.#...#.###.#.....#.#.#.#.#.#.#.#.>.#...#...###...#\n###########.#.#.#####.#.#.#.#.#.###.###.#.#.###.#.#.#.#.###.#.#.#.#.#.#####.#.#.#.#.#####.#.#.###.###.#####.#.#.#.#.#.#.#.#.#v###.#.#####.#.#\n#.......###.#.#.#...#.#.#.#.#...#...#...#.#...#.#.#.#.#...#.#.#.#.#...#.....#...#.#.###...#.#...#...#...#...#.#.#.#.#.#.#.#.#...#.#.#...#.#.#\n#.#####.###.#.#.#.#.#.#.#.#.#####.###.###.###.#.#.#.#.###.#.#.#.#v#####.#########.#.###.###.###.###.###.#.###.#.#.#.#.#.#.#.###.#.#.#.#.#.#.#\n#.....#.....#.#.#.#.#.#.#.#.#...#...#.#...#...#.#.#.#.#...#.#.#.>.>...#.........#.#...#.#...###...#...#.#.#...#.#.#.#.#.#.#.#...#.#.#.#.#.#.#\n#####.#######.#.#.#.#.#.#.#.#.#.###.#.#.###.###.#.#.#.#.###.#.#######.#########.#.###.#.#.#######.###.#.#.#.###.#.#.#.#.#.#.#.###.#.#.#.#.#.#\n#####.........#...#...#...#...#.....#...###.....#...#...###...#######...........#.....#...#######.....#...#.....#...#...#...#.....#...#...#.#\n###########################################################################################################################################.#"

val seen = mutable.Set[(Int,Int)]()
def depthFirstSearchLongestPath(graph: mutable.HashMap[(Int,Int), mutable.HashMap[(Int,Int), Int]], point:(Int,Int), endPoint: (Int,Int) ): Int =
  if point == endPoint then
    return 0

  var m = -Int.MinValue

  seen.add(point)
  graph(point).foreach(nextPoint =>
    if !seen.contains(nextPoint._1) then
      m = Math.max(m, depthFirstSearchLongestPath(graph, nextPoint._1, endPoint) + graph(point)(nextPoint._1))
  )
  seen.remove(point)

  m

def partOne(input: String) =
  val maze = input.linesIterator.map(_.toCharArray).toArray

  val startPoint = (0, maze.head.indexOf('.'))
  val endPoint = (maze.length-1, maze.last.indexOf('.'))

  val junctionPoints = ListBuffer(startPoint, endPoint)

  // For each cell check how many available next paths to take.  If >= 1 then it means we're at a junction
  // We can apply edge contraction for the junctions
  maze.zipWithIndex.map {
    case (row, rowIdx) => row.zipWithIndex.collect{
      case (col, colIdx) if col != '#' =>

        var availablePaths = 0
        val directions = List((-1,0), (0,1), (1,0), (0,-1))

        directions.foreach( direction =>
          val nextRow = rowIdx + direction._1
          val nextCol = colIdx + direction._2

          if nextRow >=0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze.head.length && maze(nextRow)(nextCol) != '#' then
            availablePaths += 1
        )

        if availablePaths >= 3 then
          junctionPoints.addOne((rowIdx, colIdx))

    }
  }

  println(junctionPoints)

  // Now we have list of edges, lets construct a directed graph with weights.  Its directed because we cant go backwards
  val graph = mutable.HashMap[(Int,Int), mutable.HashMap[(Int,Int), Int]]()
  junctionPoints.foreach(point =>
    graph(point) = mutable.HashMap[(Int,Int), Int]()
  )

  val directions = mutable.HashMap[Char, List[(Int,Int)]](
                  '^' -> List((-1,0)),
                  '>' -> List((0,1)),
                  '<' -> List((0,-1)),
                  'v' -> List((1,0)),
                  '.' -> List((-1,0), (0,1), (0,-1), (1,0)))

  junctionPoints.foreach( (startingRow, startingCol) =>
      val stack = ListBuffer((0, startingRow, startingCol))
      val seen = mutable.Set((startingRow, startingCol))

      while stack.nonEmpty do {
        breakable {
          val (n, row, col) = stack.remove(0)

          if n != 0 && junctionPoints.contains((row, col)) then
            graph((startingRow, startingCol))((row, col)) = n
          else

            directions(maze(row)(col)).foreach(direction =>
              val nextRow = row + direction._1
              val nextCol = col + direction._2
              if nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze.head.length && maze(nextRow)(nextCol) != '#' && !seen.contains((nextRow, nextCol)) then
                stack.append((n + 1, nextRow, nextCol))
                seen.add((nextRow, nextCol))
            )
        }
      }

    )

  println(graph)
  println(depthFirstSearchLongestPath(graph, startPoint, endPoint))

def partTwo(input: String) =
  val maze = input.linesIterator.map(_.toCharArray).toArray

  val startPoint = (0, maze.head.indexOf('.'))
  val endPoint = (maze.length-1, maze.last.indexOf('.'))

  val junctionPoints = ListBuffer(startPoint, endPoint)

  // For each cell check how many available next paths to take.  If >= 1 then it means we're at a junction
  // We can apply edge contraction for the junctions
  maze.zipWithIndex.map {
    case (row, rowIdx) => row.zipWithIndex.collect{
      case (col, colIdx) if col != '#' =>

        var availablePaths = 0
        val directions = List((-1,0), (0,1), (1,0), (0,-1))

        directions.foreach( direction =>
          val nextRow = rowIdx + direction._1
          val nextCol = colIdx + direction._2

          if nextRow >=0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze.head.length && maze(nextRow)(nextCol) != '#' then
            availablePaths += 1
        )

        if availablePaths >= 3 then
          junctionPoints.addOne((rowIdx, colIdx))

    }
  }

  println(junctionPoints)

  // Now we have list of edges, lets construct a directed graph with weights.  Its directed because we cant go backwards
  val graph = mutable.HashMap[(Int,Int), mutable.HashMap[(Int,Int), Int]]()
  junctionPoints.foreach(point =>
    graph(point) = mutable.HashMap[(Int,Int), Int]()
  )

  junctionPoints.foreach( (startingRow, startingCol) =>
    val stack = ListBuffer((0, startingRow, startingCol))
    val seen = mutable.Set((startingRow, startingCol))

    while stack.nonEmpty do {
      breakable {
        val (n, row, col) = stack.remove(0)

        if n != 0 && junctionPoints.contains((row, col)) then
          graph((startingRow, startingCol))((row, col)) = n
        else

          List((-1,0), (0,1), (0,-1), (1,0)).foreach(direction =>
            val nextRow = row + direction._1
            val nextCol = col + direction._2
            if nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze.head.length && maze(nextRow)(nextCol) != '#' && !seen.contains((nextRow, nextCol)) then
              stack.append((n + 1, nextRow, nextCol))
              seen.add((nextRow, nextCol))
          )
      }
    }

  )

  println(graph)
  println(depthFirstSearchLongestPath(graph, startPoint, endPoint))



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
println(f"Part Two Puzzle Input Time Taken: $timeTaken ms")