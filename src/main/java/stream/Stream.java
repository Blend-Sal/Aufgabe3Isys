package stream;

import fpinjava.Effect;
import fpinjava.Function;
import fpinjava.Result;
import fpinjava.Supplier;
import inout.Input;
import tuple.Tuple;


public abstract class Stream<A> {
    private static Stream EMPTY = new Empty();

    public abstract A head();

    public abstract Stream<A> tail();

    public abstract Boolean isEmpty();

    public abstract void forEach(Effect<A> ef);

    private Stream() {
    }

    public static <A, S> Stream<A> unfold(S z,
                                          Function<S, Result<Tuple<A, S>>> f) {
        return f.apply(z).map(x -> cons(() -> x.fst,
                () -> unfold(x.snd, f))).getOrElse(EMPTY);
    }

    private static class Empty<A> extends Stream<A> {

        public static <A, S> Stream<A> unfold(S z,
                                              Function<S, Result<Tuple<A, S>>> f) {
            return EMPTY;
        }

        @Override
        public Stream<A> tail() {
            throw new IllegalStateException("tail called on empty");
        }

        @Override
        public A head() {
            throw new IllegalStateException("head called on empty");
        }

        @Override
        public Boolean isEmpty() {
            return true;
        }

        @Override
        public void forEach(Effect<A> ef) {
            //nothing
        }
    }

    private static class Cons<A> extends Stream<A> {
        private final Supplier<A> head;
        private final Supplier<Stream<A>> tail;

        private Cons(Supplier<A> h, Supplier<Stream<A>> t) {
            head = h;
            tail = t;
        }

        @Override
        public A head() {
            return head.get();
        }

        @Override
        public Stream<A> tail() {
            return tail.get();
        }

        @Override
        public Boolean isEmpty() {
            return false;
        }

        @Override
        public void forEach(Effect<A> ef) {
            ef.apply(head());
            tail().forEach(ef);
        }


        @SuppressWarnings("unchecked")
        public static <A> Stream<A> empty() {
            return EMPTY;
        }

        public static Stream<Integer> from(int i) {
            return cons(() -> i, () -> from(i + 1));
        }

        public static <A, S> Stream<A> unfold(S z,
                                              Function<S, Result<Tuple<A, S>>> f) {
            return f.apply(z).map(x -> cons(() -> x.fst,
                    () -> unfold(x.snd, f))).getOrElse(empty());
        }

    }

    static <A> Stream<A> cons(Supplier<A> hd, Supplier<Stream<A>> tl) {
        return new Cons<>(hd, tl);
    }


}

// Endrekursion = der letzte Funktionsaufruf einer rekursiven Funktion