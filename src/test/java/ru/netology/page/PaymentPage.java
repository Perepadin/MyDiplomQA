package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    private static SelenideElement byCardButton = $(byText("Купить"));
    private static SelenideElement onCreditButton = $(byText("Купить в кредит"));
    private static SelenideElement methodOfPaymentHeader = $("#root > div > h3");

    public static PaymentPage payByCard() {
        byCardButton.click();
        methodOfPaymentHeader.shouldHave(Condition.text("Оплата по карте"));
        return new PaymentPage();
    }

    public static PaymentPage buyOnCredit() {
        onCreditButton.click();
        methodOfPaymentHeader.shouldHave(Condition.text("Кредит по данным карты"));
        return new PaymentPage();
    }


    private SelenideElement cardNumber = $("input[type=\"text\"][placeholder=\"0000 0000 0000 0000\"]");
    private SelenideElement expirationMonth = $("input[type=\"text\"][placeholder=\"08\"]");
    private SelenideElement expirationYear = $("input[type=\"text\"][placeholder=\"22\"]");
    private SelenideElement cardHolderName = $("form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    private SelenideElement cardSecurityCode = $("input[type=\"text\"][placeholder=\"999\"]");

    private SelenideElement successNotification = $(withText("Успешно"));
    private SelenideElement errorNotification = $(withText("Ошибка"));
    private SelenideElement continueButton = $(withText("Продолжить"));
    private SelenideElement invalidFormatError = $(withText("Неверный формат"));
    private SelenideElement expiredYearError = $(withText("Истёк срок действия карты"));
    private SelenideElement expiredMonthError = $(withText("Неверно указан срок действия карты"));

    public void enterCardData(DataHelper.CardInformation cardInformation) {
        cardNumber.setValue(cardInformation.getCardNumber());
        expirationMonth.setValue(cardInformation.getMonth());
        expirationYear.setValue(cardInformation.getYear());
        cardHolderName.setValue(cardInformation.getHolder());
        cardSecurityCode.setValue(cardInformation.getCVV());
        continueButton.click();
    }

    public void successfulPayment() {
        successNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void notSuccessfulPayment() {
        errorNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void invalidFormat() {
        invalidFormatError.shouldBe(visible);
    }

    public void expiredYear() {
        expiredYearError.shouldBe(visible);
    }

    public void expiredMonth() {
        expiredMonthError.shouldBe(visible);
    }
}

