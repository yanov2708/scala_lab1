import MyList.*
import scala.collection.mutable
import munit.FunSuite
 

class MySuite extends FunSuite {

  test("map+") {
    val obtained = MyList(1, 2, 3, 4, 5).map(a => a + 10)
    val expected = MyList(11, 12, 13, 14, 15)
    assertEquals(expected, obtained)
  }

  test("map*") {
    val obtained = MyList(1, 2, 3, 4, 5).map(a => a * 5)
    val expected = MyList(5, 10, 15, 20, 25)
    assertEquals(expected, obtained)
  }
  
  test("reverse") {
    val obtained = MyList(1, 2, 3, 4, 5).reverse()
    val expected = MyList(5, 4, 3, 2, 1)
    assertEquals(expected, obtained)
  }

  test("reverseReverse") {
    val obtained = MyList(1, 2, 3, 4, 5).reverse().reverse()
    val expected = MyList(1, 2, 3, 4, 5)
    assertEquals(expected, obtained)
  }

  test("reverseClearList") {
    val obtained = MyList().reverse()
    val expected = MyList()
    assertEquals(expected, obtained)
  }

  test("filter") {
    val obtained = MyList(1, 2, 3, 4, 5).filter(a => a < 3)
    val expected = MyList(1, 2)
    assertEquals(expected, obtained)
  }
 
  test("indexOf") {
    val obtained = MyList(1, 2, 3, 4, 5).indexOf(3)
    val expected = Some(2)
    assertEquals(expected.get, obtained.get)
  }

}

