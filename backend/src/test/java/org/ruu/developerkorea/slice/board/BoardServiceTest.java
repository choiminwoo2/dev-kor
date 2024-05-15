package org.ruu.developerkorea.slice.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ruu.developerkorea.domain.board.domain.board.BoardAppender;
import org.ruu.developerkorea.domain.board.model.dto.board.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.service.BoardService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardAppender boardAppenderMock;

    @InjectMocks
    private BoardService boardServiceMock;

    @Test
    public void insertBoard() {
        // Given
        RequestAppendBoardDTO requestDTO = RequestAppendBoardDTO.builder()
                .name("Test Board")
                .description("Test Description")
                .build();
        // When
        when(boardAppenderMock.append(requestDTO)).thenReturn(1L); // 가짜 호출에 대한 반환값 설정

        long returnValue = boardServiceMock.insertBoard(requestDTO);

        // Then
        assertThat(1L).isEqualTo(returnValue);
        verify(boardAppenderMock, times(1)).append(requestDTO);
    }
}
