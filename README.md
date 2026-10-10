# CIT300 Data Structure and Graph Performance Analyzer — Project 02

## Description

Standalone integrated Java console application demonstrating data structures, search algorithms, graph traversal, and performance observations. All project implementations are under this folder; no class is imported from a member folder.

## Team Members

| Member | Name | Student ID | Responsibility |
| --- | --- | --- | --- |
| Member 1 | Thahiya | 23DA2-1151 | Array and Searching |
| Member 2 | Ashadha | 23DA2-612 | Stack and Queue |
| Member 3 | Hamthani | 23DA2- | Linked List |
| Member 4 | Athnan | 23DA2-0490 | Graph, BFS, DFS, Integration |

Update names, IDs, and contribution claims with the actual team details before submission.

## Individual Contributions

Member responsibilities follow the project division: Thahiya — Array and Searching; Ashadha — Stack and Queue; Hamthani — Linked List; Athnan — Graph, BFS, DFS, and integration. This integrated folder contains independent implementations of every component.

## Technologies

Java standard library only; Git and GitHub are intended for version control and collaboration.

## Features

- Array insert, delete, search, display
- Stack push, pop, peek, display
- Queue enqueue, dequeue, peek/front, display
- Singly linked-list insert, delete, search, display
- Linear search and sorted-data binary search
- Undirected graph vertex/edge management, display, BFS, and DFS
- Comparison counts, search results, traversal results, and measured elapsed times
- Input validation and empty/full/missing-item handling

## Architecture and Folder Structure

`src/Main.java` is the integrated entry point. Packages under `src/` separate Array, Stack, Queue, LinkedList, Searching, Graph, and Performance responsibilities. The custom array, stack, queue, list, and graph storage are implemented in project code; standard Java utilities also support sorting, graph traversal bookkeeping/results, and console input.

## Data Structures and Complexity

- Array: append O(1) while capacity remains; indexed deletion O(n); search O(n); storage O(n).
- Stack: push/pop/peek O(1); storage O(n).
- Circular queue: enqueue/dequeue/peek O(1); storage O(n).
- Singly linked list: append/delete/search/display O(n); size/isEmpty O(1); storage O(n).
- Linear search: O(n) time, O(1) extra space.
- Binary search: O(log n) time, O(1) extra space on sorted input. The app sorts a copy first; sorting is excluded from the search timer and has O(n log n) time.
- Graph BFS/DFS: O(V + E) time and O(V) auxiliary space for the traversal.

## Performance Comparison

The analyzer reports search results, comparison counts, nanosecond timing, and BFS/DFS traversal lists and elapsed time. Timing varies with input size, system conditions, and implementation. The measured binary-search interval excludes the preceding copy and sort. Graph traversal starts from the user-selected vertex and covers its connected component.

## Input Validation

Menu choices and integer values are parsed with retry prompts. Index ranges, empty/full structures, duplicate/missing vertices, invalid traversal starts, and missing values are checked before operations.

## Testing

**PASS — manual Phase 7 scenarios:** all member modules and the integrated application compiled. Console scenarios exercised data-structure operations, search hits/misses and comparison counts, empty/full/missing states, graph operations and traversals, performance output, and invalid numeric/menu/index inputs. These were manual checks, not an automated test suite. After a small graph adjacency-index refinement, the Final-Project sources were recompiled and its graph display/BFS/DFS scenario was rerun successfully.

## Compilation and Running

From `Project-Folder/`:

```bash
javac -d out src/Main.java src/Array/*.java src/Stack/*.java src/Queue/*.java src/LinkedList/*.java src/Searching/*.java src/Graph/*.java src/Performance/*.java
java -cp out Main
```

Optional standalone performance example:

```bash
java -cp out Performance.PerformanceMain
```
