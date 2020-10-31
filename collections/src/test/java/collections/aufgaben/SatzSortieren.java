package collections.aufgaben;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SatzSortieren {

    @Test
    public void testSortLength() {
        String satz = "Dies ist ein Satz mit längeren und kurzen Wörtern";
        List<String> sorted = new ArrayList<>(Arrays.asList(satz.split(" ")));
        sorted.sort(Comparator.comparingInt(String::length));
        for (String wort : sorted) {
            System.out.println(wort);
        }
    }

    @Test
    public void testSortLengthSet() {
        String satz = "Dies ist ein Satz mit längeren und kurzen Wörtern";
        Set<String> sorted = new TreeSet<>(Comparator.comparingInt(String::length));
        sorted.addAll(Arrays.asList(satz.split(" ")));
        for (String wort : sorted) {
            System.out.println(wort);
        }
    }

}
