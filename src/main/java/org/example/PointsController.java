package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

@Controller
public class PointsController {

    @Autowired
    private PointsService pointsService;

    //Display all points in the list
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("points", PointsService.getPoints());
        return "index";
    }

    //Display of the first n points from the list
    @GetMapping("/:n")
    public String indexN(Model model, int n) {
        model.addAttribute("points", PointsService.getFirstNPoints(n));
        return "index";
    }

    //Calculate and display lengths between points x and y
    @GetMapping("/distance/:x/:y")
    public String distance(Model model, int x, int y) {
        model.addAttribute("distance", PointsService.getDistanceBetweenPoints(x, y));
        return "distance";
    }

    //Add a point with the coordinates (x, y) (x, y) to the list
    @PostMapping("/add/:x/:y")
    public String addPoint(Model model, int x, int y) {
        PointsService.addPoint(new Point(x, y));
        model.addAttribute("points", PointsService.getPoints());
        return "index";
    }

    //delete a point with the id from the list
    @DeleteMapping("/delete/:id")
    public String deletePoint(Model model, int id) {
        PointsService.deletePoint(id);
        model.addAttribute("points", PointsService.getPoints());
        return "index";
    }
}
