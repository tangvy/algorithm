package com.tangv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:   tangwei
 * Date:     2021/12/19 9:55
 * Description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    private volatile boolean flag = false;

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/loop")
    public String loop() {
        while (!flag) {
            log.info("循环中...");
        }
        log.debug("跳出循环...");
        return "method loop end!";
    }

    @GetMapping("/interrupt")
    public String interrupt() {
        flag = !flag;
        log.info("打断flag标记...");
        return "method interrupt end!";
    }

}