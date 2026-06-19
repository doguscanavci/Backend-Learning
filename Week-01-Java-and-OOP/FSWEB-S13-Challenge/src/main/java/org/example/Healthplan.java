package org.example;

import org.example.enums.Plan;

public class Healthplan {
    private Integer id;      // int → Integer
    private String name;
    private Plan plan;

    public Healthplan(Integer id, String name, Plan plan) {
        this.id = id;
        this.name = name;
        this.plan = plan;
    }

    public Integer getId()     { return id; }  // int → Integer
    public String getName()    { return name; }
    public Plan getPlan()      { return plan; }

    public void setId(Integer id)      { this.id = id; }
    public void setName(String name)   { this.name = name; }
    public void setPlan(Plan plan)     { this.plan = plan; }

    @Override
    public String toString() {
        return "Healthplan{id=" + id + ", name=" + name + ", plan=" + plan.getName() + ", price=" + plan.getPrice() + "}";
    }
}