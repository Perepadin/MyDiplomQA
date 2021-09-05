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

public class SadPathTest {

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

    @DisplayName("3 Негативный сценарий. Покупка с незаполненными данными.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyForm() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getEmptyCardInformation();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(invalidCardInformation);
        PayByCard.invalidPayCardFormat();
    }

    @DisplayName("4 A negative scenario. Purchase on credit with blank data.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyForm() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var emptyCardInformation = DataHelper.getEmptyCardInformation();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(emptyCardInformation);
        PayByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("5 A negative scenario. Purchase with blank card data.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var fieldCardEmpty = DataHelper.getFieldCardEmpty();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(fieldCardEmpty);
        PayByCard.invalidPayCardFormat();
    }

    @DisplayName("6 A negative scenario. Purchase on credit with blank card details.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var fieldCardEmpty = DataHelper.getFieldCardEmpty();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(fieldCardEmpty);
        PayByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("7 A negative scenario. Purchase with a card with blank card data")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldYear() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var fieldYearEmpty = DataHelper.getFieldYearEmpty();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(fieldYearEmpty);
        PayByCard.invalidPayCardFormat();
    }

    @DisplayName("8 A negative scenario. Purchase on credit with the data of the Year field blank.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldYear() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var fieldYearEmpty = DataHelper.getFieldYearEmpty();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(fieldYearEmpty);
        PayByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("9 A negative scenario. A purchase with blank data in the Month field.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldMonth() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var fieldMonthEmpty = DataHelper.getFieldMonthEmpty();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(fieldMonthEmpty);
        PayByCard.invalidPayCardFormat();
    }

    @DisplayName("10 A negative scenario. Purchase on credit with the data of the Month field blank.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldMonth() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var fieldMonthEmpty = DataHelper.getFieldMonthEmpty();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(fieldMonthEmpty);
        PayByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("11 A negative scenario. Purchase with blank data in the Holder field")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldHolder() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var fieldHolderEmpty = DataHelper.getFieldHolderEmpty();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(fieldHolderEmpty);
        PayByCard.requiredPayCardToFillIn();
    }

    @DisplayName("12 A negative scenario. Purchase on credit with blank data in the Holder field")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldHolder() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var fieldHolderEmpty = DataHelper.getFieldHolderEmpty();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(fieldHolderEmpty);
        PayByCreditCard.requiredCreditCardToFillIn();
    }

    @DisplayName("13 A negative scenario. Purchase with blank CVV field data.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldCvv() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var fieldCvvEmpty = DataHelper.getFieldCVVEmpty();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(fieldCvvEmpty);
        PayByCard.invalidPayCardFormat();
    }

    @DisplayName("14 A negative scenario. Purchase on credit with blank CVV field data.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldCvv() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var fieldCvvEmpty = DataHelper.getFieldCVVEmpty();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(fieldCvvEmpty);
        PayByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("15 A negative scenario. Purchase with a Declined card.")
    @Test
    public void shouldPaymentWithDeclinedCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var declinedCardInformation = DataHelper.getDeclinedCardInformation();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(declinedCardInformation);
        PayByCard.notSuccessfulPayCardPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForPayment(paymentId);
        Assertions.assertEquals("DECLINED", statusForPayment);
    }

    @DisplayName("16 A negative scenario. Purchase on credit with a Declined card.")
    @Test
    public void shouldPaymentWithDeclinedCreditCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var declinedCardInformation = DataHelper.getDeclinedCardInformation();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(declinedCardInformation);
        PayByCreditCard.notSuccessfulCreditCardPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForCredit(paymentId);
        Assertions.assertEquals("DECLINED", statusForPayment);
    }

    @DisplayName("17 A negative scenario. Purchase using an expired card (in previous years).")
    @Test
    public void shouldNotConfirmPaymentWithExpiredYearCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredYear();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(invalidCardInformation);
        PayByCard.expiredPayCardYear();
    }

    @DisplayName("18 A negative scenario. Purchase on credit using an expired card (in previous years).")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithExpiredYearCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredYear();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(invalidCardInformation);
        PayByCreditCard.expiredCreditCardYear();
    }

    @DisplayName("19 A negative scenario. Purchase using an expired card (in the last month).")
    @Test
    public void shouldNotConfirmPaymentWithExpiredMonthCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredMonth();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(invalidCardInformation);
        PayByCard.expiredPayCardMonth();
    }

    @DisplayName("20 A negative scenario. Purchase on credit using an expired card (in the last month).")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithExpiredMonthCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredMonth();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(invalidCardInformation);
        PayByCreditCard.expiredCreditCardMonth();
    }

    @DisplayName("21 A negative scenario. Purchase using a card with the holder's name in Cyrillic.")
    @Test
    public void shouldNotConfirmPaymentWithCyrillicHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithCyrillicName();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(invalidCardInformation);
        PayByCard.invalidPayCardFormat();
    }

    @DisplayName("22 A negative scenario. Purchase on credit using a card with the holder's name in Cyrillic.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithCyrillicHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithCyrillicName();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(invalidCardInformation);
        PayByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("23 A negative scenario. Purchase using a card with numbers in the name of the holder.")
    @Test
    public void shouldNotConfirmPaymentWithNumericHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithNumericName();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(invalidCardInformation);
        PayByCard.invalidPayCardFormat();
    }

    @DisplayName("24 A negative scenario. Purchase on credit according to the card data with numbers in the name of the holder.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithNumericHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithNumericName();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(invalidCardInformation);
        PayByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("25 A negative scenario. Purchase using a card with an incorrect date field format")
    @Test
    public void shouldNotConfirmPaymentWithWrongFormatFieldsCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithWrongFormatDate();
        tourOfferPage.payByCard();
        PayByCard.enterPayCardData(invalidCardInformation);
        PayByCard.invalidPayCardFormat();
    }

    @DisplayName("26 A negative scenario. Purchase on credit according to the card data with the wrong format of the date fields.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithWrongFormatFieldsCard() {
        var tourOfferPage = new TourOfferPage();
        var PayByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithWrongFormatDate();
        tourOfferPage.buyOnCredit();
        PayByCreditCard.enterCreditCardData(invalidCardInformation);
        PayByCreditCard.invalidCreditCardFormat();
    }
}
