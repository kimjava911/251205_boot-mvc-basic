package kr.java.bootmvcbasic.model.repository;

import kr.java.bootmvcbasic.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
