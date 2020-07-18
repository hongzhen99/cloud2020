package tian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName NacosProviderMain9001
 * @Description TODO
 * @Author tianhongzhen
 * @Date: 2020/7/18 下午2:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9002.class,args);
    }
}
