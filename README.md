# CMPS323 – Course Project (Spring 2024)

## Course Project

**CMPS323 - Design and Analysis of Algorithms**  
**Dr. Mohamed Saleh**  
**Eng. Alaa Hussein**  

---

### Team Members

- **Mohamed Elansari** – 202209852  
- **Abdulrahman Alshawabkeh** – 202108150  

---

## Proposed Solution

For the elevator optimization problem, we have adopted a Greedy approach. Although it may not yield the most optimal solution compared to dynamic programming, the Greedy approach offers a simpler and more straightforward algorithm construction.

The proposed solution operates as follows: When the maximum number of allowed stops (k) is less than the number of passengers, the algorithm looks ahead and determines the optimal floor to stop at from the current position. The optimal floor is chosen by comparing the distances to the next two passengers and selecting the floor that minimizes the total walking distance for those passengers.

If the maximum number of stops has been reached, the algorithm adds the distance between the last floor where the elevator stopped and the destination floor of each remaining passenger to the total walking distance.

This Greedy algorithm aims to find a near-optimal solution by making locally optimal choices at each step, with the goal of minimizing the overall walking distance for the passengers.

---

## Solution

### Assumptions:

- **k**: Maximum stops allowed  
- **wf**: Walked floors so far  
- **p**: Number of passengers  

### Explanation:

To expand more on the explanation in the proposal, the algorithm first checks if the number of stops and the number of passengers are equal. If they are, the elevator will deliver each passenger to their respective floor.

If **k** is less than **p**, the algorithm will need to determine which floors to stop at to optimize **wf**. The algorithm starts by going to the destination of the first passenger, and the stop is stored. It then compares the walked floors for the next two passengers from the current elevator floor. The elevator delivers the passenger with the greater walking floors, and the other passenger’s walked floors are added to **wf**. If **k** is reached, the difference between the rest of the passengers’ destinations and the last stop made is added to **wf**.

---

## Implementation:

We used an array to store the floors of passengers and another array to store the floors the elevator stopped at.  

The "Arrays" library is used to sort the list of passengers in ascending order with a dual-pivot quicksort, resulting in an `O(n log n)` complexity for sorting.

---

## Experimental Results and Screenshots

The algorithm gives a solution for every value of **k**, iterating **k** times where **k** is the length of the array `passengers`.

### Test:
- **Input**: `passengers = {27, 40, 60, 61}`  
- **Observation**: The algorithm does not always provide the best solution when there are 3 stops. It chooses stops `[27, 60, 61]`, resulting in 13 floors walked. A manual choice of stops `[27, 40, 60]` would result in only 1 floor walked. This demonstrates that greedy algorithms may not always yield the optimal solution.

---

## Complexity Analysis:

- **Sorting**: `O(n log n)`  
- **Iteration over passengers**: `O(n)`  
- **Total Complexity**: `O(n log n)`

---

## Discussion:

The proposed greedy approach provides an efficient solution to the elevator optimization problem, particularly when the number of passengers is large and the maximum allowed stops are limited. While locally optimal choices aim to minimize total walking distance, they may not always yield the globally optimal solution.

---

## Conclusion:

This project implemented a greedy algorithm to optimize elevator operations by minimizing total walking distance for passengers, subject to a constraint on the maximum allowed stops. The solution demonstrates efficiency and effectiveness in various test cases.

### Future Work:
- Explore dynamic programming algorithms to find better solutions.  
- Extend the problem to consider multiple elevators or more complex building layouts.
