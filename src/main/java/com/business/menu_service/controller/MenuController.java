package com.business.menu_service.controller;

import com.business.menu_service.dto.MenuDTO;
import com.business.menu_service.entity.Menu;
import com.business.menu_service.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/add")
    public ResponseEntity<Menu> addMenu(@RequestBody MenuDTO menuDTO) {
        try {
            Menu menu = new Menu();
            menu.setItemName(menuDTO.getItemName());
            menu.setPrice(menuDTO.getPrice());

            Menu savedMenu = menuService.addMenu(menu);
            return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/all")
    public ResponseEntity<List<Menu>> getAllMenus() {
        try {
            List<Menu> menus = menuService.getAllMenus();
            if (menus.isEmpty()) {
                return ResponseEntity.noContent().build(); // Nếu danh sách rỗng, trả về mã 204 (No Content)
            }
            return ResponseEntity.ok(menus); // Trả về danh sách giá kèm mã 200 (OK)
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Trả về lỗi 500 (Internal Server Error)
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Integer id, @RequestBody MenuDTO menuDTO) {
        Menu newMenu = new Menu();
        newMenu.setItemName(menuDTO.getItemName());
        newMenu.setPrice(menuDTO.getPrice());

        Menu updatedMenu = menuService.updateMenu(id, newMenu);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Integer id) {
        try {
            menuService.deleteMenu(id);
            return ResponseEntity.ok("Menu đã được xóa thành công.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi xóa menu: " + e.getMessage());
        }
    }


}
