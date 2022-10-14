package com.dev.blog.dao;

import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;

import java.util.List;

public interface BoardDAO {
    public void add(BoardDTO boardDTO);

    public BoardVO getBoard(int boardIdx);

    public List<BoardVO> getBoardList(BoardDTO boardDTO);

    public void delete(int boardIdx);

    public void update(BoardDTO boardDTO);

    public void truncate();
}
