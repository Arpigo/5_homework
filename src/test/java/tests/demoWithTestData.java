package tests;

import baseSetUp.configForBrowser;
import com.github.javafaker.Faker;
import elements.formTestElements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class demoWithTestData {
    formTestElements formTestElements = new formTestElements();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            currentAddress = faker.rickAndMorty().quote(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            gender = faker.demographic().sex();

    @BeforeAll
    static void setUp(){
        new configForBrowser().setUp();
    }

    @Tag("Заполнение формы регистрации")
    @Test
    void formTest() {
        formTestElements.formRegistration()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate("20", "July", "1991")
                .subjectForm()
                .hobbiesForm()
                .uploadPhoto()
                .currentAddres(currentAddress)
                .stateCity()
                .submit()
                .checkResult("Student Name", firstName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Address", currentAddress);
    }

}