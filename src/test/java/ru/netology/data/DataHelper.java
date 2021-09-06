package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    static Faker enOption = new Faker(new Locale("en"));
    static DateGenerator dateGenerator = new DateGenerator();
    static CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();

    public static CardInformation getEmptyCardInformation() {
        return new CardInformation(
                " ",
                " ",
                " ",
                " ",
                " ");
    }

    public static CardInformation getFieldCardEmpty() {
        return new CardInformation(
                " ",
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getFieldYearEmpty() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                " ",
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getFieldMonthEmpty() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                " ",
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getFieldHolderEmpty() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                " ",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getFieldCVVEmpty() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody",
                "");
    }

    public static CardInformation getValidCardInformation() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                enOption.harryPotter().character(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithInvalidNumber() {
        return new CardInformation(
                cardNumberGenerator.getInvalidCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(0, 999)));
    }

    public static CardInformation getDeclinedCardInformation() {
        return new CardInformation(
                cardNumberGenerator.getDeclinedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithExpiredYear() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(-2).getYear(),
                dateGenerator.shiftMonth(0).getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithExpiredMonth() {
        return new CardInformation(cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(0).getYear(),
                dateGenerator.shiftMonth(-1).getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithCurrentMonthAndYear() {
        return new CardInformation(cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(0).getYear(),
                dateGenerator.shiftMonth(0).getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithNextMonth() {
        return new CardInformation(cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(0).getYear(),
                dateGenerator.shiftMonth(1).getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithZeroMonthAndYear() {
        return new CardInformation(cardNumberGenerator.getApprovedCardNumber(),
                "00",
                "00",
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithWrongFormatDate() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.wrongYear().getYear(),
                dateGenerator.wrongMonth().getMonth(),
                "Steven Moody",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithCyrillicName() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Кирилл Иванов",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationCyrillicPlusNumbersInHolderFieldCard() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Кирилл Иванов123",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationCyrillicPlusNumbersPlusSpecialSymbolInHolderFieldCard() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Кирилл Иванов123@@@",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationEnglishPlusNumbersInHolderFieldCard() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody123",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationEnglishPlusNumbersPlusSpecialSymbolInHolderFieldCard() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody123$%#%",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationSpecialSymbolInHolderFieldCard() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "!@#$%^&*()_",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithNumericName() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                Integer.toString(enOption.number().numberBetween(1, 999)),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInformationWithZeroFormatCVV() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody",
                "000");
    }

    public static CardInformation getCardInformationWithInvalidFormatCVV() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Steven Moody",
                "ghghgh");
    }

    @Value
    public static class CardInformation {
        private String cardNumber;
        private String year;
        private String month;
        private String holder;
        private String CVV;
    }
}