package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.Detail;
import kr.or.connect.reservation.dto.Detail_DiscountInfo;
import kr.or.connect.reservation.dto.Route;
import kr.or.connect.reservation.service.DetailService;

@RestController
@CrossOrigin(origins="http://localhost:8080/reservation/*")
public class DetailApiController {

	@Autowired
	DetailService detailService;
	
	
//	@GetMapping(path="/api/products/{displayInfoId}")
	@GetMapping(path="/detailApi")
	public Map<String, Object> getRoute(@RequestParam(value="id") int id){
		Map<String, Object> map = new HashMap<>();
		
		Detail detail = detailService.getDetail(id);
		List<Detail_DiscountInfo> discountListA = detailService.getDetial_DiscountInfos_A(id);
		List<Detail_DiscountInfo> discountListB = detailService.getDetial_DiscountInfos_B(id);
		List<Comment> commentList = detailService.getComments(id, 0);
		Route route = detailService.getRoute(id);
		
		map.put("detail", detail);
		map.put("discountA", discountListA);
		map.put("discountB", discountListB);
		map.put("commentList", commentList);
		map.put("route", route);

		return map;
	}
}
