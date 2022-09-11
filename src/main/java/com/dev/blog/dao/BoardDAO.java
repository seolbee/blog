package com.dev.blog.dao;

import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoardDAO {
    public void add(BoardDTO boardDTO);

    public BoardVO getBoard(BoardDTO boardDTO);

    public List<BoardVO> getBoardList(BoardDTO boardDTO);

    public void delete(BoardDTO boardDTO);

    public void update(BoardDTO boardDTO);

    public void truncate();
}
