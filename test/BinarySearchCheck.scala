import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}
import scala.math.Ordering._

object BinarySearchCheck extends Properties("BinarySearch"){

  val genNumbers: Gen[Int] = Gen.choose(1, 1000)
  val listOfNumbers: Gen[Array[Int]] =
    for {
      size <- Gen.choose(1,100)
      elems <- Gen.containerOfN[Set, Int](size, genNumbers)
    } yield elems.toList.sorted.toArray

  property("linear and binary search shoul be equivalent") =
    forAll(genNumbers, listOfNumbers) {(n,list)  =>
      val linear = BinarySearch.linearSearch(list,n)
      val binary = BinarySearch.binarySearch(list,n)
      val assertion =  linear == binary
      if (!assertion)
        System.out.println(s"ERROR for list : ${list.mkString(",")} and number: $n result linear: $linear and binary: $binary")
      assertion
    }

}
