package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;

    }

    @Test
    void successfulFillTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ana");
        $("#lastName").setValue("Yyy");
        $("#userEmail").setValue("Yyy@aaa.ru");
        $(byText("Male")).click();
        $(byText("Female")).click();
        $(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1910");
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("M").pressEnter();
        $("#subjectsInput").setValue("s").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        File file = new File("src/test/resourses/readme.txt");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Street N");
        String state = "NCR";
        $("#state").click();
        $(byText(state)).click();
        String city = "Delhi";
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(".modal-content").shouldBe(Condition.visible).shouldHave(text("Ana"), text("Yyy"), text("Yyy@aaa.ru"), text("Other"), text("1234567890"), text("03 January,1910"), text("Maths, English"), text("Sports, Reading, Music"), text("readme.txt"), text("Street N"), text("NCR Delhi"));

    }
}
