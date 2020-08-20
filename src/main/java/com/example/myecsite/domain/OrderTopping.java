package com.example.myecsite.domain;

/**
 * 注文トッピング情報を表すドメイン.
 *
 * @author yumi takahashi
 */
public class OrderTopping {

    /**
     * ID
     */
    private Integer id;

    /**
     * トッピングID
     */
    private Integer toppingId;

    /**
     * 注文商品ID
     */
    private Integer orderItemId;


    // constructor
    public OrderTopping() {

    }

    public OrderTopping(Integer id, Integer toppingId, Integer orderItemId) {
        super();
        this.id = id;
        this.toppingId = toppingId;
        this.orderItemId = orderItemId;
    }

    // getter setter
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

}
