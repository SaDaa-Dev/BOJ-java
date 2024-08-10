package middleclass.enumeration.problem;

public enum AuthGrade {
    GUEST(1, "손님"), LOGIN(2, "로그인 회원"), ADMIN(3, "관리자");
    private final int level;
    private final String description;

    AuthGrade(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public void getInfo(AuthGrade grade) {
        System.out.println(grade.description + "의 레벨은 " + grade.level + "입니다.");
    }

}
