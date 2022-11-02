package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

@Controller
public class PointsController {
    //get all points from list
    @GetMapping("/")
    public String viewHomePageWithAllPointsFromTheList(Model model){
        model.addAttribute("listPoints", PointsService.getPoints());
        return "index";
    }
    //get first n points from list
    @GetMapping("/:n")
    public String viewHomePageWithFirstNPointsFromTheList(Model model){
        model.addAttribute("listPoints", PointsService.getFirstNPoints(5));
        return "index";
    }
    //Calculate and display lengths between points
    @GetMapping("/distance/:x/:y")
    public String viewHomePageWithLengthsBetweenPoints(Model model){
        model.addAttribute("distance", PointsService.getDistanceBetweenPoints(Integer.parseInt(model.getAttribute("x").toString()), Integer.parseInt(model.getAttribute("y").toString())));
        return "index";
    }
    //Add a point with the coordinates (x, y) to the list
    @PostMapping("/add")
    public String addPointToTheList(Model model){
        PointsService.addPoint(new Point(Integer.parseInt(model.getAttribute("x").toString()), Integer.parseInt(model.getAttribute("y").toString())));
        return "redirect:/";
    }
    //delete point with id from the list
    @DeleteMapping("/delete/:id")
    public String deletePointFromTheList(Model model){
        PointsService.deletePoint(Integer.parseInt(model.getAttribute("id").toString()));
        return "redirect:/";
    }
}
