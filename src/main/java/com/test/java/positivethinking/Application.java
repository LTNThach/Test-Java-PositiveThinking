package com.test.java.positivethinking;

import java.util.Arrays;
import java.util.List;

import static com.test.java.positivethinking.services.PartitionService.partition;

public class Application {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("List initial : " + list);

        System.out.println("Result with size = 2 : " + partition(list, 2));
        System.out.println("Result with size = 3 : " + partition(list, 3));
        System.out.println("Result with size = 1 : " + partition(list, 1));
    }
}
