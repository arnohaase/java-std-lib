package primitives;

enum E { a, b, c }

public class EnumSwitch {

    static void m(E e) {
        switch(e) {
            case a:
                System.out.println("a");
                break;
            case b:
                System.out.println("b");
                break;
        }
    }
}
