package com.test.java.positivethinking.services;

import java.util.ArrayList;
import java.util.List;

public class PartitionService {

    private PartitionService() {
    }

    public static <T> List<List<T>> partition(List<T> list, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("The parameter size must be greater than 0.");
        }

        if (list.size() == 0) {
            throw new IllegalArgumentException("The parameter list must not be empty.");
        }

        if (size > list.size()) {
            throw new IllegalArgumentException("The parameter size must not be greater than the size of the list.");
        }

        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i += size) {
            List<T> subList = list.subList(i, Math.min(i + size, list.size()));
            result.add(subList);
        }

        return result;
    }
}
