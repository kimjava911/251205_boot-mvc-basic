package kr.java.bootmvcbasic.model.form;

import kr.java.bootmvcbasic.model.entity.Member;
import kr.java.bootmvcbasic.model.entity.Post;
import lombok.Data;

@Data
public class PostForm {
    private String title;
    private String content;
    private Long memberId;

    public Post toEntity(Member member) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setMember(member);
        return post;
    }
}
