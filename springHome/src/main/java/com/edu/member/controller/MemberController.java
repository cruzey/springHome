package com.edu.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.member.model.MemberVo;
import com.edu.member.service.MemberService;
import com.edu.util.Paging;

@Controller
public class MemberController {

		private static final Logger logger 
			= LoggerFactory.getLogger(MemberController.class);

		@Autowired
		private MemberService memberService;
		
		//로그인 화면으로
		@RequestMapping(value = "/login.do", method = RequestMethod.GET)
		public String login(HttpSession session, Model model) {
			logger.info("Welcome MemberController! login");
			
			return "auth/LoginForm";
		}
		
		//로그인 버튼 클릭시
		@RequestMapping(value = "/loginCtr.do", method = RequestMethod.POST)
		public String loginCtr(String email, String password, HttpSession session, Model model) {
			logger.info("Welcome MemberController! loginCtr! " + email + ", " + password);
			
			MemberVo memberVo = memberService.memberExist(email, password);
			
			if(memberVo != null) {
				session.setAttribute("member", memberVo);
				return "redirect:/member/list.do";
			}else {
				return "/auth/LoginFail";	
			}
				
		}
		
		//로그아웃
		@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
		public String logout(HttpSession session, Model model) {
			logger.info("Welcome MemberController! logout");
			
			session.invalidate();
			
			return "redirect:/login.do";
		}

		//회원 리스트 화면으로
		@RequestMapping(value = "/member/list.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String memberList(@RequestParam(defaultValue = "1") int curPage
				,@RequestParam(defaultValue = "") String keyword
				,@RequestParam(defaultValue = "") String searchOption, Model model) {
			logger.info("Welcome MemberController! memberList keyword: {}", keyword);
			
			int totalCount = memberService.memberSelectTotalCount();
			
			//페이지 나누기 관련 처리
			Paging memberPaging = new Paging(totalCount, curPage);
			int start = memberPaging.getPageBegin();
			int end = memberPaging.getPageEnd();
			
			List<MemberVo> memberList = 
					memberService.memberSelectList(searchOption, keyword, start, end);
			
			HashMap<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("keyword", keyword);
			searchMap.put("searchOption", searchOption);
			
			Map<String, Object> pagingMap = new HashMap<String, Object>();
			pagingMap.put("totalCount",  totalCount);
			pagingMap.put("memberPaging",  memberPaging);
			

			model.addAttribute("memberList", memberList);
			model.addAttribute("pagingMap", pagingMap);
			model.addAttribute("searchMap", searchMap);
			
			return "member/MemberListView";
		}
		
		//회원추가 화면으로
		@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
		public String memberAdd(Model model) {
			logger.info("Welcome MemberController! memberAdd");
			
			return "member/MemberForm";
		}
		
		//회원등록
 		@RequestMapping(value = "/member/addCtr.do", method = RequestMethod.POST)
		public String memberAdd(MemberVo memberVo, Model model) {
			logger.info("Welcome MemberController!  memberAdd" + memberVo);
			
			memberService.memberInsertOne(memberVo);
			
			return "redirect:/member/list.do";
		}
 		
 		//회원수정 회면으로
 		@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
		public String memberUpdate(int no, Model model) {
			logger.info("Welcome MemberController!  memberUpdate no: " + no);
			
			MemberVo memberVo = memberService.memberSelectOne(no);
			
			model.addAttribute("memberVo", memberVo);
			
			return "member/MemberUpdateForm";
		}
 		
 		//회원수정
 		@RequestMapping(value = "/member/updateCtr.do", method = RequestMethod.POST)
		public String memberUpdateCtr(MemberVo memberVo, Model model) {
			logger.info("Welcome MemberController!  memberUpdateCtr" + memberVo);
			
			memberService.memberUpdateOne(memberVo);
			
			return "redirect:/member/list.do";
		}

		//회원탈퇴
 		@RequestMapping(value = "/member/deleteCtr.do", method = RequestMethod.GET)
		public String memberDeleteCtr(int no, Model model) {
			logger.info("Welcome MemberController!  memberDeleteCtr no : " + no);
			
			memberService.memberDeleteOne(no);
			
			return "redirect:/member/list.do";
		}
}
