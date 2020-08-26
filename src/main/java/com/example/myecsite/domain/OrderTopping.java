package com.example.myecsite.domain;

/**
 * 注文トッピング情報を表すドメイン.
 *
 * @author yumi takahashi
 */
public class OrderTopping {
    private Integer id;
    private Integer toppingId;
    private Integer orderItemId;

    private Topping topping;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToppingId() {
        return toppingId;
    }

    public void setToppingId(Integer toppingId) {
        this.toppingId = toppingId;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }
}
