package com.example.demos.controller;

import com.example.demos.model.Call;
import com.example.demos.service.CallService;
import com.example.demos.service.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/calls")
public class CallControler {
    private final CallService callService;
    private final OperatorService operatorService;
    private int id;

    public CallControler(CallService callService, OperatorService operatorService) {
        this.callService = callService;
        this.operatorService = operatorService;
    }

    @GetMapping
    public String getCalls(Model model) {
        List<Call> calls = callService.getAll();
        model.addAttribute("call", calls);
        return "calls";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String byOp(@PathVariable(value = "id") Integer id, Model model) {
        this.id = id;
        List<Call> calls = operatorService.getOpCallsByOpId(id);
        model.addAttribute("call", calls);
        return "calls";
    }

    @RequestMapping(value = "/datepicker", method = RequestMethod.POST)
    public String datepicker(@RequestParam(value = "startDate") String start,
                             @RequestParam(value = "endDate") String end,
                             @RequestParam(value = "dir") String dir,
                             Model model) {
        List<Call> calls = callService.getAllByDate(start, end, dir, id);
        model.addAttribute("call", calls);
        return "calls";
    }
}
