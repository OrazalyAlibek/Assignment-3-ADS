package src;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment(sorter, searcher);

        System.out.println("\n=== DEMO (10 elements) ===\n");

        int[] small = sorter.generateRandomArray(10);
        System.out.print("Original: ");
        sorter.printArray(small);

        int[] forBubble = Arrays.copyOf(small, small.length);
        sorter.basicSort(forBubble);
        System.out.print("Bubble Sort: ");
        sorter.printArray(forBubble);

        int[] forMerge = Arrays.copyOf(small, small.length);
        sorter.advancedSort(forMerge);
        System.out.print("Merge Sort:  ");
        sorter.printArray(forMerge);

        int target = forMerge[5];
        int result = searcher.search(forMerge, target);
        System.out.println("\nBinary Search | Target: " + target + " | Index: " + result);

        System.out.println("\n");

        experiment.runAllExperiments();
    }
}
