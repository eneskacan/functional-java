package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("05070000000"));
        System.out.println(isPhoneNumberValid("99070000000"));
        System.out.println(isPhoneNumberValid("050700000000"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("05070000000"));
        System.out.println(isPhoneNumberValidPredicate.test("99070000000"));
        System.out.println(isPhoneNumberValidPredicate.test("050700000000"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("05539876543")
        );
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("0553976543")
        );
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("05") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("05") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");
}
