package com.example.myecsite.mapper;

import com.example.myecsite.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Integer save(Order order);
    Order findByUserIdAndStatus(Integer userId, Integer status);
}
