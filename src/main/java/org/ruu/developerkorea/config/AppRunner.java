package org.ruu.developerkorea.config;

import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.ruu.developerkorea.domain.board.repository.BoardRepository;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("local")
public class AppRunner implements ApplicationRunner {

    private final Environment environment;
    private final BoardRepository boardRepository;
    private final PostRepository postRepository;

    public AppRunner(Environment environment, BoardRepository boardRepository, PostRepository postRepository) {
        this.environment = environment;
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        readProperties();
        initData();
    }

    public void initData() {
        Board board1 = Board.builder()
                .name("커뮤니티")
                .description("커뮤니티사이트입니다.")
                .pwd("12345")
                .build();
        Board board2 = Board.builder()
                .name("Q&A")
                .description("Q&A사이트입니다.")
                .pwd("12345")
                .build();
        boardRepository.save(board1);
        boardRepository.save(board2);

        for (int i = 0; i < 20; i++) {
            postRepository.save(Post.builder()
                    .title("타이틀입니다." + i)
                    .writer("작성자")
                    .content("게시글 내용입니다.")
                    .board(board1)
                    .build());
        }
    }

    public void readProperties() {
        System.out.println("===================다중 프로파일 테스트===================");
        System.out.println("Active profiles : " + Arrays.toString(environment.getActiveProfiles()));
        System.out.println("Datasource driver : " + environment.getProperty("spring.datasource.driver-class-name"));
        System.out.println("Datasource url : " + environment.getProperty("spring.datasource.url"));
        System.out.println("Datasource username : " + environment.getProperty("spring.datasource.username"));
        System.out.println("Datasource password : " + environment.getProperty("spring.datasource.password"));
        System.out.println("Server Port : " + environment.getProperty("server.port"));
        System.out.println("Default Property : " + environment.getProperty("default.string"));
        System.out.println("Common Property : " + environment.getProperty("common.string"));
        System.out.println("====================================================");
    }
}
