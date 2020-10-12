package collections.aufgaben;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class TestIntToLongStream {

    @Test
    public void intToLongSimple() {
        long sum = IntStream.of(1,5,4,10,3,1000,500)
                .asLongStream()
                .sum();
        Assert.assertEquals("Sum should 1523", 1523L, sum);
    }

    @Test
    public void intToLongManual() {
        long sum = IntStream.of(1,5,4,10,3,1000,500)
                .mapToObj(Long::valueOf)
                .mapToLong(l -> l)
                .sum();
        Assert.assertEquals("Sum should 1523", 1523L, sum);
    }


}
