package org.ruu.developerkorea.domain.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestAppenderCommentDTO;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestUpdateCommentDTO;
import org.ruu.developerkorea.domain.board.model.dto.comment.ResponseCommentDTO;
import org.ruu.developerkorea.domain.board.service.CommentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "COMMENT API")
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "댓글을 등록합니다", description = "사용자가 댓글을 등록합니다.")
    public ResponseEntity<ResponseCommentDTO> insertComment(
            @RequestBody RequestAppenderCommentDTO requestAppenderCommentDTO){
        ResponseCommentDTO resultId = commentService.insertComment(requestAppenderCommentDTO);
        return ResponseEntity.ok(resultId);
    }

    @PatchMapping
    @Operation(summary = "댓글을 수정합니다.", description = "사용자가 댓글을 수정합니다.")
    public ResponseEntity updateComment(
            @RequestBody RequestUpdateCommentDTO requestUpdateCommentDTO){
        Long resultId = commentService.updateComment(requestUpdateCommentDTO);
        return ResponseEntity.ok(resultId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "댓글을 삭제합니다.", description = "사용자가 댓글을 삭제합니다.")
    public ResponseEntity deleteComment(
            @PathVariable Long id){
        Long result = commentService.deleteComment(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    @Operation(summary = "댓글을 조회합니다.", description = "특정 게시글의 댓글을 모두 조회합니다.")
    public ResponseEntity<List<ResponseCommentDTO>> getAllComments(
            @RequestParam Long postId
    ){

        List<ResponseCommentDTO> comments = commentService.getComments(postId);
        return ResponseEntity.ok(comments);
    }

}
