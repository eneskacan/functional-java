package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("null")
                .orElse("default  value");

        System.out.println(value);

        Optional.ofNullable("This is not null")
                .ifPresent(s -> System.out.println(s.length()));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        mail -> System.out.println("Sending email to " + mail),
                        () -> System.out.println("Cannot send an email!"));
    }
}
