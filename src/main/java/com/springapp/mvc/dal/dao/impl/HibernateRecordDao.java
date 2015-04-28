package com.springapp.mvc.dal.dao.impl;

import com.springapp.mvc.dal.dao.RecordDao;
import com.springapp.mvc.dal.entities.Record;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by DELL-PC on 08.04.2015.
 */
@Repository("RecordDao")
public class HibernateRecordDao implements RecordDao {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public void store(Record record) {
        sessionFactory.getCurrentSession().saveOrUpdate(record);
    }

    @Override
    @Transactional
    public void delete(int recordId) {
        Record record = (Record) sessionFactory.getCurrentSession().get(Record.class, recordId);
        sessionFactory.getCurrentSession().delete(record);
    }

    @Override
    @Transactional(readOnly = true)
    public Record findById(int recordId) {
        return (Record) sessionFactory.getCurrentSession().get(Record.class, recordId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Record> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from IncomeOrExpenseRecord");
        return query.list();
    }
}
