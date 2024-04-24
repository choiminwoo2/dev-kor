package org.ruu.developerkorea.slice.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ruu.developerkorea.domain.board.domain.BoardAppender;
import org.ruu.developerkorea.domain.board.model.dto.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.service.BoardService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @InjectMocks
    private BoardAppender boardAppenderMock;

    @Test
    public void insertBoard() {
        // Given
        RequestAppendBoardDTO requestDTO = RequestAppendBoardDTO.builder()
                .name("Test Board")
                .description("Test Description")
                .build();
        // When
        doNothing().when(boardAppenderMock).append(requestDTO);
        // Then
        verify(boardAppenderMock, times(1)).append(requestDTO);
    }
}
