package primitives;

import java.util.BitSet;

public class BitMask {
    public static final int MASK_UNEVEN = 1;
    public static final int MASK_WHAT = 4;
    public static final int MASK_EVER = 0x200;

    public static void main(String[] args) {
        int i = MASK_UNEVEN | MASK_EVER;
        a(i);

        BitSet bs = new BitSet();
        bs.set(0);
        bs.set(3);
        bs.set(25);
        bs.set(395);

        System.out.println("0: " + bs.get(0));
        System.out.println("4: " + bs.get(4));
        System.out.println("25: " + bs.get(25));
    }

    static void a(int i) {
        System.out.println("uneven: " + ((i & MASK_UNEVEN) != 0));
        System.out.println("what: " + ((i & MASK_WHAT) != 0));
        System.out.println("ever: " + ((i & MASK_EVER) != 0));

    }
}
