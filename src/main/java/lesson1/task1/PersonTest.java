package lesson1.task1;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = Person.newBuilder()
                .withFirstName("Аристарх")
                .withMiddleName("Евлампиевич")
                .withLastName("Коровьев")
                .withCountry("Россия")
                .withAddress("Саранск, улица Свободы дом № 146")
                .withPhone("8-888-888-88-88")
                .withAge(30)
                .withGender("мужской")
                .build();

        // Проверка создания персоны
        person1.printInfo();

        // редактирование личных данных
        System.out.println("После редактирования личных данных:");
        Person.Builder personBuilder = Person.newBuilder(person1);
        personBuilder
                .withFirstName("Ипполит")
                .withMiddleName("Матвееевич")
                .withLastName("Воробьяянинов")
                .withAddress("Старгородский уезд")
                .withPhone("таксофон")
                .withAge(52);
        person1 = personBuilder.build();

        // Проверка редактирования личных данных персоны
        person1.printInfo();
    }


}
