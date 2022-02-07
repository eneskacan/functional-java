package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+90576574831",
                LocalDate.of(2000, 1, 3)
        );

        System.out.println(new CustomerValidatorService().isValid(customer));
    }
}
