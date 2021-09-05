package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TourOfferPage {

    private final SelenideElement byCardButton = $(byText("Купить"));
    private final SelenideElement onCreditButton = $(byText("Купить в кредит"));

    public TourOfferPage payByCard() {
        byCardButton.click();
        return new PayByCardPage();
    }

    public TourOfferPage buyOnCredit() {
        onCreditButton.click();
        return new PayByCreditCardPage();
    }
}