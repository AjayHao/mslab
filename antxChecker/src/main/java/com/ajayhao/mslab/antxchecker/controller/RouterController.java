package com.ajayhao.mslab.antxchecker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AjayHao on 2017/6/18.
 */

@Controller
public class RouterController {

    @RequestMapping("/index")
    public String home() {
        return "index";
    }

    @RequestMapping("/fileInfoStat")
    public String filecrawler() {
        return "fileInfoStat";
    }

    @RequestMapping("/antxChecker")
    public String antxchecker() {
        return "antxChecker";
    }
}
