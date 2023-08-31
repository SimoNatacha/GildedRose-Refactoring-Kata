package com.gildedrose.utils;

public interface Utils {
    public default int subQualityWithThreshold(int quality, int value) {
        return Math.max(0, quality - value);
    }
    public default int addQualityWithThreshold(int quality, int value) {
        return Math.min(50, quality + value);
    }
    void quality();
}
