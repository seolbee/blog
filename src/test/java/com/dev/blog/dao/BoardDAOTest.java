package com.dev.blog.dao;

import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BoardDAOTest {

    @Resource(name="BoardDAO")
    private BoardDAO boardDAO;

    private List<BoardDTO> boardDTOList;

    @Before
    public void setUp(){
        boardDTOList = Arrays.asList(
                            new BoardDTO("제목1", "내용111", 2),
                            new BoardDTO("제목2", "내용222", 1),
                            new BoardDTO("제목3", "내용333", 2)
                        );
    }

    @Test
    public void add(){
        this.boardDAO.truncate();

        BoardDTO board1 = boardDTOList.get(0);
        this.boardDAO.add(board1);

        BoardDTO boardDTO1 = new BoardDTO();
        boardDTO1.setIdx(1);
        BoardVO boardVO1 = this.boardDAO.getBoard(boardDTO1);

        assertThat(board1.getTitle(), is(boardVO1.getTitle()));
        assertThat(board1.getContent(), is(boardVO1.getContent()));

        BoardDTO board2 = boardDTOList.get(1);
        this.boardDAO.add(board2);

        BoardDTO boardDTO2 = new BoardDTO();
        boardDTO2.setIdx(2);
        BoardVO boardVO2 = this.boardDAO.getBoard(boardDTO2);

        assertThat(board2.getTitle(), is(boardVO2.getTitle()));
        assertThat(board2.getContent(), is(boardVO2.getContent()));


        BoardDTO board3 = boardDTOList.get(2);
        this.boardDAO.add(board3);

        BoardDTO boardDTO3 = new BoardDTO();
        boardDTO3.setIdx(3);
        BoardVO boardVO3 = this.boardDAO.getBoard(boardDTO3);

        assertThat(board3.getTitle(), is(boardVO3.getTitle()));
        assertThat(board3.getContent(), is(boardVO3.getContent()));
    }

    @Test
    public void update(){
        this.boardDAO.truncate();

        BoardDTO board1 = boardDTOList.get(0);
        BoardDTO board2 = boardDTOList.get(1);

        this.boardDAO.add(board1);
        this.boardDAO.add(board2);

        BoardDTO board1Update = new BoardDTO();
        board1Update.setIdx(1);
        board1Update.setTitle("제목1 바꿈");
        board1Update.setContent("내용111 바꿈");

        boardDAO.update(board1Update);
        BoardVO boardVO = boardDAO.getBoard(board1Update);

        assertThat(board1.getTitle(), not(boardVO.getTitle()));
        assertThat(board1.getContent(), not(boardVO.getContent()));

        assertThat(board1Update.getTitle(), is(boardVO.getTitle()));
        assertThat(board1Update.getContent(), is(boardVO.getContent()));
    }

    @Test
    public void delete(){
        this.boardDAO.truncate();

        BoardDTO board1 = boardDTOList.get(0);
        this.boardDAO.add(board1);

        BoardDTO board2 = boardDTOList.get(1);
        this.boardDAO.add(board2);

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setIdx(1);
        BoardVO boardVO1 = boardDAO.getBoard(boardDTO);

        assertThat(board1.getTitle(), is(boardVO1.getTitle()));
        assertThat(board1.getContent(), is(boardVO1.getContent()));
        assertThat(board1.getCategory(), is(boardVO1.getCategory()));

        boardDAO.delete(boardDTO);
        BoardVO boardVO2 = boardDAO.getBoard(boardDTO);

        assertThat(boardVO2, is(nullValue()));
    }

    @Test
    public void selectList(){
        this.boardDAO.truncate();

        this.boardDAO.add(this.boardDTOList.get(0));
        this.boardDAO.add(this.boardDTOList.get(1));
        this.boardDAO.add(this.boardDTOList.get(2));

        BoardDTO boardSearch = new BoardDTO();

        List<BoardVO> boardList = this.boardDAO.getBoardList(boardSearch);

        assertThat(boardList.size(), is(3));
    }
}
