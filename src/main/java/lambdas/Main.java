package lambdas;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<String, String> upperCaseName = name -> name.toUpperCase();
        Function<String, String> upperCaseName2 = String::toUpperCase;

        Function<String, String> lowerCaseName = name -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        upperCaseName.apply("Enes");
        upperCaseName2.apply("Emre");
        lowerCaseName.apply("Not null");
    }
}
