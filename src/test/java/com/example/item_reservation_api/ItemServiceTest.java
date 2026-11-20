package com.example.item_reservation_api;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    void 備品の一覧を取得できる() {
        // 準備：findAll()が呼ばれたら、備品2件のリストを返すように設定する
        Item notebook = new Item();
        notebook.setId(1);
        notebook.setName("ノートPC");
        notebook.setStock(5);

        Item monitor = new Item();
        monitor.setId(2);
        monitor.setName("モニター");
        monitor.setStock(0);

        List<Item> items = List.of(notebook, monitor);
        when(itemRepository.findAll()).thenReturn(items);

        // 実行
        List<Item> result = itemService.getAllItems();

        // 確認
        assertEquals(items, result);
    }

    @Test
    void IDを指定して備品を取得できる() {
        Item notebook = new Item();
        notebook.setId(1);
        notebook.setName("ノートPC");
        when(itemRepository.findById(1)).thenReturn(Optional.of(notebook));

        Item result = itemService.getItemById(1);

        assertEquals("ノートPC", result.getName());
    }

    @Test
    void 存在しないIDを指定すると例外になる() {
        when(itemRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> itemService.getItemById(999));
    }

    @Test
    void 備品を削除するとRepositoryのdeleteByIdが呼ばれる() {
        itemService.deleteItem(3);

        verify(itemRepository).deleteById(3);
    }
}
