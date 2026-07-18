public class _2025_2_04 {
    public static void change(String[] data, String s) {
        data[0] = s;
        s = "Z";
    }
    public static void main(String[] args) {
        // 힙 영역에 생성된 배열(["A"])의 주소값을 가짐
        String data[] = { "A" };
        // 힙 영역의 문자열 상수 풀에 있는 "B"의 주소값(예: 0x200)을 가짐
        String s = "B";
        change(data, s);
        System.out.print(data[0] + s);
    }
}