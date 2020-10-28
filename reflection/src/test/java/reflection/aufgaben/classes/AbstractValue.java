package reflection.aufgaben.classes;

public abstract class AbstractValue implements ValueInterface {

    @Override
    public int increment(int value) {
        return value + valueToAdd();
    }

    protected abstract int valueToAdd();

}
