package com.example.demos.controller;

import com.example.demos.model.Operator;
import com.example.demos.service.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private final OperatorService operatorService;

    public MainController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping
    public String getOps(Model model) {
        List<Operator> operators = operatorService.getAll();
        model.addAttribute("operators", operators);
        return "index";
    }

    @RequestMapping(value = "/op/{id}", method = RequestMethod.GET)
    public String byOp(@PathVariable(value = "id") Integer id) {
        return "redirect:/calls/" + id;
    }
}
