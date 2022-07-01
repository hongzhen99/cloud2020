package tian.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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

    public static HashMap<Integer, String> hashMap = new HashMap();

    static {
        hashMap.put(1, "1-1");
        hashMap.put(2, "2-2");
        hashMap.put(3, "3-3");
    }

    @GetMapping("/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return hashMap.get(id) + "serverPort = " + serverPort;
    }

}
