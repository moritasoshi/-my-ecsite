package com.example.myecsite.mapper;

import com.example.myecsite.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    Integer save(Order order);
    Integer update(Order order);
    Order findByUserIdAndStatus(Integer userId, Integer status);

    /**
     * 任意のユーザーのstatus!=0の注文を返す
     * @param userId
     * @return 任意のユーザーのstatus!=0の注文を返す
     */
    List<Order> findNonStatus0ByUserId(Integer userId);
}
