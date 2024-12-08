import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

val sampleInput = "broadcaster -> a, b, c\n%a -> b\n%b -> c\n%c -> inv\n&inv -> a"
val sampleInput2 = "broadcaster -> a\n%a -> inv, con\n&inv -> b\n%b -> con\n&con -> output"
val puzzleInput = "%rq -> ch, sj\n%nf -> sm, rg\n%pc -> rz, zp\n%xt -> bc\n%nt -> kq, sj\n%hc -> kb, zp\n%rd -> lk\n%ml -> pp, xt\n%sq -> kl, sj\n%jg -> fl, rg\n&xl -> df\n%kl -> mb, sj\n%nd -> rg, jg\n&rg -> cs, zb, cp, vz, gp\n%mf -> zp\n%rz -> zp, fr\n%kk -> rg, bj\n%nb -> qj\n%pr -> pp\n&zp -> vl, lk, rd, kb, xl\n%fl -> nf, rg\n%tb -> pk, pp\n%bh -> pp, pr\n%nh -> sj, rq\n%lk -> hc\n%cp -> kk\n&ln -> df\n&xp -> df\n%bc -> nb, pp\n%lj -> rg\n%vz -> nd\n%vl -> lv, zp\n&gp -> df\n%hd -> pp, bq\n%fq -> pp, bh\n%pk -> fq, pp\n%cs -> zb, rg\n%sn -> fd\n%kq -> sj, qq\n%zb -> vz\n%lv -> zp, rd\n%qj -> pp, hd\n%fd -> nt\n&df -> rx\nbroadcaster -> vl, cs, cn, ml\n%bq -> tb\n%kb -> pc\n%cn -> sn, sj\n%qq -> sq\n%mb -> sj, nh\n%jd -> zp, mf\n&sj -> xp, qq, cn, fd, sn\n&pp -> ln, ml, xt, bq, nb\n%sm -> rg, cp\n%ch -> sj\n%bj -> lj, rg\n%fr -> zp, mr\n%mr -> zp, jd"
var buttonPresses = 0
var loopState = true

enum ModuleType:
  case FlipFlop, Conjunction, Standard

enum Pulse:
  case High, Low, None

enum ModuleState:
  case On, Off

case class Action(fromModule: String, destinationModule: String, pulseToSendToDestination: Pulse)

var executionQueue = mutable.Queue[Module]()

case class Module(name: String, moduleType: ModuleType, destinations: List[String]) {
  def process(from: String, incomingPulse: Pulse): (Module, Pulse) =
    (Module(name, moduleType, destinations), Pulse.Low)

  def description: String =
    name + " " + destinations.size
}

class FlipFlopModule(name: String, moduleType: ModuleType, destinations: List[String], state: ModuleState) extends Module(name, moduleType, destinations) {
  override def process(from: String, incomingPulse: Pulse): (Module, Pulse) =
//    println(f"FlipFlopModule.Process $from $incomingPulse $state")
    if incomingPulse == Pulse.Low && state == ModuleState.Off then
      (FlipFlopModule(name, moduleType, destinations, ModuleState.On), Pulse.High)
    else if incomingPulse == Pulse.Low && state == ModuleState.On then
      (FlipFlopModule(name, moduleType, destinations, ModuleState.Off), Pulse.Low)
    else
      (FlipFlopModule(name, moduleType, destinations, state), Pulse.None)

  override def description: String =
    name + ", Type: " + moduleType + " " + ", state: " + state +  ", destinations: " + destinations
}

class ConjunctionModule(name: String, moduleType: ModuleType, destinations: List[String], memory: HashMap[String, Pulse]) extends Module(name, moduleType, destinations) {
  def listWatchers(): Unit =
    println(memory)

  def addInputWatcher(inputName: String):ConjunctionModule =
    val updatedMemory = memory + (inputName -> Pulse.Low)
    new ConjunctionModule(name, moduleType, destinations, updatedMemory)

  override def process(from: String, incomingPulse: Pulse): (Module, Pulse) =
//    println(f"Updating memory for input $from with $incomingPulse")
    val updatedMemory = memory + (from -> incomingPulse)
//    println(f"Memory updated $updatedMemory")

