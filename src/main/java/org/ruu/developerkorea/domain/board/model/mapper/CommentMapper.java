package org.ruu.developerkorea.domain.board.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestAppenderCommentDTO;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment RequestAppendCommentToComment(RequestAppenderCommentDTO requestAppenderCommentDTO);
}
