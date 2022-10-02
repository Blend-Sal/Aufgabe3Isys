package list;

import fpinjava.Function;
import fpinjava.Result;
import inout.ScriptReader;

import java.util.Set;


public abstract class List<A> {

    // abstract Methods
    public abstract A head();

    public abstract List<A> tail();

    public abstract boolean isEmpty();

    public abstract List<A> setHead(A head);

    public abstract List<A> cons(A a);

    public abstract int length();

    public abstract boolean elem(A x);

    public abstract boolean any(Function<A, Boolean> p);

    public abstract boolean all(Function<A, Boolean> f);

    public abstract <B> List<B> map(Function<A, B> f);

    public abstract List<A> filter(Function<A, Boolean> f);

    public abstract List<A> init();

    public abstract A last();

    public abstract List<A> take(int n);

    public abstract List<A> drop(int n);

    public abstract List<A> delete(A x);

    public abstract List<A> takeWhile(Function<A, Boolean> p);

    public abstract List<A> dropWhile(Function<A, Boolean> p);

    public abstract A finde(Function<A, Boolean> f);

    public abstract boolean isEqualTo(List<A> list);

    public abstract boolean equals(Object o);

    public abstract Set<A> toSet();

    public abstract List<A> nub();

    public abstract Result<A> headOption();

    public abstract Result<A> find(Function<A,Boolean> p);

    // 1.2
    // StringBuilder ist mutable, d.h. man kann den Text Content eines Objects,
    // auch wenn dies im Speicher ist, ändern.
    // aber String kann das nicht.

    public static Integer sum(List<Integer> list) {
        return list.isEmpty() ? 0 : list.head() + sum(list.tail());
    }

    public static Double prod(List<Double> list) {
        return list.isEmpty() ? 1 : list.head() * prod(list.tail());
    }

    public static <A> List<A> reverse(List<A> list) {
        return list.isEmpty() ? list() : append(reverse(list.tail()), list(list.head()));
    }

    public static boolean and(List<Boolean> list) {
        return list.isEmpty() ? true : list.head() && and(list.tail());
    }

    public static boolean or(List<Boolean> list) {
        return list.isEmpty() ? false : list.head() || or(list.tail());
    }

    public static Integer minimum(List<Integer> list) {
        if (list.isEmpty())
            throw new IllegalStateException("min of empty list");
        else if (list.length() == 1)
            return list.head();
        else
            return Math.min(list.head(), minimum(list.tail()));
    }

    public static Integer maximum(List<Integer> list) {
        if (list.isEmpty())
            throw new IllegalStateException("max of empty list");
        else if (list.length() == 1)
            return list.head();
        else
            return Math.max(list.head(), maximum(list.tail()));
    }

    public static <A> List<A> append(List<A> list1, List<A> list2) {
        return list1.isEmpty() ? list2 : new Cons<>(list1.head(), append(list1.tail(), list2));
    }

    public static <A> List<A> concat(List<List<A>> list) {
        return list.isEmpty() ? list() : append(list.head(), concat(list.tail()));
    }

    // Rigth fold

    public abstract <B> B foldr(Function<A, Function<B, B>> f, B s);

    public static <A, B> B foldr(Function<A, Function<B, B>> f, B s, List<A> xs) {
        return xs.isEmpty() ? s : f.apply(xs.head()).apply(foldr(f, s, xs.tail()));
    }

    public static Integer sumFoldr(List<Integer> list) {
        return foldr(x -> y -> x + y, 0, list);
    }

    public static Integer prodFoldr(List<Integer> list) {
        return foldr(x -> y -> x * y, 1, list);
    }

    public static <A> Integer lengthFoldr(List<A> list) {
        return foldr(m -> n -> 1 + n, 0, list);
    }

    public static <A> boolean elemFoldr(A y, List<A> list) {
        return foldr(x -> z -> x.equals(y) || z, false, list);
    }

    public static <A> boolean anyFoldr(Function<A, Boolean> p, List<A> list) {
        return foldr(x -> y -> p.apply(x) || y, false, list);
    }

    public static <A> boolean allFoldr(Function<A, Boolean> p, List<A> list) {
        return foldr(x -> y -> p.apply(x) && y, true, list);
    }

    public static boolean andFoldr(List<Boolean> list) {
        return foldr(x -> y -> x && y, true, list);
    }

    public static boolean orFoldr(List<Boolean> list) {
        return foldr(x -> y -> x || y, false, list);
    }

    public static <A> List<A> appendFoldr(List<A> list1, List<A> list2) {
        return foldr(x -> xs -> new Cons<>(x, xs), list1, list2);
    }

    public static <A> List<A> concatFoldr(List<List<A>> list) {
        return foldr(xs -> ys -> append(xs, ys), list(), list);
    }

    public static <A, B> List<B> mapFoldr(Function<A, B> f, List<A> list) {
        return foldr(x -> xs -> new Cons<>(f.apply(x), xs), list(), list);
    }

