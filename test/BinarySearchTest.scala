import org.scalatest.FlatSpec

class BinarySearchTest extends FlatSpec {

  behavior of "BinarySearch"

  it should "search in an array of ordered integers for a case" in {
    assert(BinarySearch.binarySearch(Array(1,5,8,12,13), 8) ===  2)
  }

  it should "search in an array of ordered integers for b case" in {
    assert(BinarySearch.binarySearch(Array(1), 8) ===  -1)
  }

}
