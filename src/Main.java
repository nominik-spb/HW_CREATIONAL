public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

//        ===== ПРОВЕРКА ОБЪЕКТА =====
//        System.out.println(mom + " " + mom.getSurname() + " (" + mom.getAge() + " лет," + mom.getAddress() + ")");
//        mom.happyBirthday();
//        mom.setAddress("Токио");
//        System.out.println(mom + " " + mom.getSurname() + " (" + mom.getAge() + " лет," + mom.getAddress() + ")");
//        System.out.println(mom.hasAge());
//        System.out.println(mom.hasAddress());

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                //.setAge(5)
                .build();


//        ===== ПРОВЕРКА ДОЧЕРНЕГО ОБЪЕКТА =====
//        System.out.println(son + " " + son.getSurname() + " (" + son.getAge() + " лет," + son.getAddress() + ")");
//        son.happyBirthday();
//        System.out.println(son + " " + son.getSurname() + " (" + son.getAge() + " лет," + son.getAddress() + ")");


        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}