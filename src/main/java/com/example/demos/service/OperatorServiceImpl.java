package com.example.demos.service;

import com.example.demos.model.Call;
import com.example.demos.model.Operator;
import com.example.demos.dao.OperatorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("operatorService")
public class OperatorServiceImpl implements OperatorService {
    private final OperatorDAO operatorDAO;

    @Autowired
    public OperatorServiceImpl(OperatorDAO operatorDAO) {
        this.operatorDAO = operatorDAO;
    }

    @Override
    public void addOP(Operator operator) {
        operatorDAO.addOP(operator);
    }

    @Override
    public List<Operator> getAll() {
        return operatorDAO.getAll();
    }

    @Override
    public List<Call> getOpCallsByOpId(int opId) {
        return operatorDAO.getOpCallsByOpId(opId);
    }
}
