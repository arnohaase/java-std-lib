package collections.aufgaben;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCrosswordPuzzle {

    @Test
    public void wordByLength() {
        String sentence = "Dies is ein Satz. Dieser Satz enhält Wörter. Die Wörter sind unterschiedlich lang. Wir wollen sie nach länge sortieren.";
        Map<Integer, List<String>> wordsByLength = Stream.of(sentence)
                                                         .flatMap(Pattern.compile(" |\\. ")::splitAsStream)
                                                         .map(String::trim)
                                                         .filter(s -> !s.isEmpty())
//                                                         .distinct()  // should it be distinct?
                                                         .collect(Collectors.toMap(String::length,
                                                                                   Collections::singletonList,
                                                                                   this::merge));

        Assert.assertEquals(4, wordsByLength.get(3).size());
        Assert.assertEquals(5, wordsByLength.get(6).size());
        Assert.assertEquals(1, wordsByLength.get(15).size());
        Assert.assertEquals("unterschiedlich", wordsByLength.get(15).get(0));
    }

    private List<String> merge(List<String> l1, List<String> l2) {
        return Stream.of(l1, l2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


}
