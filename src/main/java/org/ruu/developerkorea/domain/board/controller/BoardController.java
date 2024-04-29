package org.ruu.developerkorea.domain.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.ruu.developerkorea.domain.board.model.dto.board.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.board.RequestUpdateBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardWithPostDTO;
import org.ruu.developerkorea.domain.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
        //TODO BOARD가 아니라 MYPAGE로 redirect 해야합니다.
        if (result != null) {
            model.addAttribute(HttpStatus.OK.name(), true);

            return "redirect:board/";
        }
        return "redirect:/board";
    }

    @Operation(summary = "게시판 수정", description = "유저가 게시판을 수정합니다.")
    @PutMapping("/{id}")
    public String updateBoard(@PathVariable Long id, @RequestBody @Valid RequestUpdateBoardDTO requestUpdateBoardDTO, Model model) {
        requestUpdateBoardDTO.setId(id);
        Long result = boardService.updateBoard(requestUpdateBoardDTO);
        //TODO 마이페이지로 redirect 해야 합니다. 서비스 계층에서 구현
        return "redirect:/board/" + result;
    }

    //TODO 메인화면 아이템을 보여줘야 합니다.
    @Operation(summary = "모든 게시판 조회", description = "유저가 게시판을 조회합니다.")
    @GetMapping
    public String getBoard(Model model) {
        List<Board> boards = boardService.retrieveAllBoard();
        model.addAttribute("dtoList", boards);
        //TODO 마이페이지로 redirect 해야 합니다.
        return "board/list";
    }

    @Operation(summary = "특정 게시판 삭제", description = "유저가 게시판을 삭제합니다.")
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable Long id, Model model) {
        //TODO 마이페이지로 redirect 해야 합니다.
        boardService.deleteBoard(id);
        return "board/list";
    }

    @Operation(summary = "특정 게시판 조회", description = "누구나 특정 게시판을 조회할 수 있습니다.")
    @GetMapping("/{url}")
    public ResponseEntity<ResponseBoardWithPostDTO> getBoardByName(@PathVariable String url, Model model) {

        ResponseBoardWithPostDTO boardDTO = boardService.displayBoardByUrl(url);
        model.addAttribute("dtoList", boardDTO);
        log.info("BoardWithPostDTO : {} ", boardDTO);
        return ResponseEntity.ok(boardDTO);

    }


}
