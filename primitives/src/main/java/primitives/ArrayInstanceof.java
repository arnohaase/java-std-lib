package primitives;

public class ArrayInstanceof {
    public static void main(String[] args) {
        final Object strings = new String[3];
        final Object integers = new Integer[3];

        System.out.println(strings instanceof Object[]);
        System.out.println(integers instanceof Number[]);

        Object[] objects = (Object[]) strings;
        objects[0] = 123;

    }
}
