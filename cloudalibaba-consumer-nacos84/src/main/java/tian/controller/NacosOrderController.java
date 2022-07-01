package tian.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tian.service.PaymentService;

import javax.annotation.Resource;

/**
 * @ClassName NacosPaymentController
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/18 下午2:36
 */
@RestController
public class NacosOrderController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/nacos/{id}")
//    @SentinelResource(value = "consumer")//没有配置
//    @SentinelResource(value = "consumer", ) //fallback只负责业务异常
//    @SentinelResource(value = "consumer", blockHandler = "blockHandler") //blockHandler只负sentinel控制台配置
    @SentinelResource(value = "consumer",fallback = "handlerFallback", blockHandler = "blockHandler") //blockHandler只负sentinel控制台配置
    public String aaa(@PathVariable("id") Integer id) {
        String forObject = restTemplate.getForObject(serverURL + "/nacos/" + id, String.class);
        if (id == 4) {
            throw new RuntimeException(" 非法参数");
        } else if (id > 4) {
            throw new NullPointerException("空指针");
        }
        return forObject;
    }

    public String handlerFallback(@PathVariable Integer id, Throwable throwable) {
        return "我是业务类异常 兜底的 id=" + id;
    }

    public String blockHandler(@PathVariable Integer id, BlockException blockException) {
        return "我是blockHandler 兜底的 id=" + id;
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return paymentService.getPayment(id);
    }
}
