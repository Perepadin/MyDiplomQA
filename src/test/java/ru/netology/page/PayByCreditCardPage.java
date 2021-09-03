package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PayByCreditCardPage {
    private SelenideElement onCreditButton = $(byText("Купить в кредит"));

    public PaymentPage buyOnCredit() {
        onCreditButton.click();
        return new PaymentPage();
    }
}
