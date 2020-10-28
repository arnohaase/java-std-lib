package reflection.aufgaben.classes;

@Value(5)
public class AddingValue extends AbstractValue implements MyInterface{

    private int increment = 1;

    @Override
    protected int valueToAdd() {
        return getIncrement();
    }

    private int getIncrement() {
        return increment;
    }

}
