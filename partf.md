# Complexity of Quick Sort

The average time complexity of quick sort is O(N log(N)).

The derivation is based on the following notation:
T(N) = Time Complexity of Quick Sort for input of size N.

At each step, the input of size N is broken into two parts say J and N-J.

T(N) = T(J) + T(N-J) + M(N)
