package com.dev.blog.dao;

import com.dev.blog.dao.BoardDAO;
import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import com.dev.blog.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BoardDAOImple implements BoardDAO {

    @Autowired
    private BoardMapper mapper;

    @Override
    public int add(BoardDTO boardDTO) {
        return mapper.insertBoard(boardDTO);
    }

    @Override
    public BoardVO getBoard(BoardDTO boardDTO) {
        return null;
    }

    @Override
    public List<BoardVO> getBoardList() {
        return null;
    }

    @Override
    public boolean delete(BoardDTO boardDTO) {
        return false;
    }

    @Override
    public boolean update(BoardDTO boardDTO) {
        return false;
    }
}
