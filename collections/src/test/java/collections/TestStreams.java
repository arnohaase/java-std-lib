package collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class TestStreams {

    int max = 0;

    @Test
    public void testStreamsVsLoops_simple() {
        int sum = IntStream.range(0, 100).reduce(0, Integer::sum);

        int sum2=0;
        for (int i=0; i<100; i++) {
            sum2+=i;
        }
        Assert.assertEquals(sum, sum2);
    }

    @Test
    public void testStreamsVsLoops_calls() {
        int sum = IntStream.range(0, 100)
//                           .forEach(i -> max(i));
//        .forEach(i -> System.out.println(i));

        int maximum1 = max;

        for (int i=0; i<100; i++) {
            max(i);
        }
        int maximum2 = max;
        Assert.assertEquals(maximum1, maximum2);
    }

    private void max(int i) {
        if (max <i ) {
            max = i;
        }
    }


}
