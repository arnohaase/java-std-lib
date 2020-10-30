package collections.aufgaben;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class TestIntToLongStream {

    @Test
    public void intToLongSimple() {
        long sum = IntStream.of(1,5,4,10,3,1000,500)
                .asLongStream()
                .sum();
        Assertions.assertEquals(1523L, sum, "Sum should 1523");
    }

    @Test
    public void intToLongManual() {
        long sum = IntStream.of(1,5,4,10,3,1000,500)
                .mapToObj(Long::valueOf)
                .mapToLong(l -> l)
                .sum();
        Assertions.assertEquals(1523L, sum, "Sum should 1523");
    }


}
