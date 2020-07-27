package com.sak.webservice.service;

import com.sak.webservice.domain.posts.PostsRepository;
import com.sak.webservice.dto.PostsMainResponseDto;
import com.sak.webservice.dto.PostsSaveRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(posts -> new PostsMainResponseDto(posts))
                .collect(Collectors.toList());
    }

}
