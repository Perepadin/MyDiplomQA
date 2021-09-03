package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.SQLunits.SqlUtils;
import ru.netology.data.DataHelper;
import ru.netology.page.PayByCardPage;
import ru.netology.page.PayByCreditCardPage;


import static com.codeborne.selenide.Selenide.open;


public class HappyPathTest {

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

    @DisplayName("1. Successful purchase by card.")
    @Test
    public void shouldConfirmPaymentWithApprovedCard() {
        var tourOfferPage = new PayByCardPage();
        var paymentPage = tourOfferPage.payByCard();
        var approvedCardInformation = DataHelper.getValidCardInformation();
        paymentPage.enterCardData(approvedCardInformation);
        paymentPage.successfulPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }

    @DisplayName("2. Successful purchase on credit")
    @Test
    public void shouldConfirmBuyingOnCreditWithApprovedCard() {
        var tourOfferPage = new PayByCreditCardPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var approvedCardInformation = DataHelper.getValidCardInformation();
        paymentPage.enterCardData(approvedCardInformation);
        paymentPage.successfulPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForCredit(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }
}
