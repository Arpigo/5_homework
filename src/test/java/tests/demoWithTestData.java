package tests;

import baseSetUp.configForBrowser;
import com.github.javafaker.Faker;
import elements.formTestElements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class demoWithTestData {
    formTestElements formTestElements = new formTestElements();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            currentAddress = faker.rickAndMorty().quote();

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
                .setGender("Other");

        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--020").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").val("m");
        $("#subjectsInput").sendKeys(Keys.DOWN);
        $("#subjectsInput").sendKeys(Keys.DOWN);
        $("#subjectsInput").sendKeys(Keys.ENTER);
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();
        $("#uploadPicture").uploadFromClasspath("image/img.jpg");
        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));



        //        $(".table-responsive").shouldHave(text(firstName + " " + lastName),text(email),
//                text(firstName + " " + lastName),text(currentAddress);

    }

}