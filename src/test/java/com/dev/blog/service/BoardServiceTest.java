package com.dev.blog.service;

import com.dev.blog.dao.BoardDAO;
import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardDAO boardDAO;

    private List<BoardDTO> boardDTOList;

    @Before
    public void setUp(){
        this.boardDTOList = Arrays.asList(
                new BoardDTO("제목1", "내용111", 2),
                new BoardDTO("제목2", "내용222", 1),
                new BoardDTO("제목3", "내용333", 2)
        );
    }

    @Test
    public void edit(){
        this.boardDAO.truncate();
        BoardDTO boardDTO1 = this.boardDTOList.get(0);

        System.out.println(boardDTO1);
        this.boardService.editBoard(boardDTO1);
        BoardVO boardVO = this.boardService.selectBoardInfo(1);

        assertThat(boardVO.getTitle(), is(boardDTO1.getTitle()));
        assertThat(boardVO.getContent(), is(boardDTO1.getContent()));
        assertThat(boardVO.getCategory(), is(boardDTO1.getCategory()));
        assertThat(boardVO.getIdx(), not(boardDTO1.getIdx()));

        BoardDTO boardDTO2 = this.boardDTOList.get(1);
        boardDTO2.setIdx(1);

        this.boardService.editBoard(boardDTO2);
        boardVO = this.boardService.selectBoardInfo(1);

        assertThat(boardVO.getIdx(), is(boardDTO2.getIdx()));
        assertThat(boardVO.getTitle(), is(boardDTO2.getTitle()));
        assertThat(boardVO.getContent(), is(boardDTO2.getContent()));
        assertThat(boardVO.getCategory(), is(boardDTO2.getCategory()));
    }
}
