package legacycode.after;

import java.text.NumberFormat;
import java.util.Locale;

public class TheatricalPlayers {

    public String print(Invoice invoice) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String result = String.format("Statement for %s\n", invoice.customer);
        result += String.format("Amount owed is %s\n", format.format(invoice.calculateTotalAmount() / 100));
        result += String.format("You earned %s credits\n", invoice.calculateVolumeCredits());
        return result;
    }

}
