package com.spring.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.service.BbsService;
import com.spring.vo.FindCriteria;
import com.spring.vo.PageCriteria;
import com.spring.vo.PagingMaker;

@Controller
@RequestMapping("/fbbs/*")
public class FindController {
	
	private static final Logger logger = Logger.getLogger(FindController.class);
	
	@Inject 
	private BbsService bsvc;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(@ModelAttribute("findCriteria") FindCriteria findCriteria
					,HttpServletRequest request
					,Model model) throws Exception{
		
		logger.info("list findCriteria >> " + findCriteria.toString());
		
//		model.addAttribute("list", bsvc.listCriteria(findCriteria));
		model.addAttribute("list",bsvc.listFind(findCriteria));
		
		PagingMaker pagingMaker = new PagingMaker();
		pagingMaker.setPageCriteria(findCriteria);
//		pagingMaker.setTotalData(bsvc.listCountData(findCriteria));
		pagingMaker.setTotalData(bsvc.findCountData(findCriteria));
		
		model.addAttribute("pagingMaker", pagingMaker);
		
		
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void readPage(@RequestParam("bid") int bid
					,@ModelAttribute("findCriteria") FindCriteria findCriteria
					,Model model) throws Exception{
		
		model.addAttribute(bsvc.read(bid)); 
	}
	
	@RequestMapping(value="/delPage", method=RequestMethod.GET)
	public String delPage(@RequestParam("bid") int bid
						, FindCriteria findCriteria
						, RedirectAttributes reAttr) throws Exception{
		bsvc.remove(bid);
		
		reAttr.addAttribute("page", findCriteria.getPage());
		reAttr.addAttribute("numPerPage", findCriteria.getNumPerPage());
		reAttr.addAttribute("findType", findCriteria.getFindType());
		reAttr.addAttribute("keyword", findCriteria.getKeyword());
		
		reAttr.addFlashAttribute("result", "data delete success");
		
		return "redirect:/fbbs/list";
	}

}
