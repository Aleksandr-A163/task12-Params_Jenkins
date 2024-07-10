package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultFormComponent;
import pages.components.LocationComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebFormPage {

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submit = $("#submit"),
            resulModalWindow = $(".modal-content");

    CalendarComponent calendar = new CalendarComponent();
    ResultFormComponent resultPracticeForm = new ResultFormComponent();
    LocationComponent stateAndCity = new LocationComponent();

    @Step("Открытие страницы")
    public WebFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Закрытие банера")
    public WebFormPage bannerDrop() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Ввод имени")
    public WebFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Ввод фамилии")
    public WebFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввод email")
    public WebFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввод пола")
    public WebFormPage setGender(String genders) {
        genderWrapper.$(byText(genders)).click();
        return this;
    }

    @Step("Ввод мобильного телефона")
    public WebFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    @Step("Ввод даты рождения")
    public WebFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Ввод предмета")
    public WebFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Ввод хобби")
    public WebFormPage setHobby(String hobby) {
        hobbiesWrapperInput.$(byText(hobby)).click();
        return this;
    }

    @Step("Загрузка файла")
    public WebFormPage uploadFile(String file) {
        uploadFileInput.uploadFromClasspath(file);
        return this;
    }

    @Step("Ввод текущего адреса")
    public WebFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress).pressEnter();
        return this;
    }

    @Step("Ввод постоянного адреса")
    public WebFormPage setState(String state) {
        stateInput.click();
        stateAndCity.setStateOrCity(state);
        return this;
    }

    @Step("Ввод города")
    public WebFormPage setCity(String city) {
        cityInput.click();
        stateAndCity.setStateOrCity(city);
        return this;
    }

    @Step("Нажатие кнопки подтверждения ввода")
    public WebFormPage submitClick() {
        submit.click();
        return this;
    }

    @Step("Провкрка результата ввода")
    public WebFormPage checkResult(String key, String value) {
        resultPracticeForm.checkResultForm(key, value);
        return this;
    }

    @Step("Проверка невидимости формы")
    public void checkAbsenceFormResult() {
        resulModalWindow.shouldNotBe(visible);
    }
}