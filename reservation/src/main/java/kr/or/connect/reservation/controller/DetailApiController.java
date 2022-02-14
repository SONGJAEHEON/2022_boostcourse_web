package kr.or.connect.reservation.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.Detail;
import kr.or.connect.reservation.dto.Detail_DiscountInfo;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.Route;

import kr.or.connect.reservation.service.DetailService;

@RestController
public class DetailApiController {

	@Autowired
	DetailService detailService;
	
	
//	@GetMapping(path="/api/products/{displayInfoId}")
	@GetMapping(path="/detail/route")
	public Map<String, Route> getRoute(@RequestParam(value="id") int id){
		Route route = detailService.getRoute(id);
		
		Map<String, Route> map = new HashMap<>();
		map.put("route", route);
		
		return map;
	}
}
