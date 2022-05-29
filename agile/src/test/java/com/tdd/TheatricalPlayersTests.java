package com.tdd;

import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.approvaltests.Approvals.verify;

@UseReporter(JunitReporter.class)
public class TheatricalPlayersTests {

    @Test
    public void exampleStatement() {
        List<Performance> performances = new ArrayList();
        performances.add(new Performance(new Play("Hamlet", "tragedy"), 55));
        performances.add(new Performance(new Play("As You Like It", "comedy"), 35));
        performances.add(new Performance(new Play("Othello", "tragedy"), 40));

        Invoice invoice = new Invoice("BigCo", performances);

        TheatricalPlayers theatricalPlayers = new TheatricalPlayers(new TotalAmountCalculator(), new VolumeCreditsCalculator(), new ResultFormatter());

        String result = theatricalPlayers.print(invoice);

        verify(result);
    }
}