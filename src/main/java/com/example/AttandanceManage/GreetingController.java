package com.example.AttandanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.List;


@Controller
public class GreetingController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

    @GetMapping("/diligence")
    public String index(Model model) {
		String sql = "SELECT * FROM ATTENDANCES";

		System.out.println(jdbcTemplate.queryForList(sql));
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		model.addAttribute("diligenceList", result);
		return "diligence";
	}

	@GetMapping("/timeManagemant")
	public ModelAndView viewNextPage(){
		ModelAndView model = new ModelAndView();
		model.setViewName("timeManagemant");
		return model;
	}



}