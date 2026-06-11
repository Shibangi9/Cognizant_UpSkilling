import java.lang.reflect.Method;

class Calculator {

    public void greet() {
        System.out.println("Hello from Reflection");
    }
}

public class ReflectionExample {

    public static void main(String[] args) throws Exception {

        Class<?> cls =
                Class.forName("Calculator");

        System.out.println("Methods:");

        for (Method m : cls.getDeclaredMethods()) {

            System.out.println(
                    m.getName()
                    + " Parameter Count: "
                    + m.getParameterCount());
        }

        Object obj =
                cls.getDeclaredConstructor()
                        .newInstance();

        Method method =
                cls.getDeclaredMethod("greet");

        method.invoke(obj);
    }
}