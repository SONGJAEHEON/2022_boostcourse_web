package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.Display_infoDao;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Display_info;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.MainService;


import org.springframework.transaction.annotation.Transactional;

@Service
public class MainServiceImpl implements MainService{
	@Autowired
	PromotionDao promotionDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Display_infoDao display_infoDao;
	
	@Override
	@Transactional
	public List<Promotion> getPromotions() {
		List<Promotion> list = promotionDao.getPromotions();
		
		return list;
	}
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		List<Category> list = categoryDao.selectAll();
		
		return list;
	}

	@Override
	@Transactional
	public List<Display_info> getDisplay_infos(int cat, int start) {
		List<Display_info> list;
		if(cat == 0)
			list = display_infoDao.selectAll(start, MainService.LIMIT);
		else
			list = display_infoDao.selectSpecific(cat, start, MainService.LIMIT);
		
		return list;
	}

	@Override
	@Transactional
	public int getCount(int cat) {
		return display_infoDao.selectCount(cat);
	}	
}
