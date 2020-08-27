package com.example.myecsite.mapper;

import com.example.myecsite.domain.OrderItem;
import com.example.myecsite.domain.OrderTopping;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderToppingMapper {
    Integer save(OrderTopping orderTopping);
    Integer delete(Integer orderItemId);
}
