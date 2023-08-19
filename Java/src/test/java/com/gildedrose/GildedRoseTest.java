package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    public void testUpdateAddQuality() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 5, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Conjured Mana Cake", 5, 10),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", -10, 10),
            new Item("Elixir of the Mongoose", 5, 7),


        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(11, items[0].quality);
        assertEquals(12, items[1].quality);
        assertEquals(80, items[2].quality);
        assertEquals(8, items[3].quality);
        assertEquals(80, items[4].quality);
        assertEquals(0, items[5].quality);
        assertEquals(6, items[6].quality);

    }

    @Test
    public void testUpdateSubtractionQuality() {
        Item[] items = new Item[]{
            new Item("Aged Brie", -1, 19),
            new Item("Conjured Mana Cake", -5, 9),
            new Item("Elixir of the Mongoose", -5, 2),
        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(21, items[0].quality);
        assertEquals(7, items[1].quality);
        assertEquals(0, items[2].quality);
    }
}
