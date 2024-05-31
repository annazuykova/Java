import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

//        1) для строки символов получить ее длину,
//        2) для строки символов получить ее первый символ, если он существует, или null иначе,
//        3) для строки проверить, что она не содержит пробелов,
//        4) слова в строке разделены запятыми, по строке получить количество слов в ней,
//        5) по человеку получить его возраст,
//        6) по двум людям проверить, что у них одинаковая фамилия,
//        7) получить фамилию, имя и отчество человека в виде одной строки (разделитель —
//        пробел),
//        8) сделать человека старше на один год (по объекту Human создать новый объект),
//        9) по трем людям и заданному возрасту maxAge проверить, что все три человека моложе
//        maxAge.

public class LambdaDemo {
    public final static Function<String, Integer> getLength = String::length;
    public final static Function<String, Character> getFirstChar = (str) -> (str.equals("") ? null : str.charAt(0));// доделать
    public final static Predicate<String> checkWithoutGap = (str) -> !str.contains(" ");
    public final static Function<String, Integer> countWords = (str) -> str.equals("") ? 0 : str.split(",").length;
    public final static Function<Human, Integer> getAgeHuman = Human::getAge;
    public final static BiPredicate<Human,Human> checkFamilia = (human1,human2) ->
            human1.getFamilia().equals(human2.getFamilia());
    public final static Function<Human, String> getFullName = (human) ->
            String.format("%s %s %s",human.getFamilia(),human.getName(),human.getOtchestvo());
    public final static UnaryOperator<Human> doOlder = (human) -> new Human(human.getFamilia(), human.getName(),
            human.getOtchestvo(), human.getAge() + 1, human.getGender());
    public final static BiPredicate<List<Human>, Integer> checkAge = (list, maxAge) ->
            list.size()==3&&(list.get(0).getAge() < maxAge) && (list.get(1).getAge() < maxAge) && (list.get(2).getAge() < maxAge);
}
