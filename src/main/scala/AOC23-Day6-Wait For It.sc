case class Race(time: Long, recordDistance: Long)

def setupSampleData: List[Race] =
  List(Race(time=7, recordDistance=9), Race(time=15, recordDistance=40), Race(time=30, recordDistance=200))

def setupPuzzle1Data: List[Race] =
  List(Race(time=49, recordDistance=298), Race(time=78, recordDistance=1185), Race(time=79, recordDistance=1066), Race(time=80, recordDistance=1181))

def setupPuzzle2Data: List[Race] =
  List(Race(time=49787980, recordDistance=298118510661181L))

def calculateRaceOptions(raceTime: Long) : List[Long] =
  (1L until raceTime).map(buttonPressTime =>
    (raceTime - buttonPressTime) * buttonPressTime
  ).toList

def calculateWinningOptions(raceTime: Long, raceOptions: List[Long], recordDistance:Long): Long =
  // opportunity to half the time as its a mirror image
  // (e.g. pressing 1-6ms produces distances of 6,10,12,12,10,6
  raceOptions.count(_ > recordDistance)

def solve(races: List[Race]): Long =
  val winners = races.map(race =>
    val raceOptions = calculateRaceOptions(race.time)

    calculateWinningOptions(race.time, raceOptions, race.recordDistance)
  )
  winners.foreach(println)
  winners.product

solve(setupSampleData)
solve(setupPuzzle1Data)

// solve puzzle 2 with reverse calculation to avoid brute force approach
// get the record time to beat
// calculate the time you would need to press the button get this value based on the race time
// we can then derive what options are there to beat this time
def deriveWinningOptions(raceTime: Long, recordDistance:Long): Long =
    var minRequiredButtonPressTime = math.ceil(
      (raceTime.toDouble - math.sqrt((raceTime.toDouble * raceTime.toDouble)-(4*recordDistance)))/2
    ).toLong
    println("min " + minRequiredButtonPressTime)

    val distance = minRequiredButtonPressTime*(raceTime - minRequiredButtonPressTime)
    if( distance == recordDistance ) {
      println("min step distance equals record distance so increase the min ")
      minRequiredButtonPressTime += 1
      println("min " + minRequiredButtonPressTime)
    }
    raceTime + 1 - (minRequiredButtonPressTime * 2)

def solveVersion2(races: List[Race]): Long =
  val winners = races.map(race =>
    deriveWinningOptions(race.time, race.recordDistance)
  )
  winners.foreach(println)
  winners.product


solveVersion2(setupSampleData)
solveVersion2(setupPuzzle1Data)
solveVersion2(setupPuzzle2Data)