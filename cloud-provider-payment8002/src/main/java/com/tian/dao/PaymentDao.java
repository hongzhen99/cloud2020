package com.tian.dao;

import com.tian.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentDao
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/7/8 21:02
 */
@Mapper
public interface PaymentDao {
    /**
     *
     * @param payment 接收
     * @return 返回数据
     */
    public int createPayment(Payment payment);

    /**
     *
     * @param id 接收一个id
     * @return  返回数据
     */
    public Payment getPaymentById(@Param("id") Long id);

}
