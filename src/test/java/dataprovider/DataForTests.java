package dataprovider;

import com.github.javafaker.Faker;

import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DataForTests {

    Faker faker = new Faker(new Locale("ru"));
    public String firstName = faker.name().firstName();
    public String companyName = faker.company().name();
    public String phoneNumber = faker.phoneNumber().cellPhone();
    public String email = faker.internet().emailAddress("en");
    public String descriptionOfTheProject = "Some text";

    public DataForTests setFirstName() {
        $("#contact-form div.chakra-input__group input[type='input']").
                shouldBe(visible).
                setValue(firstName);
        return this;
    }

    public DataForTests setCompanyName() {
        $("#contact-form div.chakra-input__group input[wfd-id='id1']").
                setValue(companyName);
        return this;
    }

    public DataForTests setPhoneNumber() {
        $("#contact-form div.chakra-input__group input[wfd-id='id2']").
                setValue(phoneNumber);
        return this;

    }

    public DataForTests setEmail() {
        $("#contact-form div.chakra-input__group input[wfd-id='id3']").
                setValue(email);
        return this;
    }

    public DataForTests setDescriptionOfYourProject() {
        $("#contact-form").
                $(byText("Опишите ваш ИТ-проект*")).sibling(0).$("textarea").
                setValue(descriptionOfTheProject);
        return this;
    }


}


