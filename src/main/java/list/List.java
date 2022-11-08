package list;


import fpinjava.Function;
import fpinjava.Result;
import fpinjava.TailCall;
//import set.Set;




import static fpinjava.TailCall.ret;
import static fpinjava.TailCall.sus;
//import static set.ListSet.empty;
//import static set.ListSet.fromList;

public abstract class List<A> {

    public abstract List<A> reverse();

    public abstract <B> List<B> map(Function<A, B> f);

    public abstract List<A> init();

    public abstract boolean equals(Object o);

    public abstract boolean elem(A x);

    public abstract boolean any(Function<A, Boolean> p);

    //public abstract boolean allMitAnyL(Function<A, Boolean> p, List<A> list);

    public abstract boolean all(Function<A, Boolean> p);

    public abstract List<A> filter(Function<A, Boolean> f);

    public abstract List<A> takeWhile(Function<A, Boolean> p);

    public abstract List<A> dropWhile(Function<A, Boolean> p);

    public abstract List<A> take(int n);

    public abstract List<A> drop(int n);

    public abstract A last();

    public abstract A lastL(List<A> list);

    public abstract A finde(Function<A, Boolean> f);

    public abstract Result<A> find(Function<A, Boolean> f);

    public abstract List<A> delete(A x);

    public abstract A head();

    public abstract List<A> tail();

    public abstract boolean isEmpty();

    public abstract List<A> setHead(A h);

    public abstract boolean isEqualTo(List<A> xs);

    public abstract <B> B foldl(Function<B, Function<A, B>> f, B identity);

    abstract <B> B foldr(Function<A, Function<B, B>> f, B identity);

    public List<A> cons(A a) {
        return new Cons<>(a, this);
    }

    //public abstract Set<A> toSet();

    //public abstract List<A> nub();



    public abstract int length();


    @SuppressWarnings("rawtypes")
    public static final List NIL = new Nil();

    private List() {
    }


    public abstract Result<A> headOption();


    private static class Nil<A> extends List<A> {

        private Nil() {
        }

        public String toString() {
            return "[NIL]";
        }

        public int length() {
            return 0;
        }

        @Override
        public <B> B foldl(Function<B, Function<A, B>> f, B identity) {
            return identity;
        }

        @Override
        public <B> B foldr(Function<A, Function<B, B>> f, B identity) {
            return identity;
        }

        //@Override
        //public Set<A> toSet() { return empty(); }

        //@Override
        //public List<A> nub() {
        //    return list();
        //}

        @Override
        public boolean equals(Object o) {
            return o instanceof Nil;
        }

        @Override
        public boolean elem(A x) {
            return false;
        }

        @Override
        public boolean any(Function<A, Boolean> p) {
            return false;
        }

        @Override
        public boolean all(Function<A, Boolean> p) {
            return true;
        }

        /*
            @Override
            public boolean allMitAnyL(Function<A, Boolean> p, List<A> list) {
                return true;
            }
        */
        @Override
        public List<A> filter(Function<A, Boolean> f) {
            return list();
        }

        @Override
        public List<A> takeWhile(Function<A, Boolean> p) {
            return list();
        }

        @Override
        public List<A> dropWhile(Function<A, Boolean> p) {
            return list();
        }

        @Override
        public List<A> take(int n) {
            return list();
        }

        @Override
        public List<A> drop(int n) {
            return list();
        }

        @Override
        public A last() {
            throw new IllegalStateException("last called on empty list");
        }

        @Override
        public A lastL(List<A> list) {
            throw new IllegalStateException("last called on empty list");
        }

        @Override
        public Result<A> find(Function<A, Boolean> f) {
            return Result.empty();
        }

        @Override
        public List<A> delete(A x) {
            return list();//throw new IllegalStateException("delete called on empty list");
        }

        @Override
        public <B> List<B> map(Function<A, B> f) {
            return list();
        }

        @Override
        public List<A> init() {
            throw new IllegalStateException("init called on empty list");
        }

        @Override
        public List<A> reverse() {
            return list();
        }

        @Override
        public A finde(Function<A, Boolean> p) {
            return null;
        }

        public A head() {
            throw new IllegalStateException("head called en empty list");
        }

        public List<A> tail() {
            throw new IllegalStateException("tail called en empty list");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public List<A> setHead(A h) {
            throw new IllegalStateException("setHead called on empty list");
        }

        @Override
        public boolean isEqualTo(List<A> xs) {
            return xs.isEmpty();
        }

        @Override
        public Result<A> headOption() {
            return Result.empty();
        }


    }

