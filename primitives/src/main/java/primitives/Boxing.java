package primitives;

import java.util.Objects;

public class Boxing {
    public static void main(String[] args) {
        int i = 5;
        long l = 5;

        System.out.println(i == l);

        Long ll = l;
        System.out.println(i == ll);
        System.out.println(Objects.equals(i, ll));
        System.out.println(Objects.equals(i, l));

        Integer ii = null;
        Integer jj = null;
        System.out.println(plus (ii, jj));

        ternary(null, 1L);
    }

    static int plus(int i, int j) {
        return i+j;
    }

    static Number ternary(Integer i, Long j) {
        return i != null ? i : j;
    }
}
