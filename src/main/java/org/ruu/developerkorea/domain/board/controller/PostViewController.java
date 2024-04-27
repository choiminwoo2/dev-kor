package org.ruu.developerkorea.domain.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.post.ResponsePostDTO;
import org.ruu.developerkorea.domain.board.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class PostViewController {

    private final PostService postService;

    @Operation(summary = "게시글 조회", description = "누구나 게시글을 조회할 수 있습니다.")
    @GetMapping("/{boardName}/post/{id}")
    public String selectOnePost(
            @PathVariable final String boardName,
            @PathVariable final Long id,
            RedirectAttributes redirectAttributes,
            Model model) {
        if (id == null) {
            redirectAttributes.addFlashAttribute(HttpStatus.NOT_FOUND.name(), true);
            return "redirect:/error";
        }
        ResponsePostDTO post = postService.findPostById(id, boardName);

        model.addAttribute("dto", post);
        return "post/post";
    }
}