    public static <A> List<A> filterFoldr(Function<A, Boolean> p, List<A> list) {
        return foldr(x -> xs -> p.apply(x) ? new Cons<>(x, xs) : xs, list(), list);
    }

    public static <A> List<A> takeWhileFoldr(Function<A, Boolean> p, List<A> list) {
        return foldr(x -> xs -> p.apply(x) ? new Cons<>(x, xs) : list(), list(), list);
    }

    public static <A> String toStringFoldr(List<A> list) {
        return foldr(x -> xs -> x + ", " + xs, list().toString(), list);
    }

    public static <A> List<A> reverseFoldr(List<A> list) {
        return foldr(x -> xs -> append(xs, list(x)), list(), list);
    }

    // left fold
    public abstract <B> B foldl(Function<B, Function<A, B>> f, B s);

    public static <A, B> B foldl(Function<B, Function<A, B>> f, B s, List<A> xs) {
        return xs.isEmpty() ? s : foldl(f, f.apply(s).apply(xs.head()), xs.tail());
    }

    public static <A> List<A> reverseFoldl(List<A> list) {
        return foldl(xs -> x -> append(list(x), xs), list(), list);
    }

    public static Integer sumFoldl(List<Integer> list) {
        return foldl(x -> y -> x + y, 0, list);
    }

    public static Integer prodFoldl(List<Integer> list) {
        return foldl(x -> y -> x * y, 1, list);
    }

    public static <A> Integer lengthFoldl(List<A> list) {
        return foldl(n -> m -> 1 + n, 0, list);
    }

    public static <A> Boolean elemFoldl(A y, List<A> list) {
        return foldl(z -> x -> x.equals(y) || z, false, list);
    }

    public static <A> Boolean andFoldl(List<Boolean> list) {
        return foldl(x -> y -> x && y, true, list);
    }

    public static <A> Boolean orFoldl(List<Boolean> list) {
        return foldl(x -> y -> x || y, false, list);
    }

    public static <A, B> Boolean anyFoldl(Function<A, Boolean> p, List<A> list) {
        return foldl(x -> y -> p.apply(y) || x, false, list);
    }

    public static <A, B> Boolean allFoldl(Function<A, Boolean> p, List<A> list) {
        return foldl(x -> y -> p.apply(y) && x, true, list);
    }

    public static <A> A lastFoldl(List<A> list) {
        return foldl(x -> y -> y, null, list);
    }

    // all with any
    public static <A> Boolean allWithAny(Function<A, Boolean> p, List<A> list) {
        return !anyFoldl(x -> !p.apply(x), list);
    }

    // elem with
    public static <A> Boolean elemWithAny(A z, List<A> list) {
        return anyFoldl(x -> x.equals(z), list);
    }

    // flatMap
    public static <A, B> List<B> flatMap(Function<A, List<B>> f, List<A> list) {
        return foldr(xs -> ys -> append(f.apply(xs), ys), list(), list);
    }

    public static List<Integer> range(int start, int end) {
        return start > end ? list() : new Cons<>(start, range(start + 1, end));
    }

    public static List<String> words(String s) {
        return list(s.split("\\s+"));
    }

    // Euler 1
    public static Integer euler1() {
        List<Integer> list = range(1, 1000);
        return sum(list.filter(n -> n % 3 == 0 || n % 5 == 0 && n < 1000));
    }





    // 1.4-d
    // -foldl ist tail-rekursiv, d.h. dass das Endergebnis des rekursiven Aufrufs
    // dem Endergebnis der Funktion selbst entspricht
    // und mit dem kann man stack overflow vermeiden,

    @SuppressWarnings("rawtypes")
    public static final List NIL = new Nil();

    private List() {
    }

    // the subclass Nil of superclass List
    private static class Nil<A> extends List<A> {
        private Nil() {
        }

        public int length() {
            return 0;
        }

        public A head() {
            throw new IllegalStateException("head called on empty list");
        }

        public List<A> tail() {
            throw new IllegalStateException("tail called on empty list");
        }

        public boolean isEmpty() {
            return true;
        }

        public List<A> setHead(A head) {
            throw new IllegalStateException("setting a head on empty list");
        }

        public List<A> cons(A a) {
            return new Cons<>(a, this);
        }

        public boolean elem(A x) {
            return false;

        }

        public boolean any(Function<A, Boolean> p) {

            return false;
        }

        public boolean all(Function<A, Boolean> p) {
            return true;
        }

        public <B> List<B> map(Function<A, B> f) {
            return list();
        }

        public List<A> filter(Function<A, Boolean> f) {
            return list();
        }

        public List<A> init() {
            throw new IllegalStateException("init of empty list is undefined");
        }

        public A last() {
            throw new IllegalStateException("last called on empty list");
        }

        public List<A> take(int n) {
            return list();
        }

        public List<A> drop(int n) {
            return list();
        }

        public List<A> takeWhile(Function<A, Boolean> p) {
            return list();
        }

        public List<A> dropWhile(Function<A, Boolean> p) {
            return list();
        }

        public List<A> delete(A x) {
            return list();
        }

        public String toString() {
            return "[]";
        }

