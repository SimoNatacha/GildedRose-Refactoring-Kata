package com.gildedrose;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        for (Item item: items) {

//            get the simple name of the item object
            String className = item.getClass().getSimpleName();

            // Decrease the sell-in days and handle the quality update for all items except Sulfuras
            if (!className.equals("Sulfuras")) {

                Method reduceSellin = item.getClass().getMethod("reduceSellin");

                Method quality = item.getClass().getMethod("quality");

                //invoke reduceSellin method

                reduceSellin.invoke(item);

                //invoke quality method
                quality.invoke(item);

            }


        }
    }
}
