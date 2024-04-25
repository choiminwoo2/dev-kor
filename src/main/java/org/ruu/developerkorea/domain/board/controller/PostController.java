package org.ruu.developerkorea.domain.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestAppendPostDTO;
import org.ruu.developerkorea.domain.board.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "POST API")
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @Operation(summary = "게시글 작성", description = "유저가 게시글을 저장합니다.")
    public ResponseEntity<String> post(@RequestBody RequestAppendPostDTO requestAppendPostDTO) {
        Long post = postService.createPost(requestAppendPostDTO);
        if(post == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post.toString());
    }
}
