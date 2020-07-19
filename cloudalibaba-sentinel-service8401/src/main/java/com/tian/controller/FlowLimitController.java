package com.tian.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FlowLimitController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/19 下午2:32
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/test/a")
    public String testA(){
        return "----------testA";
    }
    @GetMapping("/test/b")
    public String testB(){
        return "----------testB";
    }

    @GetMapping("/test/key")
    @SentinelResource(value = "key",blockHandler = "handler")
    public String testHostKey(@RequestParam(value = "p1",required = false) String s1,
                              @RequestParam(value = "p2",required = false) String s2){
        return "--------testHostKey";
    }
    public String handler(String s1, String s2, BlockException blockException){
        log.info("--------handler 兜底");
        return "--------handler 兜底";
    }
}
