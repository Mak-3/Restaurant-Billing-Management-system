package com.controller;


import com.model.Menu;
import com.services.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/menu")
public class MenuController {

    @Autowired
    MenuService menuService;


    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @GetMapping
    public List<Menu> getMenu(){
        logger.info("Menu list");
        return menuService.getMenu();
    }
    @PostMapping("/create")
    public Menu createMenu(@RequestBody Menu menu){
        logger.info("create menu is invoked {}",menu);
        return menuService.createMenu(menu);
    }

    @GetMapping("{id}")
    public Menu getMenuById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return menuService.getMenuById(id);
    }

    @PutMapping("/update")
    public Menu updateMenu(@RequestBody Menu menu){
        return menuService.updateMenu(menu);
    }

    @DeleteMapping("/{id}")
    public Menu deleteMenuById(@PathVariable("id") int id){
        return menuService.deleteMenuById((id));
    }
}
