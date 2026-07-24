package com.workintech.spring17challenge.controller;

import com.workintech.spring17challenge.entity.*;
import com.workintech.spring17challenge.exceptions.ApiException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.workintech.spring17challenge.entity.Course;
import com.workintech.spring17challenge.entity.CourseGpa;
import com.workintech.spring17challenge.entity.Grade;
import com.workintech.spring17challenge.entity.HighCourseGpa;
import com.workintech.spring17challenge.entity.LowCourseGpa;
import com.workintech.spring17challenge.entity.MediumCourseGpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

    public List<Course> courses;

    private LowCourseGpa lowCourseGpa;
    private MediumCourseGpa mediumCourseGpa;
    private HighCourseGpa highCourseGpa;

    @Autowired
    public CourseController(LowCourseGpa lowCourseGpa, MediumCourseGpa mediumCourseGpa, HighCourseGpa highCourseGpa) {
        this.lowCourseGpa = lowCourseGpa;
        this.mediumCourseGpa = mediumCourseGpa;
        this.highCourseGpa = highCourseGpa;
    }

    @PostConstruct
    public void init() {
        courses = new ArrayList<>();
    }

    @GetMapping
    public List<Course> getAll() {
        return courses;
    }

    @GetMapping("/{name}")
    public Course getByName(@PathVariable String name) {
        return courses.stream()
                .filter(c -> c.getName() != null && c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ApiException("Course not found: " + name, HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> add(@RequestBody Course course) {
        if (course.getCredit() == null || course.getCredit() < 0 || course.getCredit() > 4) {
            throw new ApiException("Credit is invalid", HttpStatus.BAD_REQUEST);
        }
        if (course.getName() == null || course.getName().trim().isEmpty()) {
            throw new ApiException("Name is invalid", HttpStatus.BAD_REQUEST);
        }

        // Eğer ders zaten varsa (testlerde setUp tekrar çalıştığı için), eskisini kaldırıp yenisini ekleyelim
        courses.removeIf(c -> c.getName() != null && c.getName().equalsIgnoreCase(course.getName()));

        courses.add(course);

        Map<String, Object> response = new HashMap<>();
        response.put("course", course);
        response.put("totalGpa", calculateGpa(course));
        return response;
    }

    @PutMapping("/{id}")
    public Map<String, Object> update(@PathVariable int id, @RequestBody Course course) {
        int index = findIndexById(id);
        if (index < 0) {
            throw new ApiException("Course not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        if (course.getCredit() != null && (course.getCredit() < 0 || course.getCredit() > 4)) {
            throw new ApiException("Credit must be between 0 and 4", HttpStatus.BAD_REQUEST);
        }

        courses.set(index, course);

        Map<String, Object> response = new HashMap<>();
        response.put("course", course);
        response.put("totalGpa", calculateGpa(course));
        return response;
    }

    @DeleteMapping("/{id}")
    public Course delete(@PathVariable int id) {
        int index = findIndexById(id);
        if (index < 0) {
            throw new ApiException("Course not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        return courses.remove(index);
    }

    private int findIndexById(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() != null && courses.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private double calculateGpa(Course course) {
        if (course == null || course.getCredit() == null || course.getGrade() == null || course.getGrade().getCoefficient() == null) {
            return 0.0;
        }
        int credit = course.getCredit();
        int coefficient = course.getGrade().getCoefficient();

        if (credit <= 2) {
            return coefficient * credit * lowCourseGpa.getGpa();
        } else if (credit == 3) {
            return coefficient * credit * mediumCourseGpa.getGpa();
        } else {
            return coefficient * credit * highCourseGpa.getGpa();
        }
    }
}