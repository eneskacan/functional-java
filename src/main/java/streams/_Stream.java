package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE, 1998),
                new Person("Maria", FEMALE, 1949),
                new Person("Aisha", FEMALE, 2012),
                new Person("Alex", MALE, 2000),
                new Person("Alice", FEMALE, 2013)
        );

        // Print genders
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // Print females
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);

        // Check if contains only females
        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);

        // Check if contains any male
        boolean containsAnyMale = people.stream()
                .anyMatch(person -> MALE.equals(person.gender));

        System.out.println(containsAnyMale);


        // Find oldest person
        people.stream()
                .min(Comparator.comparingInt(o -> o.birthYear))
                .ifPresent(System.out::println);

        // Print people from youngest to oldest
        people.stream()
                .sorted((o1, o2) -> Integer.compare(o2.birthYear, o1.birthYear))
                .forEach(System.out::println);
    }


    static class Person {
        private final String name;
        private final Gender gender;
        private final int birthYear;

        Person(String name, Gender gender, int birthYear) {
            this.name = name;
            this.gender = gender;
            this.birthYear = birthYear;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    ", birthYear=" + birthYear +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
