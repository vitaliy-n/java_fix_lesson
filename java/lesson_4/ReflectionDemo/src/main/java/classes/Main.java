package classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();
        Class a_class = Class.forName(className);
        Field[] fields = a_class.getFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//        }
//        Object inst = a_class.newInstance();
//        System.out.println(inst);
//        Constructor constructor = a_class.getDeclaredConstructor();
//        for (Class parametrType : constructor.getParameterTypes()) {
//            System.out.println(parametrType.getName());
//        }
        Class[] types = new Class[fields.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = fields[i].getType();
        }
        Constructor constructor = a_class.getDeclaredConstructor(types);

        for (Class paramType : constructor.getParameterTypes()) {
            System.out.println(paramType.getName());
        }

        Integer intValue = 0;
        String stingValue = "";
        for (int i = 0; i < types.length; i++) {
            if (types[i].getName().equals("int")) {
                intValue = scanner.nextInt();
            } if (types[i].getName().equals("java.lang.String")) {
                stingValue = scanner.next();
            }
        }
        Object[] arguments = {intValue, stingValue};
        @SuppressWarnings("JavaReflectionInvocation") Object object = constructor.newInstance(arguments);
        System.out.println(object);

    }

}
