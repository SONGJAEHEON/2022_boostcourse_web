package kr.or.connect.reservation.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Display_info;
import kr.or.connect.reservation.dto.Id;
import kr.or.connect.reservation.service.MainService;

@Controller
public class MainController {
	@Autowired
	MainService mainService;
	
	@GetMapping(path="/main")
	public String list(ModelMap model) {
		
		List<Promotion> listPromotion = mainService.getPromotions();
		List<Category> listCategory = mainService.getCategories();
		List<Display_info> listProduct = mainService.getDisplay_infos(0, 0);
		int listProductCnt = mainService.getCount(0);
		
		
		Map<String, Object> map = new HashMap<>();
		model.addAttribute("listPromotion", listPromotion);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listProductCnt", listProductCnt);
		
		return "main";
	}	
}