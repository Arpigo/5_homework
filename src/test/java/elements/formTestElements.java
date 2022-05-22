package elements;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class formTestElements {

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");

    public formTestElements formRegistration() {
    open("/automation-practice-form");

    return this;
    }

    public formTestElements setFirstName(String value) {
        firstNameInput.setValue(value);

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

    public formTestElements checkResault(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }



}
