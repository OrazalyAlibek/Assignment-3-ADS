# Assignment 3: Sorting and Searching Algorithm Analysis System

## A. Project Overview

This project implements and compares three algorithms: Bubble Sort, Merge Sort, and Binary Search to analyze their real-world performance.

**Selected algorithms:**

| Category | Algorithm | Time Complexity |
|---|---|---|
| Basic Sort | Bubble Sort | O(n²) |
| Advanced Sort | Merge Sort | O(n log n) |
| Search | Binary Search | O(log n) |

**Purpose:** Measure and compare execution times across different array sizes (small/medium/large) and input types (random/sorted), and verify whether real results match theoretical Big-O complexity soon.

---

## B. Algorithm Descriptions

### Bubble Sort
Repeatedly compares adjacent elements and swaps them if they are in the wrong order. After each complete pass, the largest unsorted element returns to its correct position.

- **Best case:** O(n) — array already sorted
- **Average / Worst case:** O(n²)

### Merge Sort
A divide-and-conquer algorithm. Splits the array in half recursively until each part has one element, then merges the parts back together in sorted order.

- **All cases:** O(n log n)

### Binary Search
Works on a **sorted** array. Checks the middle element — if it matches the target, returns the index. If the target is smaller, searches the left half; if larger, searches the right half. Each step cuts the search space in half.

- **Best case:** O(1) — target is the middle element
- **Average / Worst case:** O(log n)

---

## C. Experimental Results

> Times are in nanoseconds (ns). Results may vary between runs.

### Sorting — Random Arrays

| Array Size | Bubble Sort (ns) | Merge Sort (ns) |
|---|---|---|
| 10 | 6,667 | 10,625 |
| 100 | 127,875 | 52,000 |
| 1,000 | 4,656,667 | 114,833 |

### Sorting — Already Sorted Arrays

| Array Size | Bubble Sort (ns) | Merge Sort (ns) |
|---|---|---|
| 10 | 3,958 | 9,375 |
| 100 | 80,333 | 48,458 |
| 1,000 | 871,291 | 70,083 |

### Binary Search

| Array Size | Time (ns) | Found at index |
|---|---|---|
| 10 | 4,333 | 5 |
| 100 | 625 | 50 |
| 1,000 | 1,917 | 500 |

---

## D. Screenshots
> Add screenshots to docs/screenshots/

## E. Analysis

1. Which sorting algorithm performed faster? Why?**
Merge Sort was significantly faster on large arrays. On 1,000 elements, Bubble Sort took ~4,6 million ns while Merge Sort took ~114,000 ns - about 40× faster. This matches theory: Bubble Sort does ~1,000,000 comparisons (n²), Merge Sort does ~10,000 (n log n).

2. How does performance change with input size?**
Bubble Sort grows quadratically - 10× more elements means ~100× more time. Merge Sort grows much slower - 10× more elements means only ~10× more time. Binary Search barely changes at all across sizes.

3. How does sorted vs unsorted data affect performance?**
Bubble Sort on 1,000 sorted elements took ~870,000 ns vs ~4,6 million ns on random data - a 5,2× difference. This is because in a sorted array there are far fewer swaps needed. Merge Sort shows less difference since it always divides and merges regardless of input order.

4. Do the results match expected Big-O complexity?**
Yes. Bubble Sort's ~400× slowdown from size 100 to 1,000 is close to the expected 100× for O(n²) (with some JVM overhead). Merge Sort's ~12× slowdown matches O(n log n). Binary Search's nearly flat times match O(log n).

5. Which searching algorithm is more efficient? Why?**
Binary Search is very efficient even for 1,000 elements it takes at most 10 comparisons (log₂ 1000 ≈ 10). Linear Search would require up to 1,000 comparisons in the worst case.

6. Why does Binary Search require a sorted array?**
At each step, Binary Search discards half the array based on whether the target is greater or less than the middle element. This logic only works if the array is ordered - in an unsorted array, discarding half the elements could mean throwing away the target.

---

## F. Reflection

Working on this project made the difference between O(n²) and O(n log n) very real. Seeing Bubble Sort take 4,6 million nanoseconds on 1,000 elements while Merge Sort finished in under 115,000 was much more convincing than looking at formulas. It also showed that input type matters - Bubble Sort on a sorted array was 5× faster than on a random one, which is a detail that Big-O notation alone doesn't tell you.

The main challenge was making sure timing measurements were fair - each algorithm needs a fresh copy of the array, otherwise a previously sorted array gives Bubble Sort an unfair advantage. Another thing I noticed is that for very small arrays (10 elements), Bubble Sort and Merge Sort had similar times, and sometimes Bubble Sort was even faster. This makes sense because Merge Sort has overhead from creating sub-arrays, which matters more when the array is tiny.

---

## Repository Structure

```
assignment3-sorting-searching/
├── src/
│   ├── Sorter.java
│   ├── Searcher.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   └── screenshots/
├── README.md
└── .gitignore
```

## Commit History

```
init: project structure and base files
feat(sorter): implemented Bubble Sort and Merge Sort
feat(searcher): implemented Binary Search
feat(experiment): added nanoTime performance measurement
feat(main): connected all classes and demo output
docs(readme): added analysis and results
perf(cleanup): improved code readability
```
