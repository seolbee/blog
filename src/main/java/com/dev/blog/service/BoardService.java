package com.dev.blog.service;


import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;

import java.util.List;

public interface BoardService {

    public void postBoard(BoardDTO boardDTO);

    public void editBoard(BoardDTO boardDTO);

    public void deleteBoard(BoardDTO boardDTO);

    public List<BoardVO> selectBoardList(BoardDTO boardDTO);

    public BoardVO selectBoardInfo(BoardDTO boardDTO);
}
