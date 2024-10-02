package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private SelenideElement fullNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement addressCurrentInput = $("#currentAddress");
    private SelenideElement addressPermanentInput = $("#permanentAddress");
    private SelenideElement submitInput = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }
    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        addressCurrentInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        addressPermanentInput.setValue(value);
        return this;
    }

    public void clickSubmit() {
        submitInput.click();
    }

    public TextBoxPage checkResult(String key, String value) {
        $("div#output").shouldHave(text(key + value));
        return this;
    }
}


