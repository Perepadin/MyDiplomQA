package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.SQLunits.SqlUtils;
import ru.netology.data.DataHelper;
import ru.netology.page.PayByCardPage;
import ru.netology.page.PayByCreditCardPage;
import ru.netology.page.TourOfferPage;

import static com.codeborne.selenide.Selenide.open;


public class HappyPathTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openChrome() {
        open("http://localhost:8080/");
    }

    @DisplayName("1. Successful purchase by card.")
    @Test
    public void shouldConfirmPaymentWithApprovedCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var approvedCardInformation = DataHelper.getValidCardInformation();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(approvedCardInformation);
        PayByCard.successfulPayCardPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }

    @DisplayName("2. Successful purchase on credit")
    @Test
    public void shouldConfirmBuyingOnCreditWithApprovedCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var approvedCardInformation = DataHelper.getValidCardInformation();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(approvedCardInformation);
        PayByCreditCard.successfulCreditCardPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForCredit(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }
}
