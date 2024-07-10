package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import utils.RandomData;
import org.junit.jupiter.api.Test;
import pages.WebFormPage;


@Tag("form")
@DisplayName("Тесты для большой формы")
public class WebFormTest extends WebTestBase {
        WebFormPage webFormPage = new WebFormPage();
        RandomData randomData = new RandomData();

    @Test
    void webFormTest() {
        webFormPage.openPage()
        .bannerDrop()
                .setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setEmail(randomData.email)
                .setGender(randomData.gender)
                .setUserNumber(randomData.phoneNumber)
                .setDateOfBirth(randomData.BirthDay, randomData.BirthMonth, randomData.BirthYear)
                .setSubject(randomData.subject)
                .setHobby(randomData.hobby)
                .uploadFile(randomData.picture)
                .setCurrentAddress(randomData.currentAddress)
                .setState(randomData.state)
                .setCity(randomData.city)
                .submitClick()
                .checkResult("Student Name", randomData.firstName + " " + randomData.lastName)
                .checkResult("Student Email", randomData.email)
                .checkResult("Gender", randomData.gender)
                .checkResult("Mobile", randomData.phoneNumber)
                .checkResult("Date of Birth", String.format(randomData.BirthDay + " " + randomData.BirthMonth + "," + randomData.BirthYear))
                .checkResult("Subjects", randomData.subject)
                .checkResult("Hobbies", randomData.hobby)
                .checkResult("Picture", randomData.picture)
                .checkResult("Address", randomData.currentAddress)
                .checkResult("State and City", randomData.state + " " + randomData.city);
    }
    @Test
    void shortFillFormTest() {
        webFormPage.openPage();
        webFormPage.bannerDrop()
                .setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setGender(randomData.gender)
                .setUserNumber(randomData.phoneNumber)
                .setDateOfBirth(randomData.BirthDay, randomData.BirthMonth, randomData.BirthYear)
                .submitClick()
                .checkResult("Student Name", randomData.firstName + " " + randomData.lastName)
                .checkResult("Gender", randomData.gender)
                .checkResult("Mobile", randomData.phoneNumber)
                .checkResult("Date of Birth", String.format(randomData.BirthDay + " " + randomData.BirthMonth + "," + randomData.BirthYear));
    }

    @Test
    void incorrectFillFormTest() {
        webFormPage.openPage();
        webFormPage.bannerDrop()
                .setFirstName(randomData.lastName)
                .setLastName(randomData.firstName)
                .setGender("Male")
                .setDateOfBirth(randomData.BirthDay , randomData.BirthMonth, randomData.BirthYear)
                .submitClick()
                .checkAbsenceFormResult();
    }
}