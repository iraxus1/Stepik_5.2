package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PointsController {
    //get all points from list
    @GetMapping("/")
    public String viewHomePageWithAllPointsFromTheList(Model model){
        return "index";
    }
    //get first n points from list
    @GetMapping("/:n")
    public String viewHomePageWithFirstNPointsFromTheList(Model model){
        return "index";
    }
    //Calculate and display lengths between points
    @GetMapping("/distance/:x/:y")
    public String viewHomePageWithLengthsBetweenPoints(Model model){
        return "index";
    }
    //Add a point with the coordinates (x, y) to the list
    @PostMapping("/add")
    public String addPointToTheList(Model model){
        return "index";
    }
    //delete point with id from the list
    @DeleteMapping("/delete/:id")
    public String deletePointFromTheList(Model model){
        return "index";
    }
}
