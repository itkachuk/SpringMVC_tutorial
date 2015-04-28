package com.springapp.mvc.dal.dao;

import com.springapp.mvc.dal.entities.Record;

import java.util.List;

/**
 * Created by DELL-PC on 06.04.2015.
 */
public interface RecordDao {

    public void store(Record record);

    public void delete(int recordId);

    public Record findById(int recordId);

    public List<Record> findAll();
}
