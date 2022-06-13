package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class DemoWithTestData {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            currentAddress = faker.rickAndMorty().quote(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            gender = faker.demographic().sex(),
            month = registrationPage.getRandomMonth(),
            hobbies = "Sports",
            pictureName = "img.png",
            state = "Haryana",
            city = "Karnal";
    Integer day = faker.number().numberBetween(1, 30),
            year = faker.number().numberBetween(1900, 2022);

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }


    @Tag("Заполнение формы регистрации")
    @Test
    void formTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate(day, month, year.toString())
                .subjectForm()
                .setHobby(hobbies)
                .uploadPhoto(pictureName)
                .currentAddres(currentAddress)
                .setState(state)
                .setCity(city)
                .submit()
                .checkResult("Student Name", firstName)
                .checkResult("Student Name", lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", (day + " " + month + "," + year))
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictureName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}