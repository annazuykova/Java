import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReflectionDemo {
    public int countHuman(List<Object> list) {
        int res = 0;
        for (Object o : list) {
            if (o instanceof Human) res++;
        }
        return res;
    }
    public List<String> getPublicMethods(Object o){
        List<String> res = new ArrayList<>();

    }
}
