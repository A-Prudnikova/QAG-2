package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;

    }

    @Test
    void successfulFillTest() {
        String name = "Ana";
        String surname = "Yyy";
        String email = "Yyy@aaa.ru";
        String phone = "1234567890";
        String subject = "English";
        String address = "Street N build.123";
        String state = "NCR";
        String city = "Delhi";
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $(byText("Female")).click();
        $(byText("Other")).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1910");
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("ava.jpg");
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        $(".modal-content").shouldBe(visible).shouldHave(
                text(name),
                text(surname),
                text(email),
                text("Other"),
                text(phone),
                text("03 January,1910"),
                text(subject),
                text("Sports, Reading, Music"),
                text("ava.jpg"),
                text(address),
                text(state),
                text(city)
        );
    }
}
