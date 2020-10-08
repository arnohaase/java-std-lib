package primitives;

import java.math.BigDecimal;

import static java.lang.Double.*;

public class FloatDouble {
    public static void main(String[] args) {
        System.out.println(1.0 == 1.0);
        System.out.println(1.0 + 2.0 == 3.0);
        System.out.println(.5 + .5 == 1.0);
        System.out.println(.5 + .25 == .75);
        System.out.println(.1 + .2 == .3);

        final double zero = .3 - .2 -.1;
        final double n = 1e-17;
        System.out.println(n / n);
        System.out.println(n / (n + zero));

        BigDecimal punkt1 = BigDecimal.ONE.divide(BigDecimal.TEN);
        BigDecimal two = BigDecimal.valueOf(2);
        BigDecimal punkt2 = two.divide(BigDecimal.TEN);
        System.out.println(punkt1.add(punkt1).equals(punkt2));


        System.out.println(1.0 / 0.0);
//        System.out.println(1/0);

        System.out.println(NaN);
        System.out.println(POSITIVE_INFINITY * NEGATIVE_INFINITY);
        System.out.println(NEGATIVE_INFINITY * NEGATIVE_INFINITY);
    }
}
