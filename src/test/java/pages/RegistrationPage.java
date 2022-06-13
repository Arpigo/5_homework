package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import elements.CalendarComponent;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement setMobileInput = $("#userNumber");
    SelenideElement endScreen = $("#example-modal-sizes-title-lg");
    SelenideElement birthDayInput = $("#dateOfBirthInput");
    SelenideElement  hobby = $("#hobbiesWrapper");
    SelenideElement   photoInput = $("#uploadPicture");
    SelenideElement  city = $("#city");
    SelenideElement submitButton = $("#submit");
    SelenideElement  state = $("#state");
    String  hobbyOption = "hobbies-checkbox-",
            citySelection = "react-select-4-option-";

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
    public String getRandomHobby() {
        int min = 0;
        int max = 2;
        int monthNumber = (min + (int) (Math.random() * (max - min)));
        switch (monthNumber) {
            case 0:
                return "Sport";
            case 1:
                return "Reading";
            case 2:
                return "Music";
        }
        return "Not a hobby";
    }

    public RegistrationPage hobbiesForm(String value) {
        hobby.$$("label").find(text(value)).click();
        if (value.equals("Sport")) {
            $("input[id=" + hobbyOption + "1").shouldBe(checked);
        } else if (value.equals("Reading")) {
            $("input[id=" + hobbyOption + "2").shouldBe(checked);
        } else {
            $("input[id=" + hobbyOption + "3").shouldBe(checked);
        }
        return this;
    }

    public RegistrationPage uploadPhoto(String fileName) {
        photoInput.uploadFromClasspath(fileName);
        photoInput.shouldHave(value(fileName));
        return this;
    }

    public RegistrationPage stateCity(String stateValue) {
        state.click();
        state.find(byText(stateValue)).click();
        state.shouldHave(text(stateValue));
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

    public String getRandomState() {
        int min = 0;
        int max = 3;
        int stateNumber = (min + (int) (Math.random() * (max - min)));
        switch (stateNumber) {
            case 0: {
                return "NCR";
            }
            case 1: {
                return "Uttar Pradesh";
            }
            case 2: {
                return "Haryana";
            }
            case 3: {
                return "Rajasthan";
            }
        }
        return "Unknown state";
    }

    public String setCity(String stateValue) {
        Faker faker = new Faker();
        city.click();
        Integer numberOfSelect;
        String val;
        if (stateValue.equals("NCR")) {
            numberOfSelect = faker.number().numberBetween(0, 2);
            val = city.find(byId(citySelection + numberOfSelect)).getText();
            city.find(byId(citySelection + numberOfSelect)).click();
        } else if (stateValue.equals("Uttar Pradesh")) {
            numberOfSelect = faker.number().numberBetween(0, 2);
            val = city.find(byId(citySelection + numberOfSelect)).getText();
            city.find(byId(citySelection + numberOfSelect)).click();
        } else if (stateValue.equals("Haryana")) {
            numberOfSelect = faker.number().numberBetween(0, 1);
            val = city.find(byId(citySelection + numberOfSelect)).getText();
            city.find(byId(citySelection + numberOfSelect)).click();
        } else if (stateValue.equals("Rajasthan")) {
            numberOfSelect = faker.number().numberBetween(0, 1);
            val = city.find(byId(citySelection + numberOfSelect)).getText();
            city.find(byId(citySelection + numberOfSelect)).click();
        } else {
            val = "We have a trouble";
        }
        return val;
    }

    public RegistrationPage submit() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

}
