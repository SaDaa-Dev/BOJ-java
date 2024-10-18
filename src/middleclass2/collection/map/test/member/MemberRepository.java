package middleclass2.collection.map.test.member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
    private Map<String, Member> members = new HashMap<>();


    public void save(Member member) {
        members.put(member.getId(), member);
    }
    public Member findById(String id) {
        for (Map.Entry<String, Member> entry : members.entrySet()) {
            if (entry.getKey().equals(id)) {
                return members.get(id);
            }
        }

        return null;
    }

    public Member findByName(String name){
        for (Map.Entry<String, Member> entry : members.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void remove(String id) {
        members.remove(id);
    }
}
