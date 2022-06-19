package creationmethod.before;

import java.util.Date;

public class CapitalCalculationTests {

    private double commitment;
    private int riskRating;
    private Date maturity;

    public void testTermLoanNoPayments() {
        Loan termLoan = new Loan(commitment, riskRating, maturity);
    }
}
