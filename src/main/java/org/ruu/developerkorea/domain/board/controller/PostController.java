package org.ruu.developerkorea.domain.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestAppendPostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestUpdatePostDTO;
import org.ruu.developerkorea.domain.board.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "POST API")
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @Operation(summary = "게시글 작성", description = "유저가 게시글을 저장합니다.")
    public ResponseEntity<String> post(@RequestBody RequestAppendPostDTO requestAppendPostDTO) {
        Long postNumber = postService.createPost(requestAppendPostDTO);
        if(postNumber == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("true");
    }

    @PutMapping("/{id}")
    @Operation(summary = "게시글 수정", description = "유저가 게시글을 수정합니다.")
    public ResponseEntity<String> patch(@PathVariable Long id, @RequestBody RequestUpdatePostDTO requestUpdatePostDTO) {
        requestUpdatePostDTO.setId(id);
        Long postNumber = postService.updatePost(requestUpdatePostDTO);
        if(postNumber == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("true");
    }
}
