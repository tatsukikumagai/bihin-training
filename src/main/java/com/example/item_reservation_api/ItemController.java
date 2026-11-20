package com.example.item_reservation_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Item findItem(@PathVariable int id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }
}
