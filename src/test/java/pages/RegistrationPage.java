package pages;

import com.codeborne.selenide.SelenideElement;
import elements.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement setMobileInput = $("#userNumber");
    SelenideElement birthDayInput = $("#dateOfBirthInput");
    SelenideElement uploadPhoto = $("#uploadPicture");
    SelenideElement state = $("#state");
    SelenideElement city = $("#city");
    SelenideElement  inputHobby = $("#hobbiesWrapper");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage subjectForm() {
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").val("n");
        $(byText("Hindi")).click();


        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        inputHobby.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage uploadPhoto(String Image) {
        uploadPhoto.uploadFromClasspath("Image/" + Image);
        return this;
    }


    public RegistrationPage currentAddres(String value) {
        $("#currentAddress").val(value);

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setMobile(String value) {
        setMobileInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public String getRandomMonth() {
        int min = 0;
        int max = 11;
        int monthNumber = (min + (int) (Math.random() * (max - min)));
        switch (monthNumber) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
        }
        return "Not a month";
    }

    public RegistrationPage setBirthDate(Integer day, String month, String year) {
        birthDayInput.click();
        calendar.setDate(day, month, year);
        birthDayInput.shouldHave(
                value(day.toString()),
                value(month.substring(0, 3)),
                value(year));
        return this;
    }

    public RegistrationPage submit() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        $(byText(value)).scrollTo().click();

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        $(byText(value)).scrollTo().click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
