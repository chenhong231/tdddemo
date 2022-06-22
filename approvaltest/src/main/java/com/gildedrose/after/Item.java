package com.gildedrose.after;

public class Item {
    public String name;

    public int sellIn;

    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        if("Sulfuras, Hand of Ragnaros".equals(name)) {
            return new Sulfuras(sellIn, quality);
        }

        if("Backstage passes to a TAFKAL80ETC concert".equals(name)) {
            return new BackstagePass(sellIn, quality);
        }

        if("Aged Brie".equals(name)) {
            return new AgedBrie(sellIn, quality);
        }
        return new Item(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void passOneDay() {
        updateQuality();
        updateSellInDays();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateSellInDays() {
        sellIn = sellIn - 1;
    }

    protected void updateQualityAfterExpiration() {
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    protected void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
