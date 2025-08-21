# Data-Structure-Problems
### Why?
1. manages and organise the data
2. efficient way to resolve the problem

### Type
1. Array
2. Linked List
3. Stack
4. Queue
5. Trees
6. Graph
7. Heap
8. Hash Table

## Big O notation
it is mathematical symbol used to describe the upper or wrost-case time complexity of an algorithm. e.g. for constant
Linear Search

    T(n) = O(f(n)) , T(n) <= cf(n) , n >= n0 , c is a constant 
    n^2 < nlog(n) < n < log(n) < 1
O log(n) binary serach : after each iteration, size reduced to half

    def binary_search(arr, target)
    left=0, right= len(arr)-1
    while left<=right:
        mid = (left +right)/2
        if arr[mid] == target
            return mid
        else if arr[mid] < target 
            left = mid +1
        else 
            right = mid - 1
    return -1 // if not available in arr

### Analyzing Algorithm Efficiency
it is mainly depend on time and space, as in today's time space is not that much of concern so it's mainly depend on time

1. Array Traversal
   Algo: Sum of elements in an array
   Efficiency: O(n)
2. linklist Traversal
   Algo: Sum of elements in an array
   Efficiency: O(n)
3. Binary Search in Sorted Array: O log(n)
4. Hash Table lookup : O(1) retrieving an element from hashtable (assuming a good hash function and collision resolution mechanism)
5. Bubble sort O(n^2)

### Asymptotic Analysis
#### Brute Force Algorithm

### Space complexity
It represents how much additional space you need as input size increases.
1. constant Space complexity O(1)
2. Linear Space complexity O(n)
3. Wxponential space Complexity O(2^n) , algo with multiple recursive branches.
4. Polynomial Space complexity O(n^k) : K is constant, often seen in nested loop.

for finding the max value, and it's index in an n-length array, you need 2 additional variable other than the input array,
if this n increases, you still need 2 additional variable, hence space complexuty will be constant i.e O(1)