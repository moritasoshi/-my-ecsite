package com.example.myecsite.service;

import com.example.myecsite.domain.Order;
import com.example.myecsite.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品の購入や購入履歴に関連するサービス
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * カートにある商品を注文する
     * @param order
     * @return
     */
    public Integer Order(Order order) {
        return orderMapper.update(order);
    }

    /**
     * 注文履歴を検索する.
     *
     * @param userId ユーザID
     * @return 注文履歴
     *
     */
    public List<Order> findOrderHistory(Integer userId) {
        return orderMapper.findNonStatus0ByUserId(userId);
    }
}
