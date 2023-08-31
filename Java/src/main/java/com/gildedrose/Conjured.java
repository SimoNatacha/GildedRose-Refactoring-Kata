package com.gildedrose;

import com.gildedrose.utils.Utils;

public class Conjured extends  SellinReducibleItem implements Utils {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void quality(){
        this.quality = subQualityWithThreshold(this.quality,2);

    }
}
