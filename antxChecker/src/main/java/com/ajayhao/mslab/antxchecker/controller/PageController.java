package com.ajayhao.mslab.antxchecker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AjayHao on 2017/6/18.
 */

@Controller
public class PageController {

    @RequestMapping("/antxChecker")
    public String antxCheckerPage() {
        return "antxChecker";
    }
}