    private static class Cons<A> extends List<A> {

        private final A head;
        private final List<A> tail;

        private Cons(A head, List<A> tail) {
            this.head = head;
            this.tail = tail;
        }

        public String toString() {
            return String.format("[%sNIL]",
                    toString(new StringBuilder(), this).eval());
        }

        private TailCall<StringBuilder> toString(StringBuilder acc, List<A> list) {
            return list.isEmpty()
                    ? ret(acc)
                    : sus(() -> toString(acc.append(list.head()).append(", "),
                    list.tail()));
        }
        /*
                private TailCall<StringBuilder> toStringR(StringBuilder acc, List<A> list) {
                    return list.isEmpty()
                            ? ret(acc)
                            : sus(() -> toString(acc.append(list.head()).append(", "),
                            list.tail()));
                } //Noch nicht implementiert
        */
        @Override
        public boolean equals(Object o) {
            return o instanceof Cons && isEqualTo((List<A>) o);
        }

        @Override
        public int length() {
            return 1 + tail().length();
        }

        @Override
        public boolean elem(A x) {
            return x.equals(this.head()) || this.tail().elem(x);        //Fehlerhaft
        }

        @Override
        public boolean any(Function<A, Boolean> p) {
            return p.apply(this.head()) || this.tail().any(p);
        }

        /*
              @Override
              public boolean allMitAnyL(Function<A, Boolean> p, List<A> list) {
                  return anyL(x -> !p.apply(x), list);
              }
        */
        @Override
        public boolean all(Function<A, Boolean> p) {
            return p.apply(head()) && this.tail().all(p);
        }

        @Override
        public List<A> filter(Function<A, Boolean> f) {
            return f.apply(head()) ? new Cons<>(head(), tail().filter(f)) : tail().filter(f);
        }

        @Override
        public List<A> takeWhile(Function<A, Boolean> p) {
            return p.apply(head()) ? new Cons<>(head(), tail().takeWhile(p)) : list();
        }

        /*
        public List<A> takeWhile(Function<A, Boolean> f) {
            return takeWhile_(this, f).eval();   // Fehlerhaft
        }

        private TailCall<List<A>> takeWhile_(List<A> list, Function<A, Boolean> f) {
            return !list.isEmpty() && f.apply(list.head())
                    ? sus(() -> takeWhile_(list.tail(), f))
                    : ret(list);
        }
  */
        @Override
        public List<A> dropWhile(Function<A, Boolean> f) {
            return dropWhile_(this, f).eval();
        }

        private TailCall<List<A>> dropWhile_(List<A> list, Function<A, Boolean> f) {
            return !list.isEmpty() && f.apply(list.head())
                    ? sus(() -> dropWhile_(list.tail(), f))
                    : ret(list);
        }

        /*
              public List<A> take(int n) {
                  return n <= 0 ? list() : new Cons<>(list.head(), take(n-1, list.tail()));
              }
        */
        @Override
        public List<A> take(int n) {
            return n <= 0 ? list() : new Cons<>(head(), tail().take(n - 1));
        }

        /*
        public List<A> take(int n) {
            return n <= 0
                    ? this
                    : take_(this, n).eval();

        }
        private TailCall<List<A>> take_(List<A> list, int n) {
            return n <= 0 || list.isEmpty()
                    ? ret(list)
                    : sus(() -> take_(list.tail(), n - 1));       // Fehlerhaft
        }
  */

        @Override
        public List<A> drop(int n) {
            return n <= 0
                    ? this
                    : drop_(this, n).eval();
        }

        private TailCall<List<A>> drop_(List<A> list, int n) {
            return n <= 0 || list.isEmpty()
                    ? ret(list)
                    : sus(() -> drop_(list.tail(), n - 1));
        }

        /*
                @Override
                public List<A> drop(int n) {
                    return n <= 0 ? this: tail().drop(n - 1);
                }
        */
        @Override
        public A last() {
            return reverse().tail().head();
        }

        @Override
        public A lastL(List<A> list) {
            return foldl(x -> y -> y, null, this);
        }

        @Override
        public Result<A> find(Function<A, Boolean> f) {
            return filter(f).headOption();
        }
        //Result.success(filterR(f).head());
        //return f.apply(head) ? head : finde(f);

