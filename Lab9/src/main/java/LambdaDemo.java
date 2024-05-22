import java.util.function.Function;
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
    public final static Function<String,Integer> length = String::length;
    public final static Function<String,Character> firstChar = (str)->str.charAt(0);// доделать
    public final static Function<String,Boolean> withoutGap = (str) ->str.contains(" ");
    public final static Function<String,Integer> countWords = (str)-> str.split(",").length;
    public final static Function<Human,Integer> ageHuman = (human) -> human.getAge();
    public final static
}
