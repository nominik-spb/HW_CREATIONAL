public class PersonBuilder {

    public String name;
    public String surname;
    public int age;
    public String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age<0) {
            throw new IllegalStateException("Неверное значение поля Возраст");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name != null && surname != null) {
//            if (age<0) {
//                throw new IllegalStateException("Неверное значение поля Возраст");
//            }
            return new Person(this.name, this.surname, this.age);
        }  else {
            throw new IllegalStateException("Не заполнены обязательные поля");
        }
    }
}
