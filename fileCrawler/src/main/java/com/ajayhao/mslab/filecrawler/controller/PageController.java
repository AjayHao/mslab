package com.ajayhao.mslab.filecrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AjayHao on 2017/6/18.
 */

@Controller
public class PageController {

    @RequestMapping("/fileInfoStat")
    public String filecrawler() {
        return "fileInfoStat";
    }

}
