
public class Main2 {
    public static class Parent {
        public int x(int i) {return i+2;}
        public static String id() {return "P";}
    }
    public static class Child extends Parent {
        // Parent의 x 함수 오버라이딩(재정의)
        public int x(int i) {return i+3;}
        // 기존 x(int)와 이름은 같지만 매개변수 타입이 다르므로 오버로딩(중복정의)
        public String x(String s) {return s+"R";}
        // Parent의 id() 함수 오버라이딩(재정의)
        public static String id() {return "C";}
    }
    public static void main(String[] args) {
        Parent ref = new Child();
        // ref.x(2)는 Child의 x(int)가 호출됨.
        // id()는 static이 붙은 정적 메서드이므로 실제 어떤 객체가 들어있는지 전혀 상관하지 않고, 
        // 참조 변수 ref가 선언될 당시의 타입인 Parent 클래스의 id()를 곧바로 실행
        System.out.println(ref.x(2) + ref.id());
    }
}
// static으로 정적 바인딩을 하면 static 메서드는 오버라이딩되지 않고 하이딩(Hiding, 은폐)됩니다.