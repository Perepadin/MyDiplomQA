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

    @DisplayName("Негативный сценарий. Покупка с незаполненными данными.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyForm() {
        val paymentPage = PaymentPage.payByCard();
        val declinedCardNumber = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardData(declinedCardNumber);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка в кредит с незаполненными данными.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyForm() {
        val paymentPage = PaymentPage.buyOnCredit();
        val invalidCardInformation = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка с незаполненными данными карты.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldCard() {
        val paymentPage = PaymentPage.payByCard();
        val fieldCardEmpty = DataHelper.getFieldCardEmpty();
        paymentPage.enterCardData(fieldCardEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка в кредит с незаполненными данными карты.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldCard() {
        val paymentPage = PaymentPage.buyOnCredit();
        val fieldCardEmpty = DataHelper.getFieldCardEmpty();
        paymentPage.enterCardData(fieldCardEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка с незаполненными данными поля Год.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldYear() {
        val paymentPage = PaymentPage.payByCard();
        val fieldYearEmpty = DataHelper.getFieldYearEmpty();
        paymentPage.enterCardData(fieldYearEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка в кредит с незаполненными данными поля Год.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldYear() {
        val paymentPage = PaymentPage.buyOnCredit();
        val fieldYearEmpty = DataHelper.getFieldYearEmpty();
        paymentPage.enterCardData(fieldYearEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка с незаполненными данными поля Месяц.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldMonth() {
        val paymentPage = PaymentPage.payByCard();
        val fieldMonthEmpty = DataHelper.getFieldMonthEmpty();
        paymentPage.enterCardData(fieldMonthEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка в кредит с незаполненными данными поля Месяц.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldMonth() {
        val paymentPage = PaymentPage.buyOnCredit();
        val fieldMonthEmpty = DataHelper.getFieldMonthEmpty();
        paymentPage.enterCardData(fieldMonthEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка с незаполненными данными поля Владелец.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldHolder() {
        val paymentPage = PaymentPage.payByCard();
        val fieldHolderEmpty = DataHelper.getFieldHolderEmpty();
        paymentPage.enterCardData(fieldHolderEmpty);
        paymentPage.requiredToFillIn();
    }

    @DisplayName("Негативный сценарий. Покупка в кредит с незаполненными данными поля Владелец.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldHolder() {
        val paymentPage = PaymentPage.buyOnCredit();
        val fieldHolderEmpty = DataHelper.getFieldHolderEmpty();
        paymentPage.enterCardData(fieldHolderEmpty);
        paymentPage.requiredToFillIn();
    }

    @DisplayName("Негативный сценарий. Покупка с незаполненными данными поля CVV.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldCvv() {
        val paymentPage = PaymentPage.payByCard();
        val fieldCvvEmpty = DataHelper.getFieldCVVEmpty();
        paymentPage.enterCardData(fieldCvvEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("Негативный сценарий. Покупка в кредит с незаполненными данными поля CVV.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldCvv() {
        val paymentPage = PaymentPage.buyOnCredit();
        val fieldCvvEmpty = DataHelper.getFieldCVVEmpty();
        paymentPage.enterCardData(fieldCvvEmpty);
        paymentPage.invalidFormat();
    }
}
