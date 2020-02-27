package cc.lasmgratel.foodcraftreloaded.common.util;

import java.awt.*;

@FunctionalInterface
public interface Colorable {
    Color getColor();

    default int getColor(int tintIndex) {
        return tintIndex == 0 ? getColor().getRGB() : -1;
    }
}