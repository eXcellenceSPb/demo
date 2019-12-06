package com.example.demos.dao;

import com.example.demos.model.Call;
import com.example.demos.model.Operator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("OperatorDAO")
@Transactional
public class OperatorDAOImpl extends AbstractDAO<Integer, Operator> implements OperatorDAO {

    @Override
    public void addOP(Operator operator) {
        persist(operator);
    }

    @Override
    public List<Operator> getAll() {
        return getEm().createQuery("select a from Operator a", Operator.class)
                .getResultList();
    }

    @Override
    public List<Call> getOpCallsByOpId(int opId) {
        return new ArrayList<>(find(opId).getCalls());
    }

}
