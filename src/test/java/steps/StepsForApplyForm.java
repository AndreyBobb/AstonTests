package steps;

import dataprovider.DataForTests;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;


public class StepsForApplyForm {
    DataForTests data = new DataForTests();


    @Step("Ввод данных в форму заявки")
    public void fillApplicationForm() {
        data.setFirstName()
                .setCompanyName()
                .setPhoneNumber()
                .setEmail()
                .setDescriptionOfYourProject();
    }

    @Step("После ввода данных кнопка \"Отправить\" должна быть кликабельна")
    public void buttonSendShouldBeClickable() {
        $("#contact-form button[type='submit']").shouldBe(clickable);

    }
}
