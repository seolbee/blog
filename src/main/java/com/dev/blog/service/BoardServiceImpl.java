package com.dev.blog.service;

import com.dev.blog.dao.BoardDAO;
import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    public BoardDAO boardDAO;

    @Override
    public void postBoard(BoardDTO boardDTO) {
        boardDAO.add(boardDTO);
    }

    @Override
    public void editBoard(BoardDTO boardDTO) {
        boardDAO.update(boardDTO);
    }

    @Override
    public void deleteBoard(BoardDTO boardDTO) {
        boardDAO.delete(boardDTO);
    }

    @Override
    public List<BoardVO> selectBoardList(BoardDTO boardDTO) {
        return boardDAO.getBoardList(boardDTO);
    }

    @Override
    public BoardVO selectBoardInfo(BoardDTO boardDTO) {
        return boardDAO.getBoard(boardDTO);
    }
}
