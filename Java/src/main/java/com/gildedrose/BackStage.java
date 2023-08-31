package com.gildedrose;

import com.gildedrose.utils.Utils;

public class BackStage extends  SellinReducibleItem implements Utils {
    public BackStage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void quality(){
        if(this.sellIn < 0){
            this.quality = 0;
        }
        else{
            if (this.sellIn < 6) {
                this.quality = addQualityWithThreshold(this.quality,3);
            }
            else if (this.sellIn < 11) {
                this.quality = addQualityWithThreshold(this.quality,2 );
            }
            else{
                this.quality = addQualityWithThreshold(this.quality,1 );
            }
        }
    }
}
