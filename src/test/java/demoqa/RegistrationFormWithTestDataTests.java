package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
@Tag("demoqa")
public  class RegistrationFormWithTestDataTests {

   String firstname="Alex",
           lastname ="Egorov",
           email = "alex@erorov.com";

   String expectedFullname = format("%s %s",firstname,lastname);


   @BeforeAll
   static void setUp() {
       Configuration.baseUrl = "https://demoqa.com";
       Configuration.browserSize = "1900x1080";
   }

   @Test
   void fillFormTest() {
       step("Open registration form", () -> {
       open("/automation-practice-form");
       executeJavaScript("$('footer').remove()");
       executeJavaScript("$('#fixedban').remove()");
       });
       step("Fill registration form", () -> {
                   $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
                   $("#firstName").setValue(firstname);
                   $("#lastName").setValue(lastname);
                   $("#userEmail").setValue(email);
                   $("#genterWrapper").$(byText("Male")).click();
                   $("#userNumber").setValue("8931311123");
                   $("#dateOfBirthInput").click();
                   $(".react-datepicker__month-select").selectOption("June");
                   $(".react-datepicker__year-select").selectOption("1955");
                   $(".react-datepicker__day--013").click();
                   $("#subjectsInput").val("Math").pressEnter();
                   $("#hobbiesWrapper").$(byText("Reading")).click();
                   $("#uploadPicture").uploadFromClasspath("1.jpg");
                   $("#currentAddress").setValue("190000, Russia, Saint-Petersburg, Perfect Street, 1");
                   zoom(0.8);
                   $("#state").click();
                   $("#stateCity-wrapper").$(byText("NCR")).click();
                   $("#city").click();
                   $("#stateCity-wrapper").$(byText("Delhi")).click();

                   $("#submit").click();
               });
       step("Verify form data", () -> {
               //Asserts
       $(".table-responsive").shouldHave(
               text(expectedFullname),
               text (email),
               text("8931311123"),
               text ("Male"),
               text ("8931311123"),
               text ("13 June,1955"),
               text ("Reading"),
               text ("1.jpg"),
               text ("190000, Russia, Saint-Petersburg, Perfect Street, 1"),
               text ("NCR" +" "+ "Delhi"));
   });
}
}
