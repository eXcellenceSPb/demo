package com.example.demos.service;

import com.example.demos.dao.CallDAO;
import com.example.demos.model.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("callService")
public class CallServiceImpl implements CallService {
    private final CallDAO callDAO;

    @Autowired
    public CallServiceImpl(CallDAO callDAO) {
        this.callDAO = callDAO;
    }

    @Override
    public void addCall(Call call) {
        callDAO.addCall(call);
    }

    @Override
    public List<Call> getAll() {
        return callDAO.getAll();
    }

    @Override
    public Call getCall(Integer callId) {
        return callDAO.getCall(callId);
    }

    @Override
    public List<Call> findCallByDirection(String dir) {
        return callDAO.findCallByDirection(dir);
    }

    @Override
    public boolean isExist(Integer number) {
        return callDAO.isExist(number);
    }

    @Override
    public List<Call> getAllByDate(String start, String end, String dir,int id) {
       return callDAO.getAllByDate(start, end, dir, id);
    }
}
