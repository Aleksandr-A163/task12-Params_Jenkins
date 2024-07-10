package utils;

import com.github.javafaker.Faker;
import java.util.concurrent.ThreadLocalRandom;

public class RandomData {
    Faker faker = new Faker();
    String[] genders = {"Male", "Female", "Other"},
    hobbies = {"Sports", "Reading", "Music"},
    subjects = {"Maths", "Art","Physics", "English", "Computer Science", "Hindi", "Commerce"},
    months = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"},
    pictures = {"1.jpeg", "2.png", "3.bmp"};

    public String firstName = faker.name().firstName(),
    lastName = faker.name().lastName(),
    email = faker.internet().emailAddress(),
    currentAddress = faker.address().streetAddress(),
    phoneNumber = faker.phoneNumber().subscriberNumber(10),
    gender = faker.options().option("Male", "Female", "Other"),
    BirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
    BirthMonth = getRandomItemFromArray(months),
    BirthYear = String.valueOf(faker.number().numberBetween(1950,2050)),
    hobby = getRandomItemFromArray(hobbies),
    subject = getRandomItemFromArray(subjects),
    state = getState(),
    city = getRandomCity(),
    picture = faker.options().option("leopard.jpg", "men.jpg");;

    public String getState() {
        state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        return state;
    }

    public String getRandomCity() {
        if (state.equals("NCR"))
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh"))
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana"))
            city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan"))
            city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}