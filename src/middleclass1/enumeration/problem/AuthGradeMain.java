package middleclass1.enumeration.problem;

public class AuthGradeMain {
    public static void main(String[] args) {
        for (AuthGrade grade : AuthGrade.values()) {
            grade.getInfo(grade);
        }
    }
}
