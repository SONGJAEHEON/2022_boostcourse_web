package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Display_info;
import kr.or.connect.reservation.service.MainService;

public class MainServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		MainService reservationService = ac.getBean(MainService.class);
		
		List<Category> cat = reservationService.getCategories();
		System.out.println("안녕하세요");
	}
}
