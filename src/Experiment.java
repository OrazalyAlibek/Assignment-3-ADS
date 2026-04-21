package src;

import java.util.Arrays;

public class Experiment {

    private Sorter sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }

        return System.nanoTime() - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - start;
    }

    public void runAllExperiments() {
        System.out.println("\n=== SORTING EXPERIMENTS ===\n");

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            int[] arr1 = sorter.generateRandomArray(size);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            long bubbleTime = measureSortTime(arr1, "basic");
            long mergeTime  = measureSortTime(arr2, "advanced");

            System.out.println("Size: " + size + " | Random array");
            System.out.println("  Bubble Sort: " + bubbleTime + " ns");
            System.out.println("  Merge Sort:  " + mergeTime + " ns");

            int[] sorted1 = Arrays.copyOf(arr1, arr1.length);
            int[] sorted2 = Arrays.copyOf(arr1, arr1.length);

            long bubbleSortedTime = measureSortTime(sorted1, "basic");
            long mergeSortedTime  = measureSortTime(sorted2, "advanced");

            System.out.println("Size: " + size + " | Sorted array");
            System.out.println("Bubble Sort: " + bubbleSortedTime + " ns");
            System.out.println("Merge Sort:  " + mergeSortedTime + " ns");
            System.out.println();
        }

        System.out.println("\n=== SEARCH EXPERIMENTS ===\n");

        for (int size : sizes) {
            int[] arr = sorter.generateRandomArray(size);
            Arrays.sort(arr);

            int target = arr[size / 2];
            long searchTime = measureSearchTime(arr, target);
            int index = searcher.search(arr, target);

            System.out.println("Size: " + size + " | Target: " + target);
            System.out.println("  Binary Search: " + searchTime + " ns | Found at index: " + index);
            System.out.println();
        }
    }
}