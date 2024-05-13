package org.ruu.developerkorea.domain.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestAppendPostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestUpdatePostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.ResponsePostWithCommentDTO;
import org.ruu.developerkorea.domain.board.service.PostService;
import org.ruu.developerkorea.global.error.ErrorType;
import org.ruu.developerkorea.global.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.ruu.developerkorea.global.response.ApiResponse.error;

@RestController
@Tag(name = "POST API")
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @Operation(summary = "게시글 작성", description = "유저가 게시글을 저장합니다.")
    public ApiResponse<String> createPost(RequestAppendPostDTO requestAppendPostDTO) {
        Long postNumber = postService.createPost(requestAppendPostDTO);
        return ApiResponse.success("true");
    }

    @PutMapping("/{id}")
    @Operation(summary = "게시글 수정", description = "유저가 게시글을 수정합니다.")
    public ApiResponse<String> updatePost(@PathVariable Long id, @RequestBody RequestUpdatePostDTO requestUpdatePostDTO) {
        requestUpdatePostDTO.setId(id);
        Long postNumber = postService.updatePost(requestUpdatePostDTO);
        return ApiResponse.success("true");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "유저가 게시글을 삭제합니다.")
    public ApiResponse<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ApiResponse.success("true");
    }

    //Todo 보여주는 view라서 나중에 SPA로 변경할 경우 사용.
    @Operation(summary = "게시글 조회", description = "누구나 게시글을 조회할 수 있습니다.")
    @GetMapping("/{id}")
    public ApiResponse<ResponsePostWithCommentDTO> selectOnePost(
            @RequestParam final String boardUrl,
            @PathVariable final Long id) {
        ResponsePostWithCommentDTO posts = postService.findPostById(id, boardUrl);

        return ApiResponse.success(posts);
    }
}
