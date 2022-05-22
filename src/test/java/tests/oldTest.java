package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class oldTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Fedor");
        $("#lastName").setValue("Emelenko");
        $("#userEmail").setValue("fedor@emelko.com");
        $(".custom-radio:nth-child(1) > .custom-control-label").click();
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
        $("#currentAddress").val("My street");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Fedor Emelenko"),text("fedor@emelko.com"),text("Male"),
                text("8800555353"),text("20 July,1994"),text("Computer Science"),text("Sports, Reading"),
                text("Fedor Emelenko"),text("My street"),text("Uttar Pradesh Lucknow"));

    }

}