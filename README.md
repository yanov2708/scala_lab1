 Lab_1_FP_1variant
 
List[A]
foldLeft
map(xs: List[A], f: A => B): List[B] (напряму рекурсивно ТА через foldLeft)
reverse(xs: List[A]): List[A] (напряму рекурсивно ТА через foldLeft)
filter(xs: List[A], pred: A => Boolean): List[A] (аналогічно) (залишити тільки ті елементи, які задовольняють f)
indexOf(xs: List[A], a: A): Option[Int]
reduce(xs: List[A], f: (A, A) => A): Option[A] // чому Option? Треба буде дати відповідь    (option повертає обо нічого або щось, і якщо ліст пустий - повертаюмо Nil)

