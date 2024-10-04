package com.business.menu_service.service;

import com.business.menu_service.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuRepo menuRepo;
}
