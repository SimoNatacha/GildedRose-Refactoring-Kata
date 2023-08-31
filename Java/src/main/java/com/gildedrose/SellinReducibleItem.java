package com.gildedrose;

abstract class SellinReducibleItem extends Item {
    public SellinReducibleItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void reduceSellin() {
         sellIn =  sellIn - 1; // Assuming "sellin" is a property in Item class
    }
}
