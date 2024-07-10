package tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import utils.RandomData;

@Tag("form")
@DisplayName("Тесты для малой формы")
public class TextBoxTests extends WebTestBase {

    TextBoxPage textBox = new TextBoxPage();
    RandomData randomData = new RandomData();

    @Test
    void fillFormTest() {
        textBox.openPage()
        .bannerDrop()
                .setFullName(randomData.firstName)
                .setEmail(randomData.email)
                .setCurrentAddress(randomData.currentAddress)
                .setPermanentAddress(randomData.currentAddress)
                .submitClick()
                .checkResult("name",randomData.firstName)
                .checkResult("email",randomData.email)
                .checkResult("currentAddress",randomData.currentAddress)
                .checkResult("permanentAddress",randomData.currentAddress);
    }
}