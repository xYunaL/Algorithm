#include <stdio.h>

// 구조체 dat 정의
struct dat {
    int x;
    int y;
};
int main() {
    
    struct dat a[] = {{1, 2}, {3, 4}, {5, 6}};
    
    // pptr -> ptr -> a[0]
    struct dat* ptr = a;        // 배열의 시작 주소(a)를 담은 싱글 포인터(*) 선언
    struct dat** pptr = &ptr;   // "포인터 변수의 주소"를 담는 더블 포인터(**) 선언
    
    // (*pptr) => pptr 안에 저장된 주소로 찾아감 => 거기에는 ptr이 있음(역참조)
    // ptr[1] = ptr[2]
    // 포인터이름[인덱스] 문법은 배열처럼 주소 연산을 수행
    // 현재 ptr은 배열 a의 시작 주소를 가지고 있으므로 a[1] = a[2];
    (*pptr)[1] = (*pptr)[2];

    printf("%d 그리고 %d", a[1].x, a[1].y);
    
    return 0;
}
