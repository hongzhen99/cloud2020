package tian.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName Fallback
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/20 下午1:49
 */
@Component
public class Fallback implements PaymentService {
    @Override
    public String getPayment(Integer id) {
        return "我来兜底---PaymentService";
    }
}
