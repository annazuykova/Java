import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {
    public static int countHuman(List<Object> list) {
        int res = 0;
        for (Object o : list) {
            if (o instanceof Human) res++;
        }
        return res;
    }

    public static List<String> getPublicMethods(Object o) {
        List<String> res = new ArrayList<>();
        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            res.add(method.getName());
        }
        return res;
    }
    public static List<String> getListSuperClasses(Object o) throws ClassNotFoundException,NullPointerException {
        List<String> res = new ArrayList<>();
            String superClassName = o.getClass().getSuperclass().getName();
            res.add(superClassName);
            while (!superClassName.equals("java.lang.Object")) {
                superClassName = Class.forName(superClassName).getSuperclass().getName();
                res.add(superClassName);
            }
        return res;
    }
}
