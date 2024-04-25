package org.ruu.developerkorea.domain.board.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestAppendPostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestUpdatePostDTO;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post requestAppendPostDTOToPost(RequestAppendPostDTO postDTO);

    Post requestUpdatePostDTOToPost(RequestUpdatePostDTO postDTO);
}
