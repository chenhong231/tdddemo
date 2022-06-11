package com.gildedrose.after;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {

    @Test
    public void updateQuality() {

        CombinationApprovals.verifyAllCombinations(
                this::doUpateQuality,
                new String[] {"foo","Aged Brie","Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"},
                new Integer[] {-1, 0, 2, 6, 11},
                new Integer[] {0, 1, 49, 50}
        );

    }

    private String doUpateQuality(String name, int sellIn, int quality) {
        Item [] items = new Item[] {Item.createItem(name, sellIn, quality)};
        GildedRose rose = new GildedRose(items);
        rose.updateQuality();
        final String itemString = rose.items[0].toString();
        return itemString;
    }
}
