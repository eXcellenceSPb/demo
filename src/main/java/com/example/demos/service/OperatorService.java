package com.example.demos.service;

import com.example.demos.model.Call;
import com.example.demos.model.Operator;

import java.util.List;

public interface OperatorService {
    void addOP(Operator operator);
    List<Operator> getAll();
    List<Call> getOpCallsByOpId(int opId);
}
