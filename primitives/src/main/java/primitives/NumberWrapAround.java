package primitives;

public class NumberWrapAround {
    public static void main(String[] args) {
        int i = 0;

        while(true) {
            int prev = i;
            i += 1;

            if (prev > i) {
                System.out.println(prev + " -> " + i);
                break;
            }
        }

        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(100 << 2));
        System.out.println(Integer.toBinaryString(100 >> 2));
        System.out.println(Integer.toBinaryString(100 >>> 2));

        System.out.println(Integer.toBinaryString(-100) + " == " + -100);
        System.out.println(Integer.toBinaryString(-100 >> 2) + " == " + (-100 >> 2));
        System.out.println(Integer.toBinaryString(-100 >>> 2) + " == " + (-100 >>> 2));
    }
}