        @Override
        public List<A> delete(A x) {
            return x.equals(head()) ? tail() : new Cons<>(head(), tail().delete(x));
        }

        /*
        @Override
        public List<A> delete(A x) {
            return filter(y -> y.equals(x));
        }
*/
        /*
        public List<A> delete(A x) {
            return x.equals(head()) ? tail() : new Cons<>(head(), tail().delete(x));
        }
  */
        @Override
        public <B> List<B> map(Function<A, B> f) {
            return new Cons<>(f.apply(head()), this.tail().map(f));
        }

        public List<A> init() {
            return reverse().tail().reverse();
        }

        @Override
        public List<A> reverse() {
            return reverse_(list(), this).eval();
        }

        private TailCall<List<A>> reverse_(List<A> acc, List<A> list) {
            return list.isEmpty()
                    ? ret(acc)
                    : sus(() -> reverse_(new Cons<>(list.head(), acc), list.tail()));
        }

        @Override
        public A finde(Function<A, Boolean> p) {
            return p.apply(head()) ? head() : tail().finde(p);
        }
        //!filter(p).isEmpty() ? filter(p).head() : null;

        @Override
        public Result<A> headOption() {
            return Result.success(head());
        }

        public A head() {
            return head;
        }

        public List<A> tail() {
            return tail;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public List<A> setHead(A h) {
            return new Cons<>(h, this.tail);
        }

        @Override
        public boolean isEqualTo(List<A> xs) {
            return !xs.isEmpty() && head().equals(xs.head()) && tail().isEqualTo(xs.tail());
            //return takeWhile(y -> y==(xs.head())) == xs;
        }

        @Override
        public <B> B foldl(Function<B, Function<A, B>> f, B identity) {
            return isEmpty() ? identity : foldl(f, f.apply(identity).apply(head()), tail());
        }

        @Override
        <B> B foldr(Function<A, Function<B, B>> f, B identity) {
            return isEmpty() ? identity : f.apply(head()).apply(foldr(tail(), identity, f));
        }

        //@Override
        //public Set<A> toSet() { return fromList(this); }

        //@Override
        //public List<A> nub() {
        //    return fromList(this).toList();
        //}


    }


    @SuppressWarnings("unchecked")
    public static <A> List<A> list() {
        return NIL;
    }

    @SafeVarargs
    public static <A> List<A> list(A... a) {
        List<A> n = list();
        for (int i = a.length - 1; i >= 0; i--) {
            n = new Cons<>(a[i], n);
        }
        return n;
    }

    public Boolean elemMitAnyL(List<A> xs, A y) {
        return anyL(x -> x.equals(y), xs);
    }

    /*
        public List<A> reverse() {
            return reverse_(list(), this).eval();
        }

        private TailCall<List<A>> reverse_(List<A> acc, List<A> list) {
            return list.isEmpty()
                    ? ret(acc)
                    : sus(() -> reverse_(new Cons<>(list.head(), acc), list.tail()));
        }
    */
    public List<A> reverseL() {
        return foldl(xs -> xs::cons, list());
    }

    /*
    public List<A> init() {
        return reverse().tail().reverse();
    }
*/
    /*
    public static <A,B> List<B> map(Function<A,B> f, List<A> list) {
        return list.isEmpty()
                ? list()
                : new Cons<>(f.apply(list.head()), map(f, list.tail()));
    }
*/
    public <B> List<B> mapR(Function<A, B> f) {
        return foldr(h -> t -> new Cons<>(f.apply(h), t), list());
    }

    public List<A> filterR(Function<A, Boolean> f) {
        return foldr(h -> t -> f.apply(h) ? new Cons<>(h, t) : t, list());
    }

    public static boolean and(List<Boolean> list) {
        return list.isEmpty() || list.head() && and(list.tail());
    }

    public static boolean andR(List<Boolean> list) {
        return foldr(list, true, x -> y -> x && y);
    }

    public static boolean andL(List<Boolean> list) {
        return foldr(list, true, y -> x -> x && y);
    }

    public static boolean or(List<Boolean> list) {
        return !list.isEmpty() && (list.head() || or(list.tail()));
    }

    public static boolean orR(List<Boolean> list) {
        return foldr(list, false, x -> y -> x || y);
    }

    public static boolean orL(List<Boolean> list) {
        return foldr(list, false, y -> x -> x || y);
    }

