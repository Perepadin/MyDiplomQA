package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PayByCardPage {
    private SelenideElement byCardButton = $(byText("Купить"));

    public PaymentPage payByCard() {
        byCardButton.click();
        return new PaymentPage();
    }
}
