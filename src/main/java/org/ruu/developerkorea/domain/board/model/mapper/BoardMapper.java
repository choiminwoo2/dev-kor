package org.ruu.developerkorea.domain.board.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.ruu.developerkorea.domain.board.model.dto.board.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.board.RequestUpdateBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardDTO;

@Mapper
public interface BoardMapper {

    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    ResponseBoardDTO boardToResponseBoardDTO(Board board);

    Board dtoToResponseBoardDTO(ResponseBoardDTO responseBoardDTO);

    Board requestAppendBoardDTOToBoard(RequestAppendBoardDTO requestAppendBoardDTO);

    Board requestUpdateBoardDTOToBoard(RequestUpdateBoardDTO requestUpdateBoardDTO);
}
