package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+90576574831",
                LocalDate.of(2000, 1, 3)
        );

        System.out.println(new CustomerValidatorService().isValid(customer));

        // Validation with combinator pattern
        ValidationResult validationResult = isEmailValid()
                .and(isAdult())
                .and(isPhoneNumberValid())
                .apply(customer);

        System.out.println(validationResult);

        // Another approach
        CustomerRegistrationValidator validator = isEmailValid()
                .and(isAdult())
                .and(isPhoneNumberValid());

        System.out.println(validator.apply(customer));
    }
}
