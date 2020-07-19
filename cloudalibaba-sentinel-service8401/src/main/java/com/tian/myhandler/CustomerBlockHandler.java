package com.tian.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tian.entity.CommonResult;

/**
 * @ClassName CustomerBlockHandler
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/19 下午10:25
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(500, exception.getClass().getCanonicalName() + "\t 全局 BlockException");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(500, exception.getClass().getCanonicalName() + "\t 全局 BlockException---2");
    }
}
