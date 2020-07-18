package tian.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName NacosPaymentController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/18 下午2:36
 */
@RestController
public class NacosPaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry serverPort :  " + serverPort + "\t id : " + id;
    }

}
