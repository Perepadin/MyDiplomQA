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

    @DisplayName("3 Negative scenario. Purchase on card with blank data.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyForm() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getEmptyCardInformation();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("4 Negative scenario. Purchase on credit with blank data.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyForm() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var emptyCardInformation = DataHelper.getEmptyCardInformation();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(emptyCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("5 Negative scenario. Purchase with blank card data.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var fieldCardEmpty = DataHelper.getFieldCardEmpty();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(fieldCardEmpty);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("6 Negative scenario. Purchase on credit with blank card details.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var fieldCardEmpty = DataHelper.getFieldCardEmpty();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(fieldCardEmpty);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("7 Negative scenario. Purchase with the data of the Year field blank.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldYear() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var fieldYearEmpty = DataHelper.getFieldYearEmpty();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(fieldYearEmpty);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("8 Negative scenario. Purchase on credit with the data of the Year field blank.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldYear() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var fieldYearEmpty = DataHelper.getFieldYearEmpty();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(fieldYearEmpty);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("9 Negative scenario. A purchase with blank data in the Month field.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldMonth() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var fieldMonthEmpty = DataHelper.getFieldMonthEmpty();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(fieldMonthEmpty);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("10 Negative scenario. Purchase on credit with the data of the Month field blank.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldMonth() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var fieldMonthEmpty = DataHelper.getFieldMonthEmpty();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(fieldMonthEmpty);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("11 Negative scenario. Purchase with blank data in the Holder field")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldHolder() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var fieldHolderEmpty = DataHelper.getFieldHolderEmpty();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(fieldHolderEmpty);
        payByCard.requiredPayCardToFillIn();
    }

    @DisplayName("12 Negative scenario. Purchase on credit with blank data in the Holder field")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldHolder() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var fieldHolderEmpty = DataHelper.getFieldHolderEmpty();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(fieldHolderEmpty);
        payByCreditCard.requiredCreditCardToFillIn();
    }

    @DisplayName("13 Negative scenario. Purchase with blank CVV field data.")
    @Test
    public void shouldNotConfirmPaymentWithEmptyFieldCvv() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var fieldCvvEmpty = DataHelper.getFieldCVVEmpty();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(fieldCvvEmpty);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("14 Negative scenario. Purchase on credit with blank CVV field data.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEmptyFieldCvv() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var fieldCvvEmpty = DataHelper.getFieldCVVEmpty();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(fieldCvvEmpty);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("15 Negative scenario. Purchase with a Declined card.")
    @Test
    public void shouldPaymentWithDeclinedCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var declinedCardInformation = DataHelper.getDeclinedCardInformation();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(declinedCardInformation);
        payByCard.notSuccessfulPayCardPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForPayment(paymentId);
        Assertions.assertEquals("DECLINED", statusForPayment);
    }

    @DisplayName("16 Negative scenario. Purchase on credit with a Declined card.")
    @Test
    public void shouldPaymentWithDeclinedCreditCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var declinedCardInformation = DataHelper.getDeclinedCardInformation();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(declinedCardInformation);
        payByCreditCard.notSuccessfulCreditCardPayment();

        var paymentId = SqlUtils.getPaymentId();
        var statusForPayment = SqlUtils.getStatusForCredit(paymentId);
        Assertions.assertEquals("DECLINED", statusForPayment);
    }

    @DisplayName("17 Negative scenario. Purchase using an expired card (in previous years).")
    @Test
    public void shouldNotConfirmPaymentWithExpiredYearCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredYear();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.expiredPayCardYear();
    }

    @DisplayName("18 Negative scenario. Purchase on credit using an expired card (in previous years).")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithExpiredYearCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredYear();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.expiredCreditCardYear();
    }

    @DisplayName("19 Negative scenario. Purchase using an expired card (in the last month).")
    @Test
    public void shouldNotConfirmPaymentWithExpiredMonthCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredMonth();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.expiredPayCardMonth();
    }

    @DisplayName("20 Negative scenario. Purchase on credit using an expired card (in the last month).")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithExpiredMonthCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithExpiredMonth();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.expiredCreditCardMonth();
    }

    @DisplayName("21 Negative scenario. Purchase with a card that expires in the current month and year.")
    @Test
    public void shouldConfirmPaymentWithNowCurrentMonthAndYear() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithCurrentMonthAndYear();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.successfulPayCardPayment();
    }

    @DisplayName("22 Negative scenario. Purchase with a credit card that expires in the current month and year.")
    @Test
    public void shouldConfirmBuyingOnCreditWithCurrentMonthAndYear() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithCurrentMonthAndYear();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.successfulCreditCardPayment();
    }

    @DisplayName("23 Negative scenario. A card purchase that expires next month.")
    @Test
    public void shouldConfirmPaymentWithNextMonthCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithNextMonth();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.successfulPayCardPayment();
    }

    @DisplayName("24 Negative scenario. A credit card purchase that expires next month.")
    @Test
    public void shouldConfirmBuyingOnCreditWithNextMonthCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithNextMonth();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.successfulCreditCardPayment();
    }

    @DisplayName("25 Negative scenario. Purchase by card when entering zeros in the month and year field.")
    @Test
    public void shouldNotConfirmPaymentWithZeroMonthAndYear() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithZeroMonthAndYear();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.expiredPayCardYear();
    }

    @DisplayName("26 Negative scenario. Purchase by credit card when entering zeros in the month and year field.")
    @Test
    public void shouldConfirmBuyingOnCreditWithZeroMonthAndYear() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithZeroMonthAndYear();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.expiredCreditCardYear();
    }

    @DisplayName("27 Negative scenario. Purchase using a card with an incorrect date field format")
    @Test
    public void shouldNotConfirmPaymentWithWrongFormatFieldsCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithWrongFormatDate();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("28 Negative scenario. Purchase on credit card with an incorrect date field format")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithWrongFormatFieldsCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithWrongFormatDate();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("29 Negative scenario. Purchase using a card with the holder's name in Cyrillic.")
    @Test
    public void shouldNotConfirmPaymentWithCyrillicHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithCyrillicName();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("30 Negative scenario. Purchase on credit using a card with the holder's name in Cyrillic.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithCyrillicHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithCyrillicName();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("31 Negative scenario. Purchase using a card with the holder's name in Cyrillic and Numbers.")
    @Test
    public void shouldNotConfirmPaymentWithCyrillicPlusNumbersInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationCyrillicPlusNumbersInHolderFieldCard();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("32 Negative scenario. Purchase on credit using a card with the holder's name in Cyrillic and Numbers.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithCyrillicPlusNumbersInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationCyrillicPlusNumbersInHolderFieldCard();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("33 Negative scenario. Purchase using a card with the holder's name in Cyrillic, Numbers, Special Symbol.")
    @Test
    public void shouldNotConfirmPaymentWithCyrillicPlusNumbersPlusSpecialSymbolInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationCyrillicPlusNumbersPlusSpecialSymbolInHolderFieldCard();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("34 Negative scenario. Purchase on credit using a card with the holder's name in Cyrillic, Numbers, Special Symbol.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithCyrillicPlusNumbersPlusSpecialSymbolInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationCyrillicPlusNumbersPlusSpecialSymbolInHolderFieldCard();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("35 Negative scenario. Purchase using a card with the holder's name in English and Numbers.")
    @Test
    public void shouldNotConfirmPaymentWithEnglishPlusNumbersInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationEnglishPlusNumbersInHolderFieldCard();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("36 Negative scenario. Purchase on credit using a card with the holder's name in English and Numbers.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEnglishPlusNumbersInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationEnglishPlusNumbersInHolderFieldCard();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("37 Negative scenario. Purchase using a card with the holder's name in English, Numbers, Special Symbol.")
    @Test
    public void shouldNotConfirmPaymentWithEnglishPlusNumbersPlusSpecialSymbolInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationEnglishPlusNumbersPlusSpecialSymbolInHolderFieldCard();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("38 Negative scenario. Purchase on credit using a card with the holder's name in English, Numbers, Special Symbol.")
    @Test
    public void shouldNotConfirmBuyingOnCreditSpecialSymbolInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationEnglishPlusNumbersPlusSpecialSymbolInHolderFieldCard();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("39 Negative scenario. Purchase using a card with the holder's name in Special Symbol.")
    @Test
    public void shouldNotConfirmPaymentWithSpecialSymbolInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationSpecialSymbolInHolderFieldCard();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("40 Negative scenario. Purchase on credit using a card with the holder's name in Special Symbol.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithEnglishPlusNumbersPlusSpecialSymbolInHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationSpecialSymbolInHolderFieldCard();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("41 Negative scenario. Purchase using a card with numbers in the name of the holder.")
    @Test
    public void shouldNotConfirmPaymentWithNumericHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithNumericName();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("42 Negative scenario. Purchase on credit according to the card data with numbers in the name of the holder.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithNumericHolderFieldCard() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithNumericName();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("43 Negative scenario. Purchase using a card with Zero Format CVV")
    @Test
    public void shouldNotConfirmPaymentWithZeroFormatCVV() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithZeroFormatCVV();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("44 Negative scenario. Purchase using a credit card with Zero Format CVV")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithZeroFormatCVV() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithZeroFormatCVV();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @DisplayName("45 Negative scenario. Purchase using a card with Invalid Format CVV.")
    @Test
    public void shouldNotConfirmPaymentWithInvalidFormatCVV() {
        var tourOfferPage = new TourOfferPage();
        var payByCard = new PayByCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithInvalidFormatCVV();
        tourOfferPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @DisplayName("46 Negative scenario. Purchase using a credit card with Invalid Format CVV.")
    @Test
    public void shouldNotConfirmBuyingOnCreditWithInvalidFormatCVV() {
        var tourOfferPage = new TourOfferPage();
        var payByCreditCard = new PayByCreditCardPage();
        var invalidCardInformation = DataHelper.getCardInformationWithInvalidFormatCVV();
        tourOfferPage.buyOnCredit();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }
}