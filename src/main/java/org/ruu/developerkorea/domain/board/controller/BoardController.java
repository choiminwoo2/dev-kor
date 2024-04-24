package org.ruu.developerkorea.domain.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ruu.developerkorea.domain.board.model.dto.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.RequestUpdateBoardDTO;
import org.ruu.developerkorea.domain.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@Tag(name = "Board API")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "게시판 등록", description = "유저가 게시판을 등록합니다.")
    @PostMapping
    public String createBoard(@RequestBody @Valid RequestAppendBoardDTO boardDTO, Model model) {

        Long result = boardService.insertBoard(boardDTO);
        model.addAttribute(HttpStatus.OK.name(), false);
        if(result != null) {
            model.addAttribute(HttpStatus.OK.name(), true);
            return "redirect:board/" + result;
        }
        return "index";
    }

    @Operation(summary = "게시판 수정", description = "유저가 게시판을 수정합니다.")
    @PutMapping
    public String updateBoard(@RequestBody @Valid RequestUpdateBoardDTO requestUpdateBoardDTO, Model model) {

        Long result = boardService.updateBoard(requestUpdateBoardDTO);

        return "index";
    }


}
