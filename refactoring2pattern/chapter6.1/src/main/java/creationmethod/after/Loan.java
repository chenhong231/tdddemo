package creationmethod.after;

import java.util.Date;

public class Loan {

    private final int riskRating;
    private final Date maturity;
    private final Date expiry;
    private final CapitalStrategy capitalStrategy;
    private double commitment;
    private double outstanding;

    public Loan(double commitment, int riskRating, Date maturity, Date expiry) {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, int riskRating,
                Date maturity, Date expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding,
                int riskRating, Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;


        if(capitalStrategy == null) {
            if(expiry == null) {
                this.capitalStrategy = new CapitalStrategyTermLoan();
            } else if(maturity == null) {
                this.capitalStrategy = new CapitalStrategyRevolver();
            } else {
                this.capitalStrategy = new CapitalStrategyRCTL();
            }
        } else {
            this.capitalStrategy = capitalStrategy;
        }
    }

    public static Loan createTermLoan(double commitment, int riskRating, Date maturity) {
        return new Loan(commitment, 0.00, riskRating, maturity, null);
    }

    public static Loan createTermLoan(RiskAdjustedCapitalStrategy riskAdjustedCapitalStrategy, double commitment, double outstanding,
                                int riskRating, Date maturity) {
        return new Loan(riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity, null);
    }
}
