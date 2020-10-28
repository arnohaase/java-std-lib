package reflection.aufgaben;

import org.junit.Assert;
import org.junit.Test;
import reflection.aufgaben.classes.AbstractValue;
import reflection.aufgaben.classes.AddingValue;
import reflection.aufgaben.classes.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassWalker {

    @Test
    public void implementedMethods() {
        Set<String> methodNames = Arrays.stream(AddingValue.class.getDeclaredMethods()).map(Method::getName).collect(Collectors.toSet());
        check(methodNames, "valueToAdd", "getIncrement");
    }

    @Test
    public void publicMethods() {
        Set<String> methodNames = Arrays.stream(AddingValue.class.getMethods()).map(Method::getName).collect(Collectors.toSet());
        check(methodNames, "increment", "getName", "getClass", "hashCode", "equals", "toString", "notify", "notifyAll", "wait");
    }

    @Test
    public void callingPublicMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method increment = AddingValue.class.getMethod("increment", int.class);
        Assert.assertEquals(6, increment.invoke(new AddingValue(), 5));
    }

    @Test
    public void callingProtectedMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method valueToAdd = AbstractValue.class.getDeclaredMethod("valueToAdd");
        valueToAdd.setAccessible(true);
        Assert.assertEquals(1, valueToAdd.invoke(new AddingValue()));
    }

    @Test
    public void fields() {
        Set<String> methodNames = Arrays.stream(AddingValue.class.getFields()).map(Field::getName).collect(Collectors.toSet());
        check(methodNames);
    }

    @Test
    public void fields_declared() throws NoSuchFieldException, IllegalAccessException {
        Set<String> methodNames = Arrays.stream(AddingValue.class.getDeclaredFields()).map(Field::getName).collect(Collectors.toSet());
        check(methodNames, "increment");

        Field increment = AddingValue.class.getDeclaredField("increment");
        increment.setAccessible(true);
        Assert.assertEquals(1, increment.get(new AddingValue()));
    }

    @Test
    public void interfaces() {
        Set<String> classNames = Arrays.stream(AddingValue.class.getInterfaces()).map(Class::getSimpleName).collect(Collectors.toSet());
        check(classNames, "MyInterface");
    }

    @Test
    public void superClass() {
        Set<String> classNames = Collections.singleton(AddingValue.class.getSuperclass().getSimpleName());
        check(classNames, "AbstractValue");
    }

    @Test
    public void annotations_declared() {
        Set<String> classNames = Arrays.stream(AddingValue.class.getDeclaredAnnotations()).map(Annotation::annotationType).map(Class::getSimpleName).collect(Collectors.toSet());
        check(classNames, "Value");
    }

    @Test
    public void annotations() {
        Set<String> classNames = Arrays.stream(AddingValue.class.getAnnotations()).map(Annotation::annotationType).map(Class::getSimpleName).collect(Collectors.toSet());
        check(classNames, "Value");

        Value v = (Value) AddingValue.class.getAnnotations()[0];
        Assert.assertEquals(5, v.value());
    }

    private void check(Set<String> methodNames, String... expectedMethods) {
        Assert.assertEquals(expectedMethods.length, methodNames.size());
        List<String> expected = Arrays.asList(expectedMethods);
        for (String expectedName : expectedMethods) {
            Assert.assertTrue("Did not contain "+expectedName, methodNames.contains(expectedName));
        }
    }

}
