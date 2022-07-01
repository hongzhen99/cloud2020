package tian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName NacosProviderMain9001
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/18 下午2:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NaocsConsumerMain9000 {
    public static void main(String[] args) {
        SpringApplication.run(NaocsConsumerMain9000.class,args);
    }
}
