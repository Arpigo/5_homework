package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.CalendarComponent;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class formTestElements {
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement setMobileInput = $("#userNumber");
    SelenideElement endScreen = $("#example-modal-sizes-title-lg");

    public formTestElements formRegistration() {
    open("/automation-practice-form");

    return this;
    }

    public formTestElements subjectForm() {
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").val("m");
        $("#subjectsInput").sendKeys(Keys.DOWN);
        $("#subjectsInput").sendKeys(Keys.DOWN);
        $("#subjectsInput").sendKeys(Keys.ENTER);

        return this;
    }

    public formTestElements hobbiesForm() {
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();

        return this;
    }

    public formTestElements uploadPhoto() {
        $("#uploadPicture").uploadFromClasspath("image/img.jpg");

        return this;
    }

    public formTestElements stateCity() {
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        return this;
    }


    public formTestElements currentAddres(String value) {
        $("#currentAddress").val(value);

        return this;
    }

    public formTestElements setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public formTestElements setMobile(String value) {
        setMobileInput.setValue(value);

        return this;
    }

    public formTestElements setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public formTestElements setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public formTestElements setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public formTestElements setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }


    public formTestElements submit() {
        $("#submit").click();

        return this;
    }

    public formTestElements checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

}