    if updatedMemory.count(_._2 == Pulse.High) == updatedMemory.size then
      // update the memory of the module and send out low pulse
//      println(f"ConjuctionModule= memory size of: ${updatedMemory.size} and both are set to High, so send a Low")
      (new ConjunctionModule(name, moduleType, destinations, updatedMemory), Pulse.Low)
    else
      // update the memory of the module and send out high pulse
//      println(f"ConjuctionModule= memory size of: ${updatedMemory.size} and not all are High so send a High")
      (new ConjunctionModule(name, moduleType, destinations, updatedMemory), Pulse.High)

  override def description: String =
    name + ", Type: " + moduleType + " " + ", memory: " + memory + ", destinations: " + destinations
}

class BroadcastModule(name: String, moduleType: ModuleType, destinations: List[String]) extends Module(name, moduleType, destinations) {
  override def process(from: String, incomingPulse: Pulse): (Module, Pulse) =
    (new BroadcastModule(name, moduleType, destinations), incomingPulse)

  override def description: String =
    name + ", Type: " + moduleType + " " + ", destinations: " + destinations
}

def process(modules: mutable.HashMap[String, Module]):ListBuffer[Pulse] =
  buttonPresses += 1

  val actionQueue = mutable.Queue[Action]()
  val totalPulsesEmitted = ListBuffer[Pulse]()

  val updatedModules = modules

  // add default destination broadcaster, low to the queue
  val startAction = Action("button","broadcaster", Pulse.Low)
  actionQueue.enqueue(startAction)

  var counter = 0

  while actionQueue.nonEmpty do
    counter += 1
//    if counter == 20 then
//      println("BREAKING OUT OF LOOP - COUNTER REACHED")
//      return totalPulsesEmitted

//    println(f"There are ${actionQueue.size} actions to process on the queue")
    val action = actionQueue.dequeue()
//    println(f"Processing current action $action")
    totalPulsesEmitted.addOne(action.pulseToSendToDestination)

    if modules.contains(action.destinationModule) then
      val moduleToProcess = modules(action.destinationModule)
  //    println(f"Module to process: ${moduleToProcess.name}, contains destinations ${moduleToProcess.destinations}")

  //    println(f"Current module state before processing is: ${moduleToProcess.description}")
      val (updatedModule, outputPulse) = moduleToProcess.process(action.fromModule, action.pulseToSendToDestination)

  //    println(f"Current module state has been updated to: ${updatedModule.description}")
      // save the updated module state
      updatedModules(moduleToProcess.name) = updatedModule // this will be returned from this function so that state can be carried forward to the next button press

  //    println(f"${moduleToProcess.name} state has been updated and saved to hashmap $updatedModules")

  //    println(f"${moduleToProcess.name} processed.  There are ${actionQueue.size} actions to process on the queue")

      updatedModule.destinations.foreach( destination =>
        if outputPulse != Pulse.None then
          val newAction = Action(updatedModule.name, destination, outputPulse)
  //        println(f"Sending ${newAction.fromModule} -$outputPulse-> $destination")
          actionQueue.enqueue(newAction)
  //      else
  //        println(f"${updatedModule.name} has no pulse to send - STOP")
      )
  //    println(f"There are now ${actionQueue.size} actions to process on the queue")
  //    println()

  totalPulsesEmitted

def processPartTwo(modules: mutable.HashMap[String, Module]):Unit =
  buttonPresses += 1

  val actionQueue = mutable.Queue[Action]()

  val updatedModules = modules

  // add default destination broadcaster, low to the queue
  val startAction = Action("button","broadcaster", Pulse.Low)
  actionQueue.enqueue(startAction)

  while actionQueue.nonEmpty do
    if buttonPresses == 100000 then
      println("BREAKING OUT OF LOOP - COUNTER REACHED")
      loopState = false
      return

    //    println(f"There are ${actionQueue.size} actions to process on the queue")
    val action = actionQueue.dequeue()
    //    println(f"Processing current action $action")

    if action.destinationModule == "df" && action.pulseToSendToDestination == Pulse.High then
      println(f"Action $action ${action.fromModule} $buttonPresses")

    if modules.contains(action.destinationModule) then
      val moduleToProcess = modules(action.destinationModule)
      //    println(f"Module to process: ${moduleToProcess.name}, contains destinations ${moduleToProcess.destinations}")

      //    println(f"Current module state before processing is: ${moduleToProcess.description}")
      val (updatedModule, outputPulse) = moduleToProcess.process(action.fromModule, action.pulseToSendToDestination)

      //    println(f"Current module state has been updated to: ${updatedModule.description}")
      // save the updated module state
      updatedModules(moduleToProcess.name) = updatedModule // this will be returned from this function so that state can be carried forward to the next button press

      //    println(f"${moduleToProcess.name} state has been updated and saved to hashmap $updatedModules")

      //    println(f"${moduleToProcess.name} processed.  There are ${actionQueue.size} actions to process on the queue")

      updatedModule.destinations.foreach( destination =>
        if outputPulse != Pulse.None then
          val newAction = Action(updatedModule.name, destination, outputPulse)
          //        println(f"Sending ${newAction.fromModule} -$outputPulse-> $destination")
          actionQueue.enqueue(newAction)
        //      else
        //        println(f"${updatedModule.name} has no pulse to send - STOP")
      )
  //    println(f"There are now ${actionQueue.size} actions to process on the queue")
  //    println()


