package programmers.level2.prac;

public class NormalSquare {
    private long solution(int w, int h){
        long W = (long) w;
        long H = (long) h;
        long gcd = gcd(w, h);
        return w * h - ((w + h) - gcd);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {


    }
}
