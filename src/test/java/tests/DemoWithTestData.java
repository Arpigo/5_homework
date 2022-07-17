package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import helpers.Attach;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;


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


        //Это для добавления видео
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttach() {
        Attach.screenshotAs("Last ScreenShot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Tag("demoqa")
    @DisplayName("Заполнение формы")
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
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}