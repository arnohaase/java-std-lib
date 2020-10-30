package collections;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestLambdas {
    @Test
    public void testLambdas() {
        List<String> names = Arrays.asList("a", "bc", "def");
        new Dumper(names).dump();
    }

    static class Dumper {
        private final List<String> names;

        int counter = 0;

        Dumper(List<String> names) {
            this.names = names;
        }

        void dump() {
            names.forEach(el -> System.out.println("element " + counter++ + " is " + el));
        }
    }

    @Test
    public void testEffectivelyFinal2() {
        List<String> names = Arrays.asList("a", "bc", "def");
        Counter counter = new Counter();
        names.forEach(el -> System.out.println("element " + counter.n++ + " is " + el));
    }

    static class Counter {
        int n = 0;
    }
}
