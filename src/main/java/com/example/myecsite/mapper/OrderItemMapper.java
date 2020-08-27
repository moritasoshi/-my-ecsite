package com.example.myecsite.mapper;

import com.example.myecsite.domain.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper {
    Integer save(OrderItem orderItem);
    Integer delete(Integer orderItemId);
}
