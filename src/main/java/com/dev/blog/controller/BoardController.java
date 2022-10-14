package com.dev.blog.controller;

import com.dev.blog.domain.dto.BoardDTO;
import com.dev.blog.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board/")
public class BoardController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BoardService boardService;

    @RequestMapping(value={"write", "write/{boardIdx}"}, method= RequestMethod.GET)
    public String writePage(@PathVariable @Nullable Integer boardIdx, Model model){
        model.addAttribute("board", this.boardService.selectBoardInfo(boardIdx));
        return "pages/board/write";
    }

    @RequestMapping(value="write", method=RequestMethod.POST)
    public @ResponseBody Object write(BoardDTO boardDTO){

        logger.info("글 등록 정보 = {}", boardDTO);

        this.boardService.editBoard(boardDTO);
        Map<String, Object> response = new HashMap<>();

        response.put("status", 200);
        response.put("result", "success");

        return response;
    }
}
