package com.tian.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tian.entity.CommonResult;
import com.tian.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RateLimitController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/19 下午10:05
 */
@RestController
public class RateLimitController {

    @GetMapping("/source")
    @SentinelResource(value = "source", blockHandler = "handler")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流分配", null);
    }

    public CommonResult handler(BlockException blockException) {
        return new CommonResult(500, blockException.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/test1")
    @SentinelResource(value = "test1",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult test1() {
        return new CommonResult(200, "按资源名称限流分配", "handlerException1");
    }

}
