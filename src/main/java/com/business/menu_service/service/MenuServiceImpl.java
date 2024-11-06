package com.business.menu_service.service;

import com.business.menu_service.entity.Menu;
import com.business.menu_service.exception.ResourceNotFoundException;
import com.business.menu_service.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuRepo menuRepo;


    @Override
    public List<Menu> getAllMenus() {
        return menuRepo.findAll();
    }

    public Menu addMenu(Menu menu) {
        return menuRepo.save(menu);
    }

    public Menu updateMenu(Integer id, Menu menuDetails) {
        Menu menu = menuRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu not found with id " + id));

        menu.setItemName(menuDetails.getItemName());
        menu.setPrice(menuDetails.getPrice());
        return menuRepo.save(menu);
    }

    public void deleteMenu(Integer id) {
        if (menuRepo.existsById(id)) {
            menuRepo.deleteById(id);
        } else {
            throw new RuntimeException("Menu không tồn tại.");
        }
    }

}
