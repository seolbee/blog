package com.dev.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @RequestMapping(value={"write", "write/{boardIdx}"}, method= RequestMethod.GET)
    public String writePage(@PathVariable int boardIdx){
        logger.debug("블로그 글 인덱스 번호 : " + boardIdx);
        return "pages/board/write";
    }

    @RequestMapping(value="write", method=RequestMethod.POST)
    public @ResponseBody Object write(Model model){
        Map<String, Object> response = new HashMap<>();

        return response;
    }
}
