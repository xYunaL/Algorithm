#include <stdio.h>
int main() {
    int x=7, y=4, z;
    
    z = y % 3 < 3 ? 2:1;
    printf("%d \n", z);
    
    z = z & z >> 1;
    printf("%d \n", z);
    
    z = x > 5 && z <= 3 ? z*x : z/x;
    printf("%d \n", z);
    
    return 0;
}