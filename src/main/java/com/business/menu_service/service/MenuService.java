package com.business.menu_service.service;

import com.business.menu_service.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAllMenus();
    Menu addMenu(Menu menu);

    Menu updateMenu(Integer id, Menu menuDetails);

    void deleteMenu(Integer id);
}
