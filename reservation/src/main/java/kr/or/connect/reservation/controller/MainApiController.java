package kr.or.connect.reservation.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.*;
import kr.or.connect.reservation.service.MainService;

@RestController
@RequestMapping(path="/main")
public class MainApiController {
	@Autowired
	MainService mainService;

	@PostMapping(path="/cat")
	public Map<String, List<Display_info>> getProducts(@RequestBody Id id, HttpServletRequest request){
		List<Display_info> listProduct = mainService.getDisplay_infos(id.getCat(), id.getpId());
		Map<String, List<Display_info>> map = new HashMap<>();
		map.put("list", listProduct);
		
		return map;
	}
	
	@PostMapping(path="/cat_cnt")
	public Map<String, String> getCnt(@RequestBody Id id, HttpServletRequest request){
		String cnt = "" + mainService.getCount(id.getCat());
		Map<String, String> map = new HashMap<>();
		map.put("cnt", cnt);
		
		return map;
	}
	
	@PostMapping(path="/cat_more")
	public Map<String, List<Display_info>> getProductsMore(@RequestBody Id id, HttpServletRequest request){
		List<Display_info> listProduct = mainService.getDisplay_infos(id.getCat(), id.getpId());
		Map<String, List<Display_info>> map = new HashMap<>();
		map.put("list", listProduct);
		
		return map;
	}
}