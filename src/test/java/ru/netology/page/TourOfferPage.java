package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class TourOfferPage {

    private SelenideElement byCardButton = $(byText("Купить"));
    private SelenideElement onCreditButton = $(byText("Купить в кредит"));

    public PaymentPage payByCard() {
        byCardButton.click();
        return new PaymentPage();
    }

    public PaymentPage buyOnCredit() {
        onCreditButton.click();
        return new PaymentPage();
    }
}
