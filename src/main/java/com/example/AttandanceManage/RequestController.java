package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class RequestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/timeManagemant", params = "attendance", method = RequestMethod.POST)
    public ModelAndView attendance(){
        ModelAndView model = new ModelAndView();
        String sql = "INSERT INTO attendances (id, begin_time) VALUES ((SELECT count(*) + 1 FROM attendances), CURRENT_TIME)";
        jdbcTemplate.update(sql);
        System.out.println("出勤");
        model.setViewName("timeManagemant");
        return model;

    }
}
