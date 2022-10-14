package com.dev.blog.controller;

import com.dev.blog.dao.BoardDAO;
import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMybatis
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    private List<BoardDTO> boardDTOList;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BoardDAO boardDAO;

    @Before
    public void setUp(){
        this.boardDTOList = Arrays.asList(
                new BoardDTO("제목1", "내용111", 2),
                new BoardDTO("제목2", "내용222", 1),
                new BoardDTO("제목3", "내용333", 2)
        );
    }

    @Test
    public void getBoardInfo(){
        this.boardDAO.truncate();
        BoardDTO boardDTO = this.boardDTOList.get(0);
        this.boardDAO.add(this.boardDTOList.get(0));
        try{
            MvcResult mr = mvc.perform(get("/board/write/1")).andExpectAll(status().isOk()).andReturn();
            BoardVO boardVO = (BoardVO) mr.getModelAndView().getModel().get("board");

            assertThat(boardDTO.getTitle(), is(boardVO.getTitle()));
            assertThat(boardDTO.getContent(), is(boardVO.getContent()));
            assertThat(boardDTO.getCategory(), is(boardVO.getCategory()));
        } catch(Exception e){
            e.getMessage();
        }
    }

    @Test
    public void writeRequestTest(){
        this.boardDAO.truncate();
        BoardDTO boardDTO1 = this.boardDTOList.get(0);
        try{
            MvcResult mr = mvc.perform(post("/board/write")
                            .param("title", boardDTO1.getTitle()).param("content", boardDTO1.getContent()).param("category", String.valueOf(boardDTO1.getCategory())))
                    .andExpectAll(status().isOk(), content().contentType("application/json")).andReturn();
            Map<String, Object> response = (Map<String, Object>) mr.getAsyncResult();
            assertThat("success", is(response.get("result")));
            assertThat(200, is(response.get("status")));
        } catch(Exception e){
            e.getMessage();
        }
    }
}
