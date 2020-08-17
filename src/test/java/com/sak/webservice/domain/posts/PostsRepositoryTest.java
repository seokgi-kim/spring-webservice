package com.sak.webservice.domain.posts;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        /**
         * 이후 테스트 코드에 영향을 끼치지 않기 위해
         * 테스트 메서드가 끝날때마다 repository 전체 비우는 코드
         */
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기 () throws Exception {

        // given
        postsRepository.save(Posts.builder()
                    .title("테스트 게시글")
                    .content("테스트 본문")
                    .author("seokgi4885@gmail.com")
                    .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
//        assertEquals(posts.getTitle(),"테스트 게시글");
//        assertEquals(posts.getContent(), "테스트 본문");

    }

    @Test
    public void BaseTimeEntity_등록() throws Exception {

        // given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                            .title("테스트 게시글")
                            .content("테스트 본문")
                            .author("seokgi4885@gmail.com")
                            .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
//        assertTrue(posts.getCreatedDate().isAfter(now));
//        assertTrue(posts.getModifiedDate().isAfter(now));

    }
}