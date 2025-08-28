import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {return age.isPresent();}

    public boolean hasAddress() {return !address.isEmpty();}

    public String getName() {return name;}

    public String getSurname() {return surname;}

    public OptionalInt getAge() {return age;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        return (getName()+" "+getSurname()+" ("+getAge().getAsInt()+" лет)");
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                //.setName(String name)
                .setSurname(this.surname)
                .setAge(this.age.getAsInt())
                .setAddress(this.address);
    }
}
