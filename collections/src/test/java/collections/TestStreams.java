package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(sum, sum2);
    }

    private void max(int i) {
        if (max <i ) {
            max = i;
        }
    }


}
