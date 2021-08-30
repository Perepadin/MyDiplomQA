package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.SQLunits.SqlUtils;
import ru.netology.data.DataHelper;
import ru.netology.page.PaymentPage;

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

    @DisplayName("Успешная покупка по карте.")
    @Test
    public void shouldConfirmPaymentWithApprovedCard() throws SQLException {
        var paymentPage = PaymentPage.payByCard();
        var approvedCardInformation = DataHelper.getValidCardInformation();
        paymentPage.enterCardData(approvedCardInformation);
        paymentPage.successfulPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }

    @DisplayName("Успешная покупка в кредит.")
    @Test
    public void shouldConfirmBuyingOnCreditWithApprovedCard() throws SQLException {
        var paymentPage = PaymentPage.buyOnCredit();
        var approvedCardInformation = DataHelper.getValidCardInformation();
        paymentPage.enterCardData(approvedCardInformation);
        paymentPage.successfulPayment();
    }
}
