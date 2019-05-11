package com.zhaw.ch.skill7.helper;

import java.util.List;

public final class MathHelper {

    private MathHelper() {
    }

    public static int calculateMedian(List<Integer> m) {
        int middle = m.size() / 2;
        if (m.size() % 2 == 1) {
            return m.get(middle);
        } else {
            return (m.get(middle - 1) + m.get(middle)) / 2;
        }
    }
}