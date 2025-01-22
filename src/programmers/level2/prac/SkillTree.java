package programmers.level2.prac;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            if(isCan(skill, skillTree)){
                answer++;
            }
        }
        return answer;
    }

    private boolean isCan(String skill, String skillTree) {
        StringBuilder filtered = new StringBuilder();
        for (char c : skillTree.toCharArray()) {
            if (skill.indexOf(c) != -1) {
                filtered.append(c);
            }
        }

        for (int i = 0; i < filtered.length(); i++) {
            if (filtered.charAt(i) != skill.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SkillTree problem = new SkillTree();
        System.out.println(problem.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
