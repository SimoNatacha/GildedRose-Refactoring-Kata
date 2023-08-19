package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    private int subQualityWithThreshold(int quality, int value) {
        return Math.max(0, quality - value);
    }
    private int addQualityWithThreshold(int quality, int value) {
        return Math.min(50, quality + value);
    }
    public void updateQuality() {
        List<String> specialItems = new ArrayList<>(Arrays.asList("Aged Brie","Sulfuras, Hand of Ragnaros","Backstage passes to a TAFKAL80ETC concert"));

        for (Item item: items) {
            // Decrease the sell-in days for all items except Sulfuras
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }
            // Check if the sell-in days have passed
            if (item.sellIn < 0) {
                if(!specialItems.contains(item.name) && item.quality > 0){
                    // Decrease quality for non-special items that have not expired
                    item.quality = subQualityWithThreshold(item.quality,2 );
                }
                if (item.name.equals("Aged Brie")  && (item.quality < 50) ){
                    // Increase quality for Aged Brie even after sell-in days have passed
                    item.quality = addQualityWithThreshold(item.quality,2);
                }
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                    // Backstage passes quality drops to 0 after the concert
                    item.quality = 0;
                }
            }
            else {
                if(!specialItems.contains(item.name) && item.quality > 0){
                    // Decrease quality for non-special items that haven't expired yet
                    if (item.name.equals("Conjured Mana Cake")){
                        item.quality = subQualityWithThreshold(item.quality,2 );
                    }
                    else {
                        item.quality--;
                    }
                }
                else {
                    if (item.quality < 50) {
                        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") ){
                            // Adjust quality for Backstage passes based on remaining sell-in days
                            if (item.sellIn < 6) {
                                item.quality = addQualityWithThreshold(item.quality,3);
                            }
                            else if (item.sellIn < 11) {
                                item.quality = addQualityWithThreshold(item.quality,2 );
                            }
                            else{
                                item.quality = addQualityWithThreshold(item.quality,1 );
                            }
                        }
                        else {
                            // Regular items increase in quality by 1
                            item.quality = addQualityWithThreshold(item.quality,1);
                        }
                    }
                }

            }
        }
    }
}
