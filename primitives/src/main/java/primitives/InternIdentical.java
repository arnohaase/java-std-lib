package primitives;


public class InternIdentical {
    static String field = "Hallo"; // auch aus anderer Klasse

    public static void main(String[] args) {
        System.out.println(field == "Hallo");
        System.out.println(field == "Hal" + "lo");
        System.out.println(field == "Hallo ".trim());
        System.out.println(field == new String("Hallo"));
    }
}
