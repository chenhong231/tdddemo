package com.tdd;

import java.text.NumberFormat;
import java.util.Locale;

public class TheatricalPlayers {

    private TotalAmountCalculator totalAmountCalculator;
    private VolumeCreditsCalculator volumeCreditsCalculator;
    private ResultFormatter resultFormatter;

    public TheatricalPlayers(TotalAmountCalculator totalAmountCalculator, VolumeCreditsCalculator volumeCreditsCalculator, ResultFormatter resultFormatter) {
        this.totalAmountCalculator = totalAmountCalculator;
        this.volumeCreditsCalculator = volumeCreditsCalculator;
        this.resultFormatter = resultFormatter;
    }

    public String print(Invoice invoice) {
        String result = String.format("Statement for %s\n", invoice.customer);
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        result += String.format("Amount owed is %s\n", format.format(invoice.getTotalAmount() / 100));
        result += String.format("You earned %s credits\n", invoice.getVolumeCredits());
        return result;
    }

}
