package com.example.demos.dao;

import com.example.demos.model.Call;
import java.util.List;

public interface CallDAO {
    void addCall(Call call);

    List<Call> getAll();

    Call getCall(Integer callId);

    List<Call> findCallByDirection(String dir);

    boolean isExist(Integer number);

    List<Call> getAllByDate(String start, String end, String dir, int id);
}
