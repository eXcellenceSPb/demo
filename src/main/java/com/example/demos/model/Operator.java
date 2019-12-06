package com.example.demos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operators", schema = "demo")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "names")
    private String names;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "op_cal",
            joinColumns = {@JoinColumn(name = "op_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "coll_id", referencedColumnName = "id")}
    )
    private List<Call> colls = new ArrayList<>();

    public Operator(){}

    public Operator(String names){
        this.names = names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String name) {
        this.names = name;
    }

    public List<Call> getCalls() {
        return colls;
    }

    public void addCall(Call call){
        this.colls.add(call);
    }

    public void setCalls(List<Call> calls) {
        this.colls = calls;
    }
}
