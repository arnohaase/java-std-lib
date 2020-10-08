package primitives;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StringInternFootprint {
    final static Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        final List<String> strings = new ArrayList<>();

        final String baseString = "asjdklö sdjfksd fakldöfjasdklfja sdkfjads föasdj föasd jflöks fjskd fjdsaf jsdaklj asdkj dasköajslkfjklö jöklskljö lkö jadflkj lkjöafljk asdlö asdöl jlaksföjlas ljkf";

        for (int i=0; i<20_000_000; i++) {
            if (i%1_000_000 == 0) System.out.println(i);

            final String s = baseString + i%10;

//            strings.add(s);
//            strings.add(s.intern());
            strings.add(cache.computeIfAbsent(s, a -> a));
        }
    }
}
