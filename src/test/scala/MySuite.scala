import MyList.*
import scala.collection.mutable
import munit.FunSuite
 

class MySuite extends FunSuite {

  test("map") {
    val expected = MyList(1, 2, 3, 4, 5).map(a => a + 10)
    val obtained = MyList(11, 12, 13, 14, 15)
    assertEquals(obtained, expected)
  }
  
  test("reverse") {
    val expected = MyList(1, 2, 3, 4, 5).reverse()
    val obtained = MyList(5, 4, 3, 2, 1)
    assertEquals(obtained, expected)
  }

  test("reverseClearList") {
    val expected = MyList().reverse()
    val obtained = MyList()
    assertEquals(obtained, expected)
  }

  test("filter") {
    val expected = MyList(1, 2, 3, 4, 5).filter(a => a < 3)
    val obtained = MyList(1, 2)
    assertEquals(obtained, expected)
  }
 
  test("indexOf") {
    val expected = MyList(1, 2, 3, 4, 5).indexOf(3)
    val obtained = Some(2)
    assertEquals(obtained.get, expected.get)
  }
  test("indexOf11") {
    val expected = MyList(1, 2, 3, 4, 5).indexOf(6)
    val obtained = None
    assertEquals(obtained, expected)
  }
}

