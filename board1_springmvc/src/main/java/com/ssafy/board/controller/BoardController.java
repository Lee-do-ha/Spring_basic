package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.Session;
import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/article")
public class BoardController {
	
	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@GetMapping("/write")
	public String write(Map<String, String> map, Model model) {
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(BoardDto boarddto, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		MemberDto memberdto = (MemberDto) session.getAttribute("userinfo");
		boarddto.setUserId(memberdto.getUserId());
		boardService.writeArticle(boarddto);
		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		return "redirect:/article/list";
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<BoardDto> list = boardService.listArticle(map);
		PageNavigation pageNavigation = boardService.makePageNavigation(map);
		
		mav.addObject("articles", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("/board/list");
		return mav;
	}
	
	@GetMapping("/view")
	public ModelAndView view(@RequestParam int articleno) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		BoardDto boarddto = new BoardDto();
		boarddto = boardService.getArticle(articleno);
		
		mav.addObject("article", boarddto);
		mav.setViewName("board/view");
		return mav;
	}
	
	@GetMapping("/modify")
	public ModelAndView modify(@RequestParam int articleno) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		BoardDto boarddto = new BoardDto();
		boarddto = boardService.getArticle(articleno);
		mav.addObject("article", boarddto);
		mav.setViewName("board/modify");
		
		return mav;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int articleno) throws Exception {
		boardService.deleteArticle(articleno);
		
		return "redirect:/article/list?pgno=1&key=&word=";
	}
	
	@PostMapping("/modify")
	public String modify(HttpSession session , int articleno, @RequestParam String subject, @RequestParam String content) throws Exception {
		BoardDto boarddto = new BoardDto();
		MemberDto memberdto = (MemberDto) session.getAttribute("userinfo");
		
		boarddto.setArticleNo(articleno);
		boarddto.setSubject(subject);
		boarddto.setContent(content);
		boarddto.setUserId(memberdto.getUserId());
		
		boardService.modifyArticle(boarddto);
		
		String path = "redirect:/article/view?articleno=" + articleno;
		
		return path;
	}
	

}
