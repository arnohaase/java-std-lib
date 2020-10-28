package collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCollection {

    @Test
    public void testCollectionTypes(){
        Collection<Integer> list = List.of(1,2,3,4,5,6,1,2,3,4,5,6);
        Collection<Integer> set = new HashSet<>(list);
        List<Integer> copyOfSet = List.copyOf(set);
        Assert.assertEquals(12, list.size());
        Assert.assertEquals(6, set.size());
        Assert.assertEquals(6, copyOfSet.size());
    }

    @Test
    public void testRandomAccess(){
        List<Integer> list = List.of(1,2,3,4,5,6,1,2,3,4,5,6);
        Assert.assertEquals(1, list.get(6).intValue());
    }

    @Test
    public void testContains() {
        Set<Integer> set = Set.of(10,20,30,40,50,60);
        Assert.assertTrue(set.contains(40));
        Assert.assertFalse(set.contains(42));
    }

    @Test
    public void testLoops(){
        List<Integer> list = List.of(1,2,3,4,5,6,1,2,3,4,5,6);
        list = new ArrayList<>(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value > 5) {
                iterator.remove();
            }
        }

        list.removeIf(v -> v < 2);

        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        Assert.assertEquals(28, sum);
    }

    @Test
    public void testRetain() {
        List<Integer> list = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9));
        list.retainAll(List.of(6,7,8,9,10,11));
        Assert.assertEquals(4, list.size());
        Assert.assertEquals(7, list.get(1).intValue());
    }

    @Test
    public void testShuffle() {
        List<Integer> list = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9));
        Collections.shuffle(list);
        List<Integer> shuffle1 = List.copyOf(list);
        Collections.shuffle(list);
        List<Integer> shuffle2 = List.copyOf(list);
        Collections.shuffle(list);

        Assert.assertNotEquals(list, shuffle1);
        Assert.assertNotEquals(shuffle1, shuffle2);
        Assert.assertNotEquals(shuffle2, list);
    }

    @Test
    public void testSort() {
        List<Integer> list = new ArrayList<Integer>(List.of(2,3,4,5,6,7,8,9,1));
        List<Integer> sortedList = List.of(1,2,3,4,5,6,7,8,9);
        Collections.sort(list);
        Assert.assertEquals(sortedList, list);
    }

    @Test
    public void testBinarySearch() {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
        int index = Collections.binarySearch(list, 5);
        Assert.assertEquals(5, list.get(index).intValue());

    }

}
