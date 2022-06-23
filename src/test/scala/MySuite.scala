import MyList.*
import scala.collection.mutable
import munit.FunSuite
 

class MySuite extends FunSuite {

  test("map") {
    val obtained = MyList.of(11, 12, 13, 14, 15)
    val expected = MyList.of(1, 2, 3, 4, 5).map(a => a + 10)
    assertEquals(obtained, expected)
  }
  
  test("reverse") {
    val obtained = MyList.of(5, 4, 3, 2, 1)
    val actual = MyList.of(1, 2, 3, 4, 5).reverse()
    assertEquals(obtained, actual)
  }

  test("reverseClearList") {
    val obtained = MyList.of()
    val actual = MyList.of().reverse()
    assertEquals(obtained, actual)
  }

  test("filter") {
    val obtained = MyList.of(1, 2)
    val expected = MyList.of(1, 2, 3, 4, 5).filter(a => a < 3)
    assertEquals(obtained, expected)
  }
 
  test("indexOf") {
    val obtained = Some(3)
    val expected = MyList.of(1, 2, 3, 4, 5).indexOf(3)
    assertEquals(obtained, expected)
  }
}

