package 정보처리기사_실기;

enum Tri {
    A("A"), 
    B("AB"), 
    C("ABC");
    private String code;
    Tri(String code) {
        this.code = code;
    }
    public String code() {
        return code;
    }
}

class _2025_3_06 {
    public static void main(String[] args) {
        Tri t = Tri.values()[Tri.A.name().length()];
        System.out.print(t.code());
    }
}
