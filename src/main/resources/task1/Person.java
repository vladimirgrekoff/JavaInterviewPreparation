package task1;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String country;
    private final String address;
    private final String phone;
    private final int age;
    private final String gender;

    private Person(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        middleName = builder.middleName;
        country = builder.country;
        address = builder.address;
        phone = builder.phone;
        age = builder.age;
        gender = builder.gender;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Person copy) {
        Builder builder = new Builder();
        builder.firstName = copy.getFirstName();
        builder.lastName = copy.getLastName();
        builder.middleName = copy.getMiddleName();
        builder.country = copy.getCountry();
        builder.address = copy.getAddress();
        builder.phone = copy.getPhone();
        builder.age = copy.getAge();
        builder.gender = copy.getGender();
        return builder;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }


    public void printInfo() {
        System.out.println(this.toString());
    }

    public String toString() {
        return String.format("Имя: %s, отчество: %s, фамилия: %s, страна: %s, адрес: %s, телефон: %s, возраст: %d, пол: %s", firstName, middleName, lastName, country, address, phone, age, gender);
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        private Builder() {
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withMiddleName(String val) {
            middleName = val;
            return this;
        }

        public Builder withCountry(String val) {
            country = val;
            return this;
        }

        public Builder withAddress(String val) {
            address = val;
            return this;
        }

        public Builder withPhone(String val) {
            phone = val;
            return this;
        }

        public Builder withAge(int val) {
            age = val;
            return this;
        }

        public Builder withGender(String val) {
            gender = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
