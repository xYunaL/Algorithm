public class Main {
    static interface F {
        // 추상 메서드
        // throws Exception을 붙여 이 메서드를 구현하는 람다식 내부에서 예외를 던질 수 있게한다.
        int apply(int x) throws Exception;
    }    
    public static int run(F f) {    // 인터페이스 F를 구현한 람다식을 매개변수로 받음
        try {
            return f.apply(3);   // apply를 호출함으로서 람다식을 실행함
        } catch (Exception e) {
            return 7;
        }
    }

    public static void main(String[] args) {
        // 람다식은 호출되어야 실행된다.
        F f = (x) -> {      // 람다식 선언(실행 X)
        if (x>2) {
            throw new Exception();
        }
        return x*2;
    };
    System.out.print(run(f) + run((int n) -> n + 9));
    // 1. run(f)
    // run(f)를 호출하면서 람다식f 전달
    // run 내부에서 f.apply(3)이 실행되면서 인자값 3이 대입된 채로 람다식 실행
    // run(f)은 Exception에 걸리면서 return 7;

    // 2. run((int n) -> n + 9)
    // 이번에는 미리 정의했던 f를 변수에 담지 않고 직접 매개변수에 람다식을 정의해서 넘겨줌.
    // 따라서 f.apply(3)이 실행될 때, int n에 3이 대입됨.
    // 람다식 로직에 따라 3 + 9 = 12 반환 (예외 X)
}
}
