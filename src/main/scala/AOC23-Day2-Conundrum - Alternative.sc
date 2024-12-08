case class Colors(color: String, count: Int)
case class Game(id: Int, hands: List[List[Colors]])

// Summary type alias for any function that has a Game param and returns an Int
type Summary = Game => Int

def parseColors(pair: String): Colors =
  val (s"$value $name") = pair: @unchecked
  Colors(color = name, count = value.toInt)

def parse(line: String): Game =
  val (s"Game $id: $hands0") = line: @unchecked
  val hands1 = hands0.split("; ").toList
  val hands2 = hands1.map(_.split(", ").toList.map(parseColors))
  Game(id = id.toInt, hands = hands2)

def solution(input: String, summarise: Summary): Int =
  input.linesIterator.map(parse andThen summarise).sum

val possibleCubes = Map(
  "red" -> 12,
  "green" -> 13,
  "blue" -> 14,
)

def validGame(game: Game): Boolean =
  game.hands.forall: hand =>
    hand.forall:
      case Colors(color, count) =>
        count <= possibleCubes.getOrElse(color, 0)

val possibleGame: Summary =
  case game if validGame(game) => game.id
  case _ => 0

def part1(input: String): Int = solution(input, possibleGame)

val initial = Seq("red", "green", "blue").map(_ -> 0).toMap

def minimumCubes(game: Game): Int =
  var maximums = initial
  for
    hand <- game.hands
    Colors(color, count) <- hand
  do
    maximums += (color -> (maximums(color) `max` count))
  maximums.values.product

def part2(input: String): Int = solution(input, minimumCubes)

part1("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
  "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")

part2("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
  "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")

//"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
//, "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
//, "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
//, "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
//, "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"