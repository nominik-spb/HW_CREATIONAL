public class PersonBuilder {

    public String name;
    public String surname;
    public int age;
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
            this.age = age;
            return this;
        }
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
        if (name != null && surname != null) {
            return new Person(this.name, this.surname, this.age, this.address);
        } else {
            throw new IllegalStateException("Не заполнены обязательные поля");
        }
    }
}
