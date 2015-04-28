package com.springapp.mvc.controllers;

import com.springapp.mvc.dal.dao.impl.HibernateRecordDao;
import com.springapp.mvc.dal.entities.Record;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello spring!");

        HibernateRecordDao recordDao = new HibernateRecordDao();
        List<Record> recordsList = recordDao.findAll();
        if (recordsList.size() > 0) {
            model.addAttribute("firstRecord", recordsList.get(0));
        }
		return "hello";
	}
}