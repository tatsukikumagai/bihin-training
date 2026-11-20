package com.example.item_reservation_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(int id) {
        return itemRepository.findById(id).orElseThrow();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(int id, Item item) {
        item.setId(id);
        return itemRepository.save(item);
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
