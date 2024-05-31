import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaRunner {
    public static <T, R> R runFunction(Function<T, R> expr, T param) {
        return expr.apply(param);
    }

    public static <T> boolean runPredicate(Predicate<T> expr, T param) {
        return expr.test(param);
    }

    public static <T> T runUnaryOperator(UnaryOperator<T> expr, T param) {
        return expr.apply(param);
    }

    public static <T, R> boolean runBiPredicate(BiPredicate<T, R> expr, T param1, R param2) {
        return expr.test(param1, param2);
    }
}
