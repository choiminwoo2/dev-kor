package org.ruu.developerkorea.domain.board.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ruu.developerkorea.domain.board.domain.Board;
import org.ruu.developerkorea.domain.board.model.dto.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.ResponseBoardDTO;

@Mapper
public interface BoardMapper {

    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    ResponseBoardDTO boardToResponseBoardDTO(Board board);

    Board dtoToResponseBoardDTO(ResponseBoardDTO responseBoardDTO);

    Board requestAppendBoardToBoard(RequestAppendBoardDTO requestAppendBoardDTO);
}
