package com.example.myecsite.domain;

import java.util.List;
import java.util.Objects;

/**
 * 注文商品を表すドメイン.
 *
 * @author yumi takahashi
 */
public class OrderItem {

    /**
     * ID
     */
    private Integer id;

    /**
     * 商品ID
     */
    private Integer itemId;

    /**
     * オーダーID
     */
    private Integer orderId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * サイズ
     */
    private Character size;

    public OrderItem() {
    }

    public OrderItem(Integer id, Integer itemId, Integer orderId, Integer quantity, Character size) {
        this.id = id;
        this.itemId = itemId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Character getSize() {
        return size;
    }

    public void setSize(Character size) {
        this.size = size;
    }
}
