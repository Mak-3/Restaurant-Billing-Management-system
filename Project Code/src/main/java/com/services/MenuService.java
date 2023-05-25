package com.services;

import com.model.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getMenu();

    Menu createMenu(Menu menu);
    Menu getMenuById(int id);

    Menu updateMenu(Menu menu);

    Menu deleteMenuById(int id);
}
