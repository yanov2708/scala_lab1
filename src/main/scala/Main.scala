import MyList.*
import scala.collection.mutable.StringBuilder

enum MyList[+A]:
  case MyCons(h: A, t: MyList[A])
  case MyNil

  
  def foldLeft[A,B](xs: MyList[A],z:B )(f:(A,B)=>B): B= {
    @scala.annotation.tailrec
    def go(xs: MyList[A],acc:B)(f:(A,B)=>B): B=  {
      xs match{
        case MyNil => acc
        case MyCons(hd, tl) => go(tl,f(hd, acc))(f)
      }
    }
    go(xs, z)(f)
  }
  
  
  def map[B](f: A => B): MyList[B] = {
    @scala.annotation.tailrec
    def go[A,B](xs: MyList[A], f: A => B, result: MyList[B] = MyNil): MyList[B] = {
      xs match{
        case MyNil => result.reverse()
        case MyCons(hd, tl) => go(tl, f, MyCons(f(hd), result))
      }
      
    }
    go(this, f)
    
  }
  
  
  def reverse(): MyList[A] = {
    @scala.annotation.tailrec
    def go[A](xs: MyList[A], result: MyList[A] = MyNil): MyList[A] = {
      xs match{
        case MyNil=> result
        case MyCons(hd, tl) => go(tl, MyCons(hd, result))
      }
    }
    go(this)
  }
  

  def filter(f: A => Boolean): MyList[A] = {
      @scala.annotation.tailrec
      def go[A](xs: MyList[A], f: A => Boolean, result: MyList[A] = MyNil): MyList[A] = {
        xs match{
          case MyNil => result.reverse()
          case MyCons(hd, tl) => if f(hd) then go(tl, f, MyCons(hd, result)) else go(tl, f, result) 
        }

      }
      go(this, f)

    }


  def indexOf[A](a: A): Option[Int] = {
    @scala.annotation.tailrec
    def go[A](xs: MyList[A], a: A, index: Int = 0): Option[Int] = {
      xs match {
        case MyNil => None
        case MyCons(hd, tl) =>
          if hd == a then Some(index)
          else go(tl, a, index + 1)
      }
    }
    go(this, a)
  }


  def reduce(f: (A, A) => A): Option[A] = {
    @scala.annotation.tailrec
      def go[A](xs: MyList[A], f: (A, A) => A, result: Option[A] = None): Option[A] = {
        xs match {
          case MyNil => result
          case MyCons(hd, tl) => go(tl, f, Some(f(hd, result.getOrElse(hd))) ) 
        }

      }
      go(this, f)

  }


  override def toString: String =
    @scala.annotation.tailrec 
    def go(sb: StringBuilder, as: MyList[A]): String = {
      as match {
        case MyNil => 
          sb.result
        case MyCons(h, t) => 
          go(
            sb
              .append(h)
              .append(if t == MyNil then "]" else ", "), 
            t
          )
      }
    }
    go(new StringBuilder("["), this)


object MyList:
  def apply[A](xs: A*) = of(xs*)
  def of[A](xs: A*): MyList[A] =
    xs.foldRight(MyNil: MyList[A]) { case (x, acc) => MyCons(x, acc) }

@main def main() = {
  println(MyList(1,2,3,4,5).indexOf(3))
  println(MyList(1,2,3,4,5).reverse())
  println(MyList(1,2,3,4,5).map(a => a + 1))
  println(MyList(1,2,3,4,5).filter(a => a < 4))
  println(List(1,2).reduce)

}