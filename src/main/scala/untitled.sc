import scala.collection.mutable

class Test() {
  def message(): Unit =
    println("Test.Message")
}

class Test2() extends Test() {
  override def message(): Unit =
    println("Test2.Message2")
}

class Test1() extends Test() {
  override def message(): Unit =
    println("Test3.Message3")
}


val tests = List[Test](Test(), Test1(), Test2())

tests(0).message()
tests(1).message()
tests(2).message()

// Applying foreach method to print the queue

val q1 = mutable.Queue(1, 3, 2, 7, 6, 5)
print("Elements in the queue: ")
while q1.nonEmpty do
  val x = q1.dequeue()
  if x == 7 then q1.enqueue(10)
  print(x + " ")

