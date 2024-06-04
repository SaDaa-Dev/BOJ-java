package middleclass.lang.string.equals;

public class StringEqualsMain1 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";

        System.out.println(" == 비교 :" + (str1 == str2));
        System.out.println(" equals 비교 : " + (str1.equals(str2)));

        // 문자열 품
        // 문자열 리터럴일 경우 자바에서 문자열 풀을 활용 -> 문자열 풀에서 같은 문자열은 새로운 메모리를 생성하지 않고 기존에 있던 문자열을 참조하는 식
    }
}
