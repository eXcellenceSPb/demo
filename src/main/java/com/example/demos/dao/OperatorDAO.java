package com.example.demos.dao;

import com.example.demos.model.Call;
import com.example.demos.model.Operator;

import java.util.List;

public interface OperatorDAO {
    void addOP(Operator operator);

    List<Operator> getAll();

    List<Call> getOpCallsByOpId(int opId);
}
