package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.TourOfferPage;

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
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var invalidCardInformation = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("3 A negative scenario. Purchase on credit with blank data.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyForm() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var emptyCardInformation = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardData(emptyCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("4 A negative scenario. Purchase with blank card data.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var fieldCardEmpty = DataHelper.getFieldCardEmpty();
        paymentPage.enterCardData(fieldCardEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("5 A negative scenario. Purchase on credit with blank card details.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var fieldCardEmpty = DataHelper.getFieldCardEmpty();
        paymentPage.enterCardData(fieldCardEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("6 A negative scenario. Purchase with a card with blank card data")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldYear() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var fieldYearEmpty = DataHelper.getFieldYearEmpty();
        paymentPage.enterCardData(fieldYearEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("7 A negative scenario. Purchase on credit with the data of the Year field blank.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldYear() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var fieldYearEmpty = DataHelper.getFieldYearEmpty();
        paymentPage.enterCardData(fieldYearEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("8 A negative scenario. A purchase with blank data in the Month field.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldMonth() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var fieldMonthEmpty = DataHelper.getFieldMonthEmpty();
        paymentPage.enterCardData(fieldMonthEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("9 A negative scenario. Purchase on credit with the data of the Month field blank.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldMonth() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var fieldMonthEmpty = DataHelper.getFieldMonthEmpty();
        paymentPage.enterCardData(fieldMonthEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("10 A negative scenario. Purchase with blank data in the Holder field")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldHolder() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var fieldHolderEmpty = DataHelper.getFieldHolderEmpty();
        paymentPage.enterCardData(fieldHolderEmpty);
        paymentPage.requiredToFillIn();
    }

    @DisplayName("11 A negative scenario. Purchase on credit with blank data in the Holder field")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldHolder() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var fieldHolderEmpty = DataHelper.getFieldHolderEmpty();
        paymentPage.enterCardData(fieldHolderEmpty);
        paymentPage.requiredToFillIn();
    }

    @DisplayName("12 A negative scenario. Purchase with blank CVV field data.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldCvv() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var fieldCvvEmpty = DataHelper.getFieldCVVEmpty();
        paymentPage.enterCardData(fieldCvvEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("13 A negative scenario. Purchase on credit with blank CVV field data.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldCvv() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var fieldCvvEmpty = DataHelper.getFieldCVVEmpty();
        paymentPage.enterCardData(fieldCvvEmpty);
        paymentPage.invalidFormat();
    }

    @DisplayName("14 A negative scenario. Purchase with a Declined card.")
    @Test
    public void shouldPaymentWithDeclinedCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var declinedCardInformation = DataHelper.getDeclinedCardInformation();
        paymentPage.enterCardData(declinedCardInformation);
        paymentPage.notSuccessfulPayment();
    }

    @DisplayName("15 A negative scenario. Purchase on credit with a Declined card.")
    @Test
    public void shouldPaymentWithDeclinedCreditCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var declinedCardInformation = DataHelper.getDeclinedCardInformation();
        paymentPage.enterCardData(declinedCardInformation);
        paymentPage.notSuccessfulPayment();
    }

    @DisplayName("16 A negative scenario. Purchase using an expired card (in previous years).")
    @Test
    public void shouldNotConfirmPaymentWithExpiredYearCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredYear();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.expiredYear();
    }

    @DisplayName("17 A negative scenario. Purchase on credit using an expired card (in previous years).")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithExpiredYearCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredYear();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.expiredYear();
    }

    @DisplayName("18 A negative scenario. Purchase using an expired card (in the last month).")
    @Test
    public void shouldNotConfirmPaymentWithExpiredMonthCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredMonth();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.expiredMonth();
    }

    @DisplayName("19 A negative scenario. Purchase on credit using an expired card (in the last month).")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithExpiredMonthCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredMonth();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.expiredMonth();
    }

    @DisplayName("20 A negative scenario. Purchase using a card with the holder's name in Cyrillic.")
    @Test
    public void shouldNotConfirmPaymentWithCyrillicHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var invalidCardInformation = DataHelper.getCardInformationWithCyrillicName();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("21 A negative scenario. Purchase on credit using a card with the holder's name in Cyrillic.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithCyrillicHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var invalidCardInformation = DataHelper.getCardInformationWithCyrillicName();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("22 A negative scenario. Purchase using a card with numbers in the name of the holder.")
    @Test
    public void shouldNotConfirmPaymentWithNumericHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var invalidCardInformation = DataHelper.getCardInformationWithNumericName();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("23 A negative scenario. Purchase on credit according to the card data with numbers in the name of the holder.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithNumericHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var invalidCardInformation = DataHelper.getCardInformationWithNumericName();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("24 A negative scenario. Purchase using a card with an incorrect date field format")
    @Test
    public void shouldNotConfirmPaymentWithWrongFormatFieldsCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.payByCard();
        var invalidCardInformation = DataHelper.getCardInformationWithWrongFormatDate();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }

    @DisplayName("25 A negative scenario. Purchase on credit according to the card data with the wrong format of the date fields.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithWrongFormatFieldsCard() {
        var tourOfferPage = new TourOfferPage();
        var paymentPage = tourOfferPage.buyOnCredit();
        var invalidCardInformation = DataHelper.getCardInformationWithWrongFormatDate();
        paymentPage.enterCardData(invalidCardInformation);
        paymentPage.invalidFormat();
    }
}
