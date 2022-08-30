package com.dev.blog.dao;

import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDAO {
    public int add(BoardDTO boardDTO);

    public BoardVO getBoard(BoardDTO boardDTO);

    public List<BoardVO> getBoardList();

    public boolean delete(BoardDTO boardDTO);

    public boolean update(BoardDTO boardDTO);
}
