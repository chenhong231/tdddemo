package creationmethod.after;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class CapitalCalculationTests {

    private double commitment;
    private int riskRating;
    private Date maturity;
    private RiskAdjustedCapitalStrategy riskAdjustedCapitalStrategy;
    private double outstanding;

    @Test
    public void testTermLoanNoPayments() {
        Loan termLoan = Loan.createTermLoan(commitment, riskRating, maturity);
    }

    @Test
    public void testTermLoanWithRiskAdjustedCapitalStrategy() {
        Loan termLoan = Loan.createTermLoan(riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity);
    }
}
