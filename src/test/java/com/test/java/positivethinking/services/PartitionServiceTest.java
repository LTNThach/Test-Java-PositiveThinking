package com.test.java.positivethinking.services;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.test.java.positivethinking.services.PartitionService.partition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PartitionServiceTest {

    @Test
    public void partition_shouldReturnCorrectList_whenGivenListAndSizeIsValid() {
        // Given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int size3 = 3;
        int size2 = 2;
        int size1 = 1;

        // When
        List<List<Integer>> result3 = partition(list, size3);
        List<List<Integer>> result2 = partition(list, size2);
        List<List<Integer>> result1 = partition(list, size1);

        // Then
        assertEquals("[[1, 2, 3], [4, 5]]", result3.toString());
        assertEquals("[[1, 2], [3, 4], [5]]", result2.toString());
        assertEquals("[[1], [2], [3], [4], [5]]", result1.toString());
    }

    @Test
    public void partition_shouldThrowError_WhenGivenSizeIsInvalid() {
        // Given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int size0 = 0;
        int negativeSize = -2;
        int bigSize = 9;

        // When + Then
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> partition(list, size0));
        assertEquals("The parameter size must be greater than 0.", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> partition(list, negativeSize));
        assertEquals("The parameter size must be greater than 0.", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> partition(list, bigSize));
        assertEquals("The parameter size must not be greater than the size of the list.", exception3.getMessage());
    }

    @Test
    public void partition_shouldThrowError_WhenGivenListIsEmpty() {
        // Given
        List<Integer> list = new ArrayList<>();
        int size = 2;

        // When + Then
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> partition(list, size));
        assertEquals("The parameter list must not be empty.", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> partition(Collections.emptyList(), size));
        assertEquals("The parameter list must not be empty.", exception2.getMessage());
    }
}
