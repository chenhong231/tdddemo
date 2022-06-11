package com.chapter6.creationmethod.after;

import java.util.Date;

public class CapitalCalculationTest {

    public void testTermLoanNoPayments() {

        double commitment = 0.0;
        int riskRating = 1;
        Date maturity = new Date();
        Loan termLoan = Loan.createTermLoan(commitment, riskRating, maturity);
    }

    public void testTermLoanWithRiskAdjustedCapitalStrategy() {
        CapitalStrategy riskAdjustedCapitalStrategy = null;
        double commitment = 0.0;
        double outstanding = 0.0;
        int riskRating = 1;
        Date maturity = new Date();
        Loan termLoan = Loan.createTermLoan(riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity);
    }



}
