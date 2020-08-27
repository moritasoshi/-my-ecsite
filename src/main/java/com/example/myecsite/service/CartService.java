package com.example.myecsite.service;

import com.example.myecsite.domain.Order;
import com.example.myecsite.domain.OrderItem;
import com.example.myecsite.domain.OrderTopping;
import com.example.myecsite.mapper.OrderItemMapper;
import com.example.myecsite.mapper.OrderMapper;
import com.example.myecsite.mapper.OrderToppingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * ショッピングカートの表示・追加削除に関連するサービス
 */
@Service
@Transactional
public class CartService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderToppingMapper orderToppingMapper;

    public CartService() {
    }

    /**
     * ユーザーが選択した商品およびトッピングをカートに追加する
     *
     * @param userId
     * @param orderItem
     * @param toppingIdList
     */
    public void addToCart(Integer userId, OrderItem orderItem, List<Integer> toppingIdList) {
        Order existingCart = showCart(userId);
        if (Objects.nonNull(existingCart)) {        // 既存のカートがある場合
            Integer orderId = existingCart.getId();
            // orderItem
            orderItem.setOrderId(orderId);
            Integer orderItemId = orderItemMapper.save(orderItem);
            // orderToppings
            for (Integer toppingId : toppingIdList) {
                OrderTopping orderTopping = new OrderTopping();
                orderTopping.setOrderItemId(orderItemId);
                orderTopping.setToppingId(toppingId);
                orderToppingMapper.save(orderTopping);
            }
        } else {                                    // 既存のカートがない場合
            // order
            Order order = new Order();
            order.setUserId(userId);
            order.setStatus(0);
            order.setTotalPrice(0);
            Integer orderId = orderMapper.save(order);
            // orderItem
            orderItem.setOrderId(orderId);
            Integer orderItemId = orderItemMapper.save(orderItem);
            // orderToppings
            for (Integer toppingId : toppingIdList) {
                OrderTopping orderTopping = new OrderTopping();
                orderTopping.setOrderItemId(orderItemId);
                orderTopping.setToppingId(toppingId);
                orderToppingMapper.save(orderTopping);
            }
        }
    }

    /**
     * 任意のユーザーのショッピングカートを検索する
     * @param userId
     * @return Nullable Order object
     */
    public Order showCart(Integer userId) {
        return orderMapper.findByUserIdAndStatus(userId, 0);
    }

    /**
     * 指定の注文商品をカートから削除する
     *
     * @param orderItemId
     */
    public void deleteOrderItemFromCart(Integer orderItemId) {
        // orderItemの削除
        orderItemMapper.delete(orderItemId);
        // orderToppingの削除
        orderToppingMapper.delete(orderItemId);
    }

}
