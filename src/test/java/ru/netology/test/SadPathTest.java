package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class SadPathTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void openChrome() {
        open("http://localhost:8080/");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @DisplayName("Негативный сценарий. Покупка с незаполненными данными карты.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyForm() {
        val paymentPage = PaymentPage.payByCard();
        val invalidCardInformation = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка в кредит с незаполненными данными карты.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyForm() {
        val paymentPage = PaymentPage.buyOnCredit();
        val invalidCardInformation = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }
}
