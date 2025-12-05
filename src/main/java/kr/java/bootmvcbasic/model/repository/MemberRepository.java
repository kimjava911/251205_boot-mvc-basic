package kr.java.bootmvcbasic.model.repository;

import kr.java.bootmvcbasic.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
