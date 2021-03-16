package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        //$("#genterWrapper .custom-control").click();
        //$("#genterWrapper #gender-radio-1").click();
        $("#gender-radio-2").parent().click();
        //$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        //$(".react-datepicker__month-select");
        //System.out.println($("#genterWrapper").find(byText("Male")));
        sleep(4000);
        System.out.println("wow");

    }
}
