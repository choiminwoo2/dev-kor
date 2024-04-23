package org.ruu.developerkorea.board.controller;

import groovy.util.logging.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.board.dto.RequestAddBoardDTO;
import org.ruu.developerkorea.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@lombok.extern.slf4j.Slf4j
@Controller
@RequestMapping("/board")
@Tag(name = "Board API")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "게시판 등록", description = "유저가 게시판을 등록합니다.")
    @PostMapping
    public String insertBoard(@RequestBody @Valid RequestAddBoardDTO boardDTO, Model model){
        boardService.insertBoard(boardDTO);
        model.addAttribute("ok", true);
        return "board";
    }

}
