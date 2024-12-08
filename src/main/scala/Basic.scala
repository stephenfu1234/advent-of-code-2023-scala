@main
def startApp =
  ifStatement()
  println(maxSquareDoubled(2, 3))
  println(divide(1,0))
  println(divide(2,1))

  val tupleResult = sumAndDifference(10, 5)
  println(tupleResult._1)
  println(tupleResult._2)

  val (sum, difference) = sumAndDifference(10, 5)
  println(sum)
  println(difference)

  infixRewrittingRules()

  cons()

  maps()

  forLoops()

def testBasicTypes =
  val a: Int = 1
  val b = 1
  val c: Float = 1.1f
  val d = 1.1f
  val e = 1.1

  println(s"a is of type ${a.getClass} with value ${a}")
  println(s"b is of type ${b.getClass} with value ${b}")
  println(s"c is of type ${c.getClass} with value ${c}")
  println(s"d is of type ${d.getClass} with value ${d}")
  println(s"e is of type ${e.getClass} with value ${e}")

//  return type inferred
def add(a: Int, b: Int) = a + b

// return type explicit
def addWithExplicitReturnType(a: Int, b: Int): Int = a + b

def ifStatement() =
  val check = false
  if (check) println("A")
  else println("B")

def maxSquareDoubled(a: Int, b: Int) =
  if (a > b) {
    val squared = a * a
    squared * 2
  } else {
    val squared = b * b
    squared * 2
  }

def divide(a: Int, b: Int) =
  val division = try {
    a/b
  } catch {
    case ae: ArithmeticException => println("error")
  } finally {
    println("finally")
  }
  division

// Favour expressions with a return rather than statements

// tuples
def sumAndDifference(a: Int, b: Int): (Int, Int) =
  val sum = a + b
  val difference = a - b
  (sum, difference)

def infixRewrittingRules(): Unit =
  println(1 + 2)
  println(1.+(2))
  println("hello".charAt(3))
  println("hello" charAt 3)

  println(List(1, 2, 3).map(_ * 2))
  println(List(1, 2, 3) map {
    _ * 2
  })

  // these are the same
  val args = Array("Jane", "John")
  val args2 = Array.apply("Jane", "John")

  println(args(0))
  println(args2(0))

  println(args.apply(0))
  println(args2.apply(0))

  args(0) = "Stog"
  args2.update(0, "Stog")
  println(args(0))
  println(args2(0))

  val args3 = List("Jane", "John")
  val args4 = List.apply("Jane", "John")

  // These dont work because List is not mutable
  //args3(0) = "Stog"
  //args4.update(0, "Stog")

  // [Int] is optional as it can be inferred from the contents
  val args5 = Array[Int](1,2,3)

def cons() = {
  // Add to head of the list
  val list = Nil.::(3).::(2).::(1)
  println(list)

  val list2 = Nil.::(6).::(5).::(4)

  // this does not concatenate, it produces List[Any] = List(List(1,2,3),4,5,6)
  println(list :: list2)

  // this concatenates
  println(list ::: list2)
}

def maps() = {

  // create a tuple using ->
  // 1 -> "One" gets rewritten by Scala to ArrowAssoc(1).->("One")

  val myMap = Map(
    1 -> "One",
    2 -> "Two",
    3 -> "Three"
  )

  for((step, instruction) <- myMap) {
    println(s"Step $step - $instruction")
  }
}

def forLoops() = {
  for {
    i <- 1 to 3
    j <- 1 to 3
  } println(i * j)

  // this has no side effects
  val a = for(i <- 1 to 10) yield i * 2
  println(a)
}