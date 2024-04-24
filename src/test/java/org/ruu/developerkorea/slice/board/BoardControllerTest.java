package org.ruu.developerkorea.slice.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruu.developerkorea.domain.board.controller.BoardController;
import org.ruu.developerkorea.domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createBoardWithPostMethod() throws Exception {

        //given
        String requestBody = "{\"title\": \"testtitle\", \"description\": \"testdescription\"}";

        mockMvc.perform(post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.title").value("testtitle"))
//                .andExpect(jsonPath("$.description").value("testdescription"));
    }
}
