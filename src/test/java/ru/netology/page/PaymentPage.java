package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {

    private ElementsCollection fields = $$(".input__control");
    private SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement expirationMonth = $("[placeholder='08']");
    private SelenideElement expirationYear = $("[placeholder='22']");
    private SelenideElement cardHolderName = fields.get(3);
    private SelenideElement cardSecurityCode = $("[placeholder='999']");

    private SelenideElement successNotification = $(withText("Успешно"));
    private SelenideElement errorNotification = $(withText("Ошибка"));
    private SelenideElement continueButton = $(withText("Продолжить"));
    private SelenideElement invalidFormatError = $(withText("Неверный формат"));
    private SelenideElement requiredToFillIn = $(withText("Поле обязательно для заполнения"));
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

    public void requiredToFillIn() {
        requiredToFillIn.shouldBe(visible);
    }

    public void expiredYear() {
        expiredYearError.shouldBe(visible);
    }

    public void expiredMonth() {
        expiredMonthError.shouldBe(visible);
    }
}

