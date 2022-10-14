package com.dev.blog.mapper;

import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardDTO boardDTO);

    public List<BoardVO> selectBoardList(BoardDTO boardDTO);

    public BoardVO selectBoard(int boardIdx);

    public void updateBoard(BoardDTO boardDTO);

    public void deleteBoard(int boardIdx);

    public void truncateBoard();
}
