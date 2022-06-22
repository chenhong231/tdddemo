package com.gildedrose.after;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] {Item.createItem("foo", 0, 0)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.passOneDay();
        assertEquals("foo", gildedRose.items[0].name);
    }

    @Test
    public void testName() {
        Item[] items = new Item[] {Item.createItem("foo", 0, 0)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.passOneDay();
        Approvals.verify(gildedRose.items[0].name);
    }

    @Test
    public void updateQuality() {
        Item[] items = new Item[] {Item.createItem("foo", 0, 0)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.passOneDay();
        Approvals.verify(gildedRose.items[0].toString());
    }

    @Test
    public void combinationApproval() {

        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality,
                new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
                new Integer[]{-1, 0, 2, 6, 11},
                new Integer[]{0, 1, 49, 50});
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] {Item.createItem(name, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.passOneDay();
        final String itemString = gildedRose.items[0].toString();
        return itemString;
    }
}