    public static <A> List<A> append(List<A> list1, List<A> list2) {
        return list1.isEmpty()
                ? list2
                : new Cons<>(list1.head(), append(list1.tail(), list2));
    }

    public static <A> List<A> appendR(List<A> list1, List<A> list2) {
        return foldr(list1, list2, x -> y -> new Cons<>(x, y));
    }

    public static Integer sum(List<Integer> list) {
        return list.isEmpty() ? 0 : list.head() + sum(list.tail());
    }

    public static Integer sumR(List<Integer> list) {
        return foldr(list, 0, x -> y -> x + y);
    }

    public static Integer sumL(List<Integer> list) {
        return foldl(y -> x -> x + y, 0, list);
    }

    public static Double prod(List<Double> list) {
        return list.isEmpty() ? 1 : list.head() * prod(list.tail());
    }

    public static Double prodR(List<Integer> list) {
        return foldr(list, 1.0, x -> y -> x * y);
    }

    public static Double prodL(List<Integer> list) {
        return foldl(y -> x -> x * y, 1.0, list);
    }

    public int lengthR() {
        return foldr(this, 0, x -> y -> y + 1);
    }

    public int lengthL() {
        return foldl(y -> x -> y + 1, 0, this);
    }
/*
    public static Integer minimum(List<Integer> list) {
        if (list.isEmpty()) throw new IllegalStateException("Minimum of Empty List");
        return list.head() > list.tail().head()
                ? list.head()
                : minimum(list.tail());
    }

 */
/*
    public static Integer minimum(List<Integer> list) {
        if (list.isEmpty())
            throw new IllegalStateException("minimum called on empty list");
        return (list.length() == 1) ? list.head() : Math.min(list.head(), minimum(list.tail()));
    }
*/

    public static <A extends Comparable<A>> A minimum(List<A> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("minimum of empty List");
        } else {
            return (list.length() == 1) || list.filter(x -> x.compareTo(list.head()) <= 0).length() <= 1 ? list.head() : minimum(list.tail());
        }

    }

    public static <A extends Comparable<A>> A maximum(List<A> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("maximum of empty List");
        } else {
            return (list.length() == 1) || list.filter(x -> x.compareTo(list.head()) >= 0).length() <= 1 ? list.head() : maximum(list.tail());
        }
    }

    /*
        public static Integer maximum(List<Integer> list) {
            if (list.isEmpty()) throw new IllegalStateException("maximum of empty list");
            return list.head() > list.tail().head()
                    ? list.head()
                    : maximum(list.tail());
        }

    public static Integer maximum(List<Integer> list) {
        if (list.isEmpty())
            throw new IllegalStateException("maximum called on empty list");
        return (list.length() == 1) ? list.head() : Math.max(list.head(), maximum(list.tail()));
    }
*/
    public static <A> List<A> concat(List<List<A>> list) {
        return list.isEmpty() ? list() : append(list.head(), concat(list.tail()));
    }

    public static <A> List<A> concatR(List<List<A>> list) {
        return foldr(list, List.<A>list(), x -> y -> append(x, y));
    }

    public static <T, U> U foldr(List<T> ts, U identity,
                                 Function<T, Function<U, U>> f) {
        return ts.isEmpty()
                ? identity
                : f.apply(ts.head()).apply(foldr(ts.tail(), identity, f));
    }

    public static <T, U> U foldl(Function<U, Function<T, U>> f, U identity, List<T> ts) {
        return foldl_(ts, identity, f).eval();
    }

    private static <T, U> TailCall<U> foldl_(List<T> ts, U identity,
                                             Function<U, Function<T, U>> f) {
        return ts.isEmpty()
                ? ret(identity)
                : sus(() -> foldl_(ts.tail(),
                f.apply(identity).apply(ts.head()), f));
    }

    /*
    public static <A, B> B foldl(Function<B, Function<A, B>> f, B s, List<A> xs) {
        return xs.isEmpty() ? s : foldl(f, f.apply(s).apply(xs.head()), xs.tail());
    }
    */
    public <B> List<B> concatMap(Function<A, List<B>> f) {
        return foldr(h -> t -> append(f.apply(h), t), list());
    }

    public boolean elemR(A x) {
        return foldr(y -> z -> y.equals(x), false);
    }

    public boolean elemL(A x) {
        return foldr(z -> y -> y.equals(x), false);
    }

    public boolean anyR(Function<A, Boolean> p) {
        return foldr(x -> y -> p.apply(x) || y /*anyR(p)*/, false); //Fehlerhaft
    }

