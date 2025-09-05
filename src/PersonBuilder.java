import java.util.OptionalInt;

public class PersonBuilder {

    public String name;
    public String surname;
    public OptionalInt age = OptionalInt.empty();
    public String address;

    public PersonBuilder setName(String name) {
        try {
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        try {
            this.surname = surname;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Неверное значение поля Возраст");
        } else {
            this.age = OptionalInt.of(age);
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        try {
            this.address = address;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return this;
    }

    public Person build() {
        if (this.name != null && this.surname != null) {
            if (this.age.isEmpty()) {
                return new Person(this.name, this.surname, this.address);
            } else {
                return new Person(this.name, this.surname, age.getAsInt(), this.address);
            }
        } else {
            throw new IllegalStateException("Не заполнены обязательные поля");
        }
    }
}
