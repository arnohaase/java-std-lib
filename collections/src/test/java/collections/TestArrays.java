package collections;

import org.junit.Assert;
import org.junit.Test;

public class TestArrays {

    @Test
    public void testArrayAPI() {
        int[] intArray = {0,1,2};
        Assert.assertEquals(3, intArray.length);
        Assert.assertEquals(1, intArray[1]);
        intArray[2] = 5;
        Assert.assertEquals(5, intArray[2]);
    }
}
