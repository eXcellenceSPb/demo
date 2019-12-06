package com.example.demos.config;

import com.example.demos.model.Call;
import com.example.demos.model.Operator;
import com.example.demos.service.CallService;
import com.example.demos.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Setup {

    private OperatorService operatorService;
    private CallService callService;

    @Autowired
    public Setup(OperatorService operatorService, CallService callService) {
        this.operatorService = operatorService;
        this.callService = callService;
    }

    public void init() {
        Operator operator = new Operator("Testname");
        Operator operator2 = new Operator("April");

        Calendar date = new GregorianCalendar(2019, Calendar.MARCH, 11);
        Calendar date2 = new GregorianCalendar(2019, Calendar.APRIL, 12);
        Calendar date3 = new GregorianCalendar(2019, Calendar.MAY, 15);
        Calendar date4 = new GregorianCalendar(2019, Calendar.JUNE, 16);
        Calendar date5 = new GregorianCalendar(2019, Calendar.DECEMBER, 3);

        Call call = new Call("Input", 123, "Ivan", date, "---");
        Call call2 = new Call("Input", 32167, "Vasiliy", date2, "testcall");
        Call call3 = new Call("Output", 8800, "May", date3, "no");
        Call call4 = new Call("Output", 5553535, "Firm", date4, "Need money");
        Call call5 = new Call("Input", 11111, "Job", date5, "Work");

        callService.addCall(call);
        callService.addCall(call2);
        callService.addCall(call3);
        callService.addCall(call4);
        callService.addCall(call5);

        List<Call> col = new ArrayList<>();
        col.add(call);
        col.add(call3);
        col.add(call5);
        operator.setCalls(col);

        List<Call> col2 = new ArrayList<>();
        col2.add(call2);
        col2.add(call4);
        operator2.setCalls(col2);

        operatorService.addOP(operator);
        operatorService.addOP(operator2);
    }
}
