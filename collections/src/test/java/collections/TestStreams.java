package collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class TestStreams {

    @Test
    public void testIntStreams() {
        Assert.assertEquals("Max is exclusive last value", 99, IntStream.range(0, 100).asLongStream().max().orElse(-1));
    }


}
