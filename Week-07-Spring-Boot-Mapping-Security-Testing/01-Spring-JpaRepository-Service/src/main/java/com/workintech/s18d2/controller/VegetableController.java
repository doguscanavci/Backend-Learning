package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.services.VegetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAllAsc() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        if (id < 0) throw new PlantException("Id cannot be negative", HttpStatus.BAD_REQUEST);
        return vegetableService.getById(id);
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable) {
        if (vegetable.getName() == null || vegetable.getPrice() == null) {
            throw new PlantException("Name and price cannot be null", HttpStatus.BAD_REQUEST);
        }
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> searchByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id) {
        if (id < 0) throw new PlantException("Id cannot be negative", HttpStatus.BAD_REQUEST);
        return vegetableService.delete(id);
    }
}