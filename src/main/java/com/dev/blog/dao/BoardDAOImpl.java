package com.dev.blog.dao;

import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import com.dev.blog.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    private BoardMapper mapper;

    @Override
    public void add(BoardDTO boardDTO) {
        this.mapper.insertBoard(boardDTO);
    }

    @Override
    public BoardVO getBoard(BoardDTO boardDTO) {
        return this.mapper.selectBoard(boardDTO);
    }

    @Override
    public List<BoardVO> getBoardList(BoardDTO boardDTO) {
        return this.mapper.selectBoardList(boardDTO);
    }

    @Override
    public void delete(BoardDTO boardDTO) {
        this.mapper.deleteBoard(boardDTO);
    }

    @Override
    public void update(BoardDTO boardDTO) {
        this.mapper.updateBoard(boardDTO);
    }

    @Override
    public void truncate() {
        this.mapper.truncateBoard();
    }
}
