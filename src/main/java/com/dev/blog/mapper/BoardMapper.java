package com.dev.blog.mapper;

import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardDTO boardDTO);

    public List<BoardVO> selectBoardList(BoardDTO boardDTO);

    public BoardVO selectBoard(BoardDTO boardDTO);

    public void updateBoard(BoardDTO boardDTO);

    public void deleteBoard(BoardDTO boardDTO);

    public void truncateBoard();
}
