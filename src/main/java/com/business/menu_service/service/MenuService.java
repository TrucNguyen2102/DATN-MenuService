package com.business.menu_service.service;

import com.business.menu_service.entity.Menu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MenuService {
    Page<Menu> getAllMenus(int page, int size);
    List<Menu> getAllMenus();
    Menu addMenu(Menu menu);

    Menu updateMenu(Integer id, Menu menuDetails);

    void deleteMenu(Integer id);
}