def parse(input: String): mutable.HashMap[String, Module] =
  val modules = mutable.HashMap[String, Module]()
  input.linesIterator.map( line =>
    val s"$module -> $destinations" = line: @unchecked

    val moduleType = module(0) match {
      case '%' => ModuleType.FlipFlop
      case '&' => ModuleType.Conjunction
      case _ => ModuleType.Standard
    }

    val moduleName = module(0) match {
      case '%' => module.drop(1)
      case '&' => module.drop(1)
      case _ => module
    }

    val destinationList = destinations.split(",").map(_.trim).toList

    if moduleType == ModuleType.FlipFlop then
      FlipFlopModule(moduleName, moduleType, destinationList, ModuleState.Off)
    else if moduleType == ModuleType.Conjunction then
      ConjunctionModule(moduleName, moduleType, destinationList, HashMap[String, Pulse]())
    else
      BroadcastModule(moduleName, moduleType, destinationList)
  ).toList.zipWithIndex.foreach{ case (item,idx) =>
    modules(item.name) = item
  }

  modules.foreach( module =>
    // loop through each module and check the destinations
    module._2.destinations.foreach( destination =>
      if modules.contains(destination) && modules(destination).moduleType == ModuleType.Conjunction then
        val updatedConjunctionModule = modules(destination).asInstanceOf[ConjunctionModule].addInputWatcher(module._1)
        modules(updatedConjunctionModule.name) = updatedConjunctionModule
    )
  )

  modules

def partOne(input: String): Long =
  // start the process by adding destination broadcaster with pulse low to the execution queue
  // then call process
  val modules = parse("button -> broadcaster\n" + input)
  println(f"Number of modules: ${modules.size}")
//  modules("inv").asInstanceOf[ConjunctionModule].listWatchers()
  println("START PROCESSING")

  val totalPulsesEmitted = (1 to 1000).map( i =>
    process(modules)
  ).toList.flatten

  println("END PROCESSING")

  val totalLowPulse = totalPulsesEmitted.count(_ == Pulse.Low)
  val totalHighPulse = totalPulsesEmitted.count(_ == Pulse.High)

  println(f"Total Low Pulses: $totalLowPulse")
  println(f"Total Low Pulses: $totalHighPulse")

  totalLowPulse * totalHighPulse

def partTwo(input: String): Unit =
  val modules = parse("button -> broadcaster\n" + input)
  println(f"Number of modules: ${modules.size}")
  println("START PROCESSING")

  while loopState do {
    processPartTwo(modules)
  }

  println("END PROCESSING")



var startTime = System.currentTimeMillis()
partOne(sampleInput)
var timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Sample Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partOne(sampleInput2)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Sample Input 2 Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partOne(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Puzzle Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partTwo(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part Two Puzzle Input Time Taken: $timeTaken ms")


//When we run the program we can see that after button press 6833, 7021 etc there starts to be a cycle where the
//input to df (which is the dependency of rx) is high
//we need to find which button press will result in all 4 inputs to df will send high.
// As this will cause df to send low to rx.  Once we know the cycle lengths we can find out which is the
// first button press when the cycles will align to all send high to df.
// This will be the LCM - lowest common multiple of all 4 cycle lengths
//10666 - 6833 = 3833 cycle length
//11042 - 7021 = 4021 cycle length
//11102 - 7051 = 4051 cycle length
//11114 - 7057 = 4057 cycle length
//LCM https://www.calculatorsoup.com/calculators/math/lcm.php
// 3833 4021 4051 4057 = 253302889093151