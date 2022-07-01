package tian.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/20 下午1:47
 */
@FeignClient(value = "nacos-payment-provider",fallback = Fallback.class)
public interface PaymentService {

    @GetMapping("/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id);
}
