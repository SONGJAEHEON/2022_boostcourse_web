package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.reservation.dto.Detail;
import kr.or.connect.reservation.dto.Detail_DiscountInfo;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.Route;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.DetailService;

@Controller
public class DetailController {
	@Autowired
	DetailService detailService;
	
	@GetMapping(path="/product")
	public String detail(@RequestParam(value="id") int id, ModelMap model) {
		Detail detail = detailService.getDetail(id);
		List<Detail_DiscountInfo> discountListA = detailService.getDetial_DiscountInfos_A(id);
		List<Detail_DiscountInfo> discountListB = detailService.getDetial_DiscountInfos_B(id);
		List<Comment> commentList = detailService.getComments(id, 1);
		Route route = detailService.getRoute(id);
		
		model.addAttribute("detail", detail);
		model.addAttribute("discountA", discountListA);
		model.addAttribute("discountB", discountListB);
		model.addAttribute("commentList", commentList);
		model.addAttribute("route", route);
		
		return "detail";
	}
	
	@GetMapping(path="/product/etcImage")
	@ResponseBody
	public Map<String, List<Promotion>> getEtc(@RequestParam(value="id") int id){
		Map<String, List<Promotion>> map = new HashMap<>();
		map.put("img", detailService.getEtc(id));
		
		return map;
	}
	
	@GetMapping(path="/product/commentInfo")
	public String getCommentInfo(@RequestParam(value="id") int id, ModelMap model){
		Detail detail = detailService.getDetail(id);
		List<Comment> commentList = detailService.getComments(id, 0);
		
		model.addAttribute("detail", detail);
		model.addAttribute("commentList", commentList);
		
		return "detailComment";
	}
	
	@GetMapping(path="/product/commentList")
	@ResponseBody
	public List<Comment> getCommentList(@RequestParam(value="id") int id){
		List<Comment> commentList = detailService.getComments(id, 0);

		return commentList;
	}
}
