package com.example.myecsite.service;

import com.example.myecsite.domain.Item;
import com.example.myecsite.domain.Topping;
import com.example.myecsite.repository.ItemRepository;
import com.example.myecsite.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品情報の一覧表示および詳細表示に関連するクラス
 */
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ToppingRepository toppingRepository;

    public List<Item> showAllItems(){
        return itemRepository.findAll();
    }

    public Item showDetails(Integer id){
        Item item = itemRepository.load(id);
        List<Topping> toppingList = toppingRepository.findAll();
        item.setToppingList(toppingList);
        return item;
    }
}
