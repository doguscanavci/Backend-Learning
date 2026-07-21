package com.workintech.s17d2.rest;

import com.workintech.s17d2.model.*;
import com.workintech.s17d2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    public Map<Integer, Developer> developers;
    private Taxable taxable;

    @Autowired
    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }

    @PostConstruct
    public void init() {
        developers = new HashMap<>();
    }

    @GetMapping
    public List<Developer> getAll() {
        return new ArrayList<>(developers.values());
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable int id) {
        return developers.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Developer add(@RequestBody Developer developer) {
        double salary = developer.getSalary();
        Developer newDeveloper;

        if (developer.getExperience() == Experience.JUNIOR) {
            double tax = salary * taxable.getSimpleTaxRate() / 100;
            newDeveloper = new JuniorDeveloper(developer.getId(), developer.getName(), salary - tax);
        } else if (developer.getExperience() == Experience.MID) {
            double tax = salary * taxable.getMiddleTaxRate() / 100;
            newDeveloper = new MidDeveloper(developer.getId(), developer.getName(), salary - tax);
        } else {
            double tax = salary * taxable.getUpperTaxRate() / 100;
            newDeveloper = new SeniorDeveloper(developer.getId(), developer.getName(), salary - tax);
        }

        developers.put(newDeveloper.getId(), newDeveloper);
        return newDeveloper;
    }

    @PutMapping("/{id}")
    public Developer update(@PathVariable int id, @RequestBody Developer developer) {
        developers.put(id, developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public Developer delete(@PathVariable int id) {
        return developers.remove(id);
    }
}