package tests;

import data.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import page.TextBoxPage;

@DisplayName("Тесты на заполнение страницы TextBox ")

public class TextBoxPageObjectTests extends TestBase {


    @DisplayName("При вводе определенного имя пользователя, оно должно отображаться в окне результата")
    @ValueSource(strings = {"Kate Mar", "Test Tes", "Petr Pet"})
    @ParameterizedTest(name = "Проверка имя пользователя {0}")
    public void checkUserNameTest(String userName) {
        String userEmail = "kate@kate.ru";
        String currentAddress = "Moscow Russia";
        String permanentAddress = "Kazan Russia";

        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.openPage()
                .removeBanner()
                .setFullName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();
        textBoxPage
                .checkResult("Name:", userName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);
    }

    @DisplayName("При вводе определенного фактического адреса, он должен отображаться в окне результата")
    @CsvFileSource(resources = "/test_data/data for test.csv")
    @ParameterizedTest(name = "Проверка фактического адреса {1}")
    public void checkCurrentAddressWithCsvFileTest(String currentAddress) {
        String userName = "Kate Mar";
        String userEmail = "kate@kate.ru";
        String permanentAddress = "Kazan Russia";

        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.openPage()
                .removeBanner()
                .setFullName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();
        textBoxPage
                .checkResult("Name:", userName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);
    }

    @DisplayName("При вводе определенного email, он должен отображаться в окне результата")
    @EnumSource(Data.class)
    @ParameterizedTest(name = "Проверка email {0}")
    public void checkUserEmailWithEnum(Data data) {
        String userName = "Kate Mar";
        String currentAddress = "Moscow Russia";
        String permanentAddress = "Kazan Russia";

        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.openPage()
                .removeBanner()
                .setFullName(userName)
                .setUserEmail(data.getEmail())
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();
        textBoxPage
                .checkResult("Name:", userName)
                .checkResult("Email:", data.getEmail())
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);

    }
}

