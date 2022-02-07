package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        int multiply2 = incrementByOneAndThenMultiplyBy10Function.apply(1);
        System.out.println(multiply2);

        // BiFunction takes 1 argument and produces 1 result
        System.out.println(
                incrementByOneAndMultiply(7, 23)
        );

        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(7, 23)
        );
    }

    // Traditional way
    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

    // Functional programming
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function =
            number -> number * 10;

    // Chain usage
    static Function<Integer, Integer> incrementByOneAndThenMultiplyBy10Function =
            incrementByOneFunction.andThen(multiplyBy10Function);

    // BiFunctions
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (number, numToMultiplyBy)
                    -> (number + 1) * numToMultiplyBy;
}
