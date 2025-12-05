package kr.java.bootmvcbasic.model.form;

import kr.java.bootmvcbasic.model.entity.Member;
import lombok.Data;

@Data
public class MemberForm {
    private String username;
    private String email;

    // 폼 데이터를 Entity 변환
    public Member toEntity() {
        Member member = new Member();
        member.setUsername(username);
        member.setEmail(email);
        return member;
    }
}
