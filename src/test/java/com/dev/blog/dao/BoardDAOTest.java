package com.dev.blog.dao;

import com.dev.blog.domain.dto.BoardDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardDAOTest {

    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void add(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("제목1");
        boardDTO.setContent("내용111");
        boardDTO.setCategory(2);
        boardDAO.add(boardDTO);


    }
}