    public Boolean anyL(Function<A, Boolean> p, List<A> xs) {
        return foldl(x -> y -> p.apply(y) || x, false, xs);
    }

    public boolean allMitAnyL(Function<A, Boolean> p, List<A> list) {
        return list.isEmpty() || !anyL(x -> !p.apply(x), list);
    }

    public Boolean allR(Function<A, Boolean> p) {
        return foldr(x -> y -> p.apply(x) && y, true);
    }

    public Boolean allL(Function<A, Boolean> p) {
        return foldl(y -> x -> p.apply(x) && y, true);
    }

    public List<A> takeWhileR(Function<A, Boolean> p) {
        return foldr(x -> ys -> p.apply(x) ? new Cons<>(x, ys) : list(), list());
    }

    public String toStringR() {
        return foldr(this, "", x -> s -> x + ", " + s);
    }

    public static List<Integer> range(int start, int end) {
        return start > end ? list() : new Cons<Integer>(start, range(start + 1, end));
    }
/*
public static List<Integer> range(int start, int end) {
return List.unfold(start, i -> i < end
? Result.success(new Tuple<>(i, i + 1))
: Result.empty());
}
 */

    public static List<String> words(String s) {
        return s.isEmpty() ? list() : list(s.split("\\s+"));
    }


    public Integer euler1() {
        return sum(range(0, 999).filterR(x -> (((Integer) x % 3) == 0) || (((Integer) x % 5) == 0)));
    }
    /*
    public int eulerOne(int n, int acc) {
        if (n == 0) return acc;
        if (n % 3 == 0 || n % 5 == 0) {
            return eulerOne(n - 1, acc + n);
        } else {
            return eulerOne(n - 1, acc);
        }
    }*/

    /*
        public boolean equals(List<A> a) {
            return this.isEmpty() == a.isEmpty() && this.head() == a.head() && a.tail() == this.tail();
        }

        public boolean equals(Object o) {
            return instanceof(
        }
    */

    public static void main(String[] args) {
        List<Integer> list = list(69, 420);
        List<Integer> list2 = list(69, 420);
        List<Character> list3 = list('b', 'a', 'c');
        //System.out.println(list.find(x -> x==3));
        //System.out.println(euler1());
        //System.out.println(words("  Habedere oide Fischhaut    lang   nix mehr ghert  ")); // => [Habedere, oide, Fischhaut, lang, nix, mehr, ghert, NIL]
        System.out.println(minimum(list));
        System.out.println(minimum(list2));
        System.out.println(minimum(list3));
        System.out.println(maximum(list));
        System.out.println(maximum(list2));
        System.out.println(maximum(list3));
    }

}

/*
Nicht Fertig:

Instanzmethode	:	boolean elem(A x)
Instanzmethode 	:	boolean any(Function<A, Boolean> p)
Instanzmethode 	:	boolean all(Function<A, Boolean> p)
Klassenmethode  :	static <A> List<A> concat(List<List<A>> list)
Instanzmethode  : 	List<A> filter(Function<A, Boolean> f)
Instanzmethode  : 	A finde(Function<A, Boolean> f)
Instanzmethode  : 	List<A> takeWhile(Function<A, Boolean> p)
Instanzmethode  : 	boolean isEqualTo(List<A> xs)


Fertig:

Instanzmethode  : 	List<A> reverse()
Instanzmethode  : 	List<A> init()
Instanzmethode 	:	<B> List<B> map(Function<A, B> f)
Klassenmethode  :	static <A> List<A> append(List<A> list1, List<A> list2)
Klassenmethode  :	static boolean and(List<Boolean> list)
Klassenmethode  :	static boolean or(List<Boolean> list)
Klassenmethode	:	static Integer sum(List<Integer> list)
Klassenmethode	:	static Double prod(List<Double> list)
Instanzmethode	:	int length()
Klassenmethode  :	static Integer minimum(List<Integer> list)
Klassenmethode  :	static Integer maximum(List<Integer> list)
Instanzmethode  : 	List<A> dropWhile(Function<A, Boolean> p)
Instanzmethode  : 	List<A> take(int n)
Instanzmethode  : 	List<A> drop(int n)
Instanzmethode  : 	List<A> delete(A x)
Instanzmethode  : 	A last()

List<A> reverse()
<B> List<B> map(Function<A, B> f)
List<A> init()
 */