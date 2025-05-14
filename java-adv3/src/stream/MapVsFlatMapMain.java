package stream;

import java.util.List;
import java.util.Optional;

public class MapVsFlatMapMain {
    public static void main(String[] args) {

        System.out.println("2차원 -> 1차원 평탄화");
        List<List<Integer>> dimension2List = List.of(List.of(1, 2, 3), List.of(4, 5, 6));
        dimension2List.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("3차원 -> 2차원 평탄화");
        List<List<List<Integer>>> dimension3Lists = List.of(
                List.of(List
                        .of(1, 2, 3), List
                        .of(4, 5, 6)),
                List.of(List
                        .of(7, 8, 9), List
                        .of(10, 11, 12)),
                List.of(List
                        .of(101, 102, 103), List
                        .of(104, 105, 106)),
                List.of(List
                        .of(107, 108, 109), List
                        .of(110, 111, 112)));
        dimension3Lists.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("stream/optional 벗기기");
        Optional<User> users = Optional.of(new User(new Address("12345")));
        Address address = users.flatMap(User::getAddress).orElse(new Address("xxxxx"));
        System.out.println(address);
        // 비동기 작업에서 자주 쓰임
    }

    private static class User {
        private Address address;

        public User(Address address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    private static class Address {
        private String zipCode;

        public Address(String zipCode) {
            this.zipCode = zipCode;
        }

        public Optional<String> getZipCode() {
            return Optional.ofNullable(zipCode);
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "zipCode='" + zipCode + '\'' +
                    '}';
        }
    }


}
