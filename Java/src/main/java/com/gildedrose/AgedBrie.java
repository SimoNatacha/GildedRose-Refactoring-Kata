package com.gildedrose;

import com.gildedrose.utils.Utils;

public class AgedBrie extends  SellinReducibleItem implements Utils {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void quality(){
        if(this.sellIn < 0){
            this.quality = addQualityWithThreshold(this.quality,2);
        }
        else{
            this.quality = addQualityWithThreshold(this.quality,1);
        }

    }
}
