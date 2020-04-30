package com.hehe.Comparable;

import java.util.Comparator;

public class _PersonComparator implements Comparator<_PersonComparator> {
    @Override
    public int compare(_PersonComparator o1, _PersonComparator o2) {
        return o1.hashCode();
    }

    @Override
    public Comparator<_PersonComparator> reversed() {
        return null;
    }
}
