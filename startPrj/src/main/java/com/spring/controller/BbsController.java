package com.spring.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.service.BbsService;
import com.spring.vo.BbsVO;
import com.spring.vo.PageCriteria;
import com.spring.vo.PagingMaker;

@Controller
@RequestMapping("/bbs/*")
public class BbsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Inject
	private BbsService bsvc;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void writeGET(BbsVO bvo, Model model) throws Exception{
		logger.info("write GET....");
		System.out.println("aaaaaa");
		
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
//	public String wirtePOST(BbsVO bvo, Model model) throws Exception{
	public String wirtePOST(BbsVO bvo, RedirectAttributes reAttr) throws Exception{
		logger.info("write POST ...");
		logger.info(bvo.toString()); 
		
		bsvc.write(bvo);
		
//		model.addAttribute("result","success");
//		model.addAttribute("test1","test1");
		reAttr.addFlashAttribute("result", "success");
		
//		return "/bbs/resultOk";
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) throws Exception{
		logger.info("글목록 가져오기...");
		
		model.addAttribute("list", bsvc.list());
		
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bid") int bid, Model model) throws Exception{
		System.out.println("bis >> " + bid);
		model.addAttribute(bsvc.read(bid)); //addAttribute에서 key를 사용하지 않았을 경우 key는 클래스의 이름을 자동으로 소문자로 시작해서 저장한다.
		
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void list(@RequestParam("bid") int bid
					, @ModelAttribute("pageCriteria") PageCriteria pageCriteria
					, Model model) throws Exception{
		
		model.addAttribute(bsvc.read(bid));
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("bid") int bid, RedirectAttributes reAttr) throws Exception{
		
		bsvc.remove(bid);
		
		reAttr.addFlashAttribute("result", "data delete success");
		
		return "redirect:/bbs/list"; 
		
	}
	
	@RequestMapping(value="/delPage", method=RequestMethod.GET)
	public String delPage(@RequestParam("bid") int bid
							, PageCriteria pageCriteria
							, RedirectAttributes reAttr) throws Exception{
		bsvc.remove(bid);
		
		reAttr.addAttribute("page", pageCriteria.getPage());
		reAttr.addAttribute("numPerPage", pageCriteria.getNumPerPage());
		
		reAttr.addFlashAttribute("result", "data delete success");
		
		return "redirect:/bbs/pageList";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bid, Model model) throws Exception{
		model.addAttribute(bsvc.read(bid));
	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyGET(@RequestParam("bid") int bid
							,@ModelAttribute("pageCriteria") PageCriteria pageCriteria
							,Model model) throws Exception{
		
		model.addAttribute(bsvc.read(bid));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BbsVO bvo, RedirectAttributes reAttr) throws Exception{
		logger.info("modify post .......");
		
		bsvc.modify(bvo);
		
		reAttr.addFlashAttribute("result"," modify success");
		
		return "redirect:/bbs/list";
		
	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPOST(BbsVO bvo
					, PageCriteria pageCriteria
					, RedirectAttributes reAttr) throws Exception{
		
		bsvc.modify(bvo);
		
		reAttr.addAttribute("page", pageCriteria.getPage());
		reAttr.addAttribute("numPerPage", pageCriteria.getNumPerPage());
		
		reAttr.addFlashAttribute("result"," modify success");
		
		return "redirect:/bbs/pageList";
		
		
	}
	
	@RequestMapping(value="/pageList", method=RequestMethod.GET)
	public void pageList(PageCriteria pageCriteria, Model model) throws Exception{
		
		logger.info(pageCriteria.toString());
		
		model.addAttribute("list", bsvc.listCriteria(pageCriteria));
		
		PagingMaker pagingMaker = new PagingMaker();
		pagingMaker.setPageCriteria(pageCriteria);
//		pagingMaker.setTotalData(155);
		int countData = bsvc.listCountData(pageCriteria);
		System.out.println("countData >>> " + countData);
		pagingMaker.setTotalData(countData);
		
		model.addAttribute("pagingMaker", pagingMaker);
		
		
		
	}
	

}
