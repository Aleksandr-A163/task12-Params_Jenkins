package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LocationComponent {
    public void setStateOrCity(String value){
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}