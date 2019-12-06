package com.example.demos.dao;

import com.example.demos.model.Call;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository("CallDAO")
@Transactional
public class CallDAOImpl extends AbstractDAO<Integer, Call> implements CallDAO {

    @Override
    public void addCall(Call call) {
        persist(call);
    }

    @Override
    public List<Call> getAll() {
        return getEm().createQuery("select a from Call a", Call.class)
                .getResultList();
    }

    @Override
    public Call getCall(Integer callId) {
        return find(callId);
    }

    @Override
    public List<Call> findCallByDirection(String dir) {
        return getEm().createQuery("select a from Call a where a.direction =:dir", Call.class)
                .setParameter("dir", dir).getResultList();
    }

    @Override
    public boolean isExist(Integer number) {
        Query query = getEm().createQuery("select case when count (e)>0 " +
                "then true " +
                "else false end from Call e where e.number =:number", Boolean.class);
        query.setParameter("number", number);
        return (Boolean) query.getSingleResult();
    }

    @Override
    public List<Call> getAllByDate(String start, String end, String dir, int id) {
        if (id == 0) {
            DateFormat formatter;
            Date date = null;
            Date date1 = null;
            Calendar cal = new GregorianCalendar();
            Calendar cal1 = new GregorianCalendar();
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = formatter.parse(start);
                cal.setTime(date);
                date1 = formatter.parse(end);
                cal1.setTime(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return getEm().createQuery("SELECT e FROM Call e WHERE e.date BETWEEN :start AND :end and e.direction =:dir", Call.class)
                    .setParameter("start", date, TemporalType.DATE)
                    .setParameter("end", date1, TemporalType.DATE)
                    .setParameter("dir", dir)
                    .getResultList();
        }
        if (start.isEmpty() | end.isEmpty()) {
            return getEm().createQuery("SELECT e FROM Call e WHERE e.direction =:dir", Call.class)
                    .setParameter("dir", dir)
                    .getResultList();
        } else {
            DateFormat formatter;
            Date date = null;
            Date date1 = null;
            Calendar cal = new GregorianCalendar();
            Calendar cal1 = new GregorianCalendar();
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = formatter.parse(start);
                cal.setTime(date);
                date1 = formatter.parse(end);
                cal1.setTime(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Query query = getEm().createNativeQuery("select * from coll where id = ANY (select coll_id from op_cal where op_id=:pid) and coll.date BETWEEN :start AND :end and coll.direction =:dir", Call.class)
                    .setParameter("pid", id)
                    .setParameter("start", date, TemporalType.DATE)
                    .setParameter("end", date1, TemporalType.DATE)
                    .setParameter("dir", dir);
            return query.getResultList();
        }
    }
}