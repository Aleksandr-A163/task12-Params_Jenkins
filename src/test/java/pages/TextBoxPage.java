package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private final SelenideElement
            userFullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit"),
            resulTable = $("#output");

    @Step("Открытие страницы")
    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    @Step("Закрытие банера")
    public TextBoxPage bannerDrop() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Ввод полного имени")
    public TextBoxPage setFullName(String userName) {
        userFullNameInput.setValue(userName);
        return this;
    }

    @Step("Ввод email")
    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввод текущего адреса")
    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    @Step("Ввод постоянного адреса")
    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    @Step("Нажатие кнопки подтверждения ввода")
    public TextBoxPage submitClick() {
        submit.click();
        return this;
    }

    @Step("Проверка результата ввода")
    public TextBoxPage checkResult(String id, String text) {
        resulTable.$(byId(id)).parent()
                .shouldHave(text(text));
        return this;
    }
}