package com.dev.blog.service;


import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;

import java.util.List;

public interface BoardService {

    public void editBoard(BoardDTO boardDTO);

    public void deleteBoard(int boardIdx);

    public BoardVO selectBoardInfo(Integer boardIdx);

    public List<BoardVO> searchBoardList(BoardDTO boardDTO);
}
