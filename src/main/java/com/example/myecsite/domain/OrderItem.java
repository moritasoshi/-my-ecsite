package com.example.myecsite.domain;

import java.util.List;
import java.util.Objects;

/**
 * 注文商品を表すドメイン.
 */
public class OrderItem {

    private Integer id;
    private Integer itemId;
    private Integer orderId;
    private Integer quantity;
    private String size;
    private Item item;
    private List<OrderTopping> orderToppingList;

    /**
     * 注文商品の小計金額を返すメソッド
     * @return (itemPrice + toppingPrice) * quantity
     */
    public Integer getSubTotal() {
        // subTotal = (itemPrice + toppingPrice) * quantity
        Integer itemPrice = 0;
        Integer toppingPrice = 0;

        // itemPrice
        if ("M".equals(size)) {
            itemPrice = item.getPriceM();
        } else if ("L".equals(size)) {
            itemPrice = item.getPriceL();
        }

        // toppingPrice
        for (OrderTopping orderTopping : orderToppingList) {
            if (("M").equals(size)) {
                toppingPrice += orderTopping.getTopping().getPriceM();
            } else if (("L").equals(size)) {
                toppingPrice += orderTopping.getTopping().getPriceL();
            }
        }

        return (itemPrice + toppingPrice) * quantity;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<OrderTopping> getOrderToppingList() {
        return orderToppingList;
    }

    public void setOrderToppingList(List<OrderTopping> orderToppingList) {
        this.orderToppingList = orderToppingList;
    }
}
