#include <bits/stdc++.h>
using namespace std;


// Change the functions to take a flag “order” as argument. This order can be „d‟ or „a‟ for  descending and ascending respectively. The function will sort the array in descending and  ascending order depending on the flag value. 
// Print the sorted array.
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

// sort array ascending order

