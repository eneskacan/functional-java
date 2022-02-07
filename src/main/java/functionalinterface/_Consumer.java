package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "5521234534");

        greetCustomer(maria);
        greetCustomerConsumer.accept(maria);

        greetCustomerConsumerV2.accept(maria, false);
        greetCustomerV2(maria, false);
    }

    // Normal Java Function
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.name +
                ", thanks for registering phone number " +
                customer.phoneNumber + "!");
    }

    static void greetCustomerV2(Customer customer, Boolean showPhoneNumber) {
        System.out.println("Hello " + customer.name +
                ", thanks for registering phone number " +
                (showPhoneNumber ? customer.phoneNumber : "*****") + "!");
    }

    // Consumer Functional Interface
    static Consumer<Customer> greetCustomerConsumer =
            customer -> System.out.println("Hello " + customer.name +
                    ", thanks for registering phone number " +
                    customer.phoneNumber + "!");

    // BiConsumer
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 =
            (customer, showPhoneNumber) -> System.out.println("Hello " + customer.name +
                    ", thanks for registering phone number " +
                    (showPhoneNumber ? customer.phoneNumber : "*****") + "!");

    static class Customer {
        private final String name;
        private final String phoneNumber;

        Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }
}
