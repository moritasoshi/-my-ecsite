package com.example.myecsite.service;

import com.example.myecsite.domain.Order;
import com.example.myecsite.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品の購入や購入履歴に関連するサービス
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

}