        public A finde(Function<A, Boolean> f) {
            return null;
        }

        public boolean isEqualTo(List<A> list) {
            return list.isEmpty();
        }

        public <B> B foldr(Function<A, Function<B, B>> f, B s) {
            return s;
        }

        public <B> B foldl(Function<B, Function<A, B>> f, B s) {
            return s;
        }

        @SuppressWarnings({ "rawtypes" })
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (o == null || o.getClass() != this.getClass()) {
                return false;
            } else {
                List l = (Nil) o;
                return this.isEqualTo(l);
            }
        }

        @Override
        public Set<A> toSet() {
            return null;
        }


        @Override
        public List<A> nub() {
            return list();
        }

        @Override
        public Result<A> headOption() {
            return Result.empty();
        }

        @Override
        public Result<A> find(Function<A, Boolean> p) {
            return Result.empty();
        }

    }

    // the subclass Cons of superclass List
    private static class Cons<A> extends List<A> {
        private final A head;
        private final List<A> tail;

        private Cons(A h, List<A> t) {
            head = h;
            tail = t;
        }

        public A head() {
            return head;
        }

        public List<A> tail() {
            return tail;
        }

        public boolean isEmpty() {
            return false;
        }

        public List<A> setHead(A head) {

            return new Cons<>(head, tail());
        }

        public List<A> cons(A a) {
            return new Cons<>(a, this);
        }

        public int length() {
            return 1 + tail().length();
        }

        public boolean elem(A x) {

            return head().equals(x) || tail().elem(x);
        }

        public String toString() {
            String res = "";
            StringBuilder sb = new StringBuilder();
            res = sb.append(head()).append(", ").append(tail()).toString();
            return res;
        }

        public boolean any(Function<A, Boolean> p) {

            return p.apply(head()) || tail().any(p);
        }

        public boolean all(Function<A, Boolean> p) {
            return p.apply(head()) && tail().all(p);
        }

        public <B> List<B> map(Function<A, B> f) {
            return new Cons<>(f.apply(head()), tail.map(f));
        }

        public List<A> filter(Function<A, Boolean> f) {
            return f.apply(head()) ? new Cons<>(head(), tail().filter(f)) : tail().filter(f);
        }

        public List<A> init() {
            return length() == 1 ? list() : new Cons<>(head(), tail().init());
        }

        public A last() {
            return length() == 1 ? head() : tail().last();
        }

        public List<A> take(int n) {
            return n <= 0 ? list() : new Cons<>(head(), tail().take(n - 1));
        }

        public List<A> drop(int n) {
            return n <= 0 ? new Cons<>(head(), tail()) : tail().drop(n - 1);
        }

        public List<A> takeWhile(Function<A, Boolean> p) {
            return p.apply(head()) ? new Cons<>(head(), tail().takeWhile(p)) : list();
        }

        public List<A> delete(A x) {
            return head().equals(x) ? tail() : new Cons<>(head(), tail().delete(x));
        }

        public List<A> dropWhile(Function<A, Boolean> p) {
            return p.apply(head()) ? tail().dropWhile(p) : new Cons<>(head(), tail());
        }

        public A finde(Function<A, Boolean> f) {
            return f.apply(head()) ? head() : tail().finde(f);
        }

        public boolean isEqualTo(List<A> list) {
            return !list.isEmpty() ? list.head().equals(head()) && tail().isEqualTo(list.tail()) : false;
        }

        public <B> B foldr(Function<A, Function<B, B>> f, B s) {
            return f.apply(head()).apply(foldr(f, s));

        }

        public <B> B foldl(Function<B, Function<A, B>> f, B s) {
            return foldl(f, f.apply(s).apply(head()));
        }

        @SuppressWarnings({ "rawtypes" })
        @Override
        public boolean equals(Object o) {

            if (o == this) {
                return true;
            } else if (o == null || o.getClass() != this.getClass()) {
                return false;
            } else {
                List l = (Cons) o;

                return this.isEqualTo(l);
            }
        }

        @Override
        public Set<A> toSet() {
            return null;
        }

        @Override
        public List<A> nub() {
            return null;
        }


        private ScriptReader fromList(Cons<A> aCons) {
            return null;
        }

        @Override
        public Result<A> headOption() {
            return Result.success(head);
        }

        @Override
        public Result<A> find(Function<A, Boolean> p) {
            return Result.success(this.finde(p));
        }

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

    public static void main(String[] args) {
        List<Integer> l1 = list(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> l2 = list(1, 2, 3);
        List<Boolean> l3 = list(true, true, true, false);
        System.out.println(flatMap(x -> list(x + "^_^" + x, x + "-_-" + x), l2));
        System.out.println(anyFoldl(n -> n == 4, l2));
        System.out.println(l2.dropWhile(n -> n % 2 != 0));
        System.out.println(append(l1.take(3), l1.drop(3)));
        System.out.println(and(l3) + " " + or(l3));
        System.out.println(l2.takeWhile(n -> n == 2));
        System.out.println(l1.find(n-> n%2==0));
    }

}
