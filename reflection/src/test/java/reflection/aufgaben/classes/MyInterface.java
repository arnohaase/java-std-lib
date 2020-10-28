package reflection.aufgaben.classes;

@Value(0)
public interface MyInterface {

    default String getName() {
        return this.getClass().getSimpleName();
    }

}
