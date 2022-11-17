package gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{ new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sell_date_has_passed() {
        Item[] items = new Item[]{ new Item("foo", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void qualityOfItemIsNeverNegative() {
        Item[] items = new Item[]{ new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrieIncreasesInQualityTheOlderItGets() {
        Item[] items = new Item[]{ new Item("Aged Brie", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void qualityOfAgedBrieIsNeverMoreThan50() {
        Item[] items = new Item[]{ new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityOfAnyOtherItemIsNeverMoreThan50() {
        Item[] items = new Item[]{ new Item("Any other item", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void qualityOfSulfurasNeverChanges() {
        Item[] items = new Item[]{ new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasIsNeverSold() {
        Item[] items = new Item[]{ new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void qualityOfBackstagePassesIncreasesForTwoWhenSellInApproaches() {
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33, app.items[0].quality);
    }
}