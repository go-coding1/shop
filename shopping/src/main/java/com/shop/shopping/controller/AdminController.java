package com.shop.shopping.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.shopping.domain.CategoryVO;
import com.shop.shopping.domain.GoodsVO;
import com.shop.shopping.domain.GoodsViewVO;
import com.shop.shopping.service.AdminService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Inject
	private AdminService adminService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//관리자 화면 get
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception{
		logger.info("get index");
	}
	
	//상품등록
	@RequestMapping(value="/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception{
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
	}
	
	//상품등록
	@RequestMapping(value="/goods/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo) throws Exception{
		adminService.register(vo);
		
		return "redirect:/admin/index";
	}
	
	//상품목록
	@RequestMapping(value="/goods/list", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception{
		logger.info("get goods list");
		
		List<GoodsVO> list = adminService.goodslist();
		
		model.addAttribute("list", list);
	}
	
	//상품 조회
	@RequestMapping(value = "/goods/view", method = RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods view");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		
		model.addAttribute("goods", goods);
	}
	
	//상품 수정
	@RequestMapping(value="/goods/modify", method=RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception{
		logger.info("get goods modify");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
	}
	
	//상품 수정
	@RequestMapping(value="/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo) throws Exception{
		logger.info("post goods modify");
		
		adminService.goodsModify(vo);
		
		return "redirect:/admin/index";
	}
	
	//상품 삭제
	@RequestMapping(value="/goods/delete", method=RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception{
		logger.info("post goods delete");
		
		adminService.goodsDelete(gdsNum);
		return "redirect:/admin/index";
	}
}
