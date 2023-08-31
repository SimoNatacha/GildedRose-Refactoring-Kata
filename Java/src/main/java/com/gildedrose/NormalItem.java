package com.gildedrose;

import com.gildedrose.utils.Utils;

public class NormalItem extends  SellinReducibleItem implements Utils {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    public void quality(){
        if(this.sellIn < 0){
            this.quality = subQualityWithThreshold(this.quality,2);
        }
        else{
            this.quality = subQualityWithThreshold(this.quality,1);
        }
    }
}
