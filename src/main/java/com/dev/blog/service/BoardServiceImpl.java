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
    public void editBoard(BoardDTO boardDTO) {
        if(boardDTO.getIdx() == 0) this.boardDAO.add(boardDTO);
        else this.boardDAO.update(boardDTO);
    }

    @Override
    public void deleteBoard(int boardIdx) {
        this.boardDAO.delete(boardIdx);
    }

    @Override
    public BoardVO selectBoardInfo(Integer boardIdx) {
        if(boardIdx != null){
            return this.boardDAO.getBoard(boardIdx);
        }

        return new BoardVO();
    }

    @Override
    public List<BoardVO> searchBoardList(BoardDTO boardDTO) {
        return this.boardDAO.getBoardList(boardDTO);
    }
}
