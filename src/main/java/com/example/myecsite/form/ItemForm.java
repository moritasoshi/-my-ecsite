package com.example.myecsite.form;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ItemForm {

    private Integer itemId;
    @NotBlank(message = "サイズを選択してください")
    private String size = "M";
    @NotNull(message = "数量を選択してください")
    @Range(min = 1, max = 12, message = "範囲外の数量です")
    private Integer quantity = 1;
    private List<Integer> toppingIdList;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<Integer> getToppingIdList() {
        return toppingIdList;
    }

    public void setToppingIdList(List<Integer> toppingIdList) {
        this.toppingIdList = toppingIdList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

}
