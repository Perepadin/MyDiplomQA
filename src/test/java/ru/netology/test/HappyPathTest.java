package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.SQLunits.SqlUtils;
import ru.netology.data.DataHelper;
import ru.netology.page.TourOfferPage;

import java.sql.SQLException;

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

    @DisplayName("1. Успешная покупка по карте.")
    @Test
    public void shouldConfirmPaymentWithApprovedCard() throws SQLException {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var approvedCardInformation = DataHelper.getValidCardInformation();
        paymentPage.enterCardData(approvedCardInformation);
        paymentPage.successfulPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }

    @DisplayName("2. Успешная покупка в кредит.")
    @Test
    public void shouldConfirmBuyingOnCreditWithApprovedCard() throws SQLException {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var approvedCardInformation = DataHelper.getValidCardInformation();
        paymentPage.enterCardData(approvedCardInformation);
        paymentPage.successfulPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForCredit(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }
}
