package com.food.k1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.k1.fmember.FmemberService;
import com.food.k1.fmember.FmemberVo;

@Controller
public class FmemberController {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(FmemberController.class);
	
	
	@Autowired
	FmemberService fservice;
	
	


	// 암호화를 위한 메소드 추가
	public static String testSHA256(String pwd) {
		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(pwd.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			// 출력
			return hexString.toString();

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@RequestMapping("/login.do")
	public String login() {
		
		System.out.println("----------------------------------------------------");
		
		System.out.println("-----------------------------------------------------");
		return "/fmember/login.jsp";

	}

	@RequestMapping("/fmemberlist.do")
	public String select() {

		return "/fmember/fmemberlist.jsp";

	}

	@RequestMapping("/fmember_edit.do")
	public String fmember_edit(FmemberVo vo, Model m) {
		m.addAttribute("m", fservice.getfmember(vo));
		return "/fmember/fmemberedit1.jsp";

	}

	@RequestMapping(value = "/membermana.do")
	public String mebermana(FmemberVo vo, Model m) {
		if (vo.getStartIdx() == 0) {
			vo.setStartIdx(1);
		}
		if (vo.getCh2() != null && vo.getCh2() == "") {
			vo.setCh2(vo.getCh2().toLowerCase());
		}

		int totalPage = (int) Math.ceil(fservice.totalcount(vo) / 10.0);
		int nowPage = vo.getStartIdx() / 10 + 1;
		int pageSize = 10;
		int pageListSize = 10;
		int startListPage = (nowPage - 1) / pageListSize * pageListSize + 1;
		int endListPage = startListPage + pageListSize - 1;
		if (endListPage >= totalPage) {
			endListPage = totalPage;
		}

		m.addAttribute("startIdx", vo.getStartIdx());
		m.addAttribute("totalPage", totalPage);
		m.addAttribute("nowPage", nowPage);
		m.addAttribute("endPage", (totalPage - 1) * 10 + 1);
		m.addAttribute("ch1", vo.getCh1());
		m.addAttribute("ch2", vo.getCh2());
		m.addAttribute("startListPage", startListPage);
		m.addAttribute("endListPage", endListPage);
		m.addAttribute("pageListSize", pageListSize);
		m.addAttribute("pageSize", pageSize);
		m.addAttribute("tc", fservice.totalcount(vo));
		m.addAttribute("m1", fservice.getfmemberList(vo));
		
		
		
		
		return "/fmember/fmembermana.jsp";

	}

	// admin 관리자가 목록에서 회원을삭제하기위해
	@RequestMapping("fmemberdel.do")
	public void fmemberdel(FmemberVo vo, HttpServletResponse response) throws Exception {
		System.out.println("================================================");
		System.out.println("삭제확인");
		System.out.println("================================================");
		fservice.delete(vo);
		PrintWriter out = response.getWriter();
		out.println("success"); // 처리결과 반환
	}

	// 관리자가 아닌회원자신의 설정 삭제
	@RequestMapping("/fmemberdel1.do")
	public void fmemberdel1(FmemberVo vo, HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println("삭제확인");
		fservice.delete(vo);
		PrintWriter out = response.getWriter();
		out.println("success");
		session.invalidate();

	}

	// 관리자가 아닌 회원자신의 설정 수정
	@RequestMapping("/fmemberupdate1.do")
	public String fmemberupdate(FmemberVo vo) {
		System.out.println("================================Controller IN========================================");
		String pwd = testSHA256(vo.getFpwd());
		vo.setFpwd(pwd);

		if (vo.getFjender().equals("m")) {
			vo.setFjender("남자");
		} else if (vo.getFjender().equals("w")) {
			vo.setFjender("여자");
		}

		System.out.println(vo.getFjender());

		System.out.println("회원수정");
		fservice.update(vo);

		return "/fmember/fmemberlist.jsp";

	}

	@RequestMapping("/login1.do")
	public String login1(FmemberVo vo, HttpSession session) {
		log.debug("로그인확인");
		String pwd = testSHA256(vo.getFpwd());
		vo.setFpwd(pwd);
		FmemberVo vo1 = fservice.login(vo);
		if (vo1 != null) {
			session.setAttribute("fid", vo1.getFid());
			session.setAttribute("fcustno", vo1.getFcustno());
			session.setAttribute("fname", vo1.getFname());
		
			log.debug(vo.toString());
			return "/fmemberlist.do";
		} else {
			return "/fmember/login.jsp";
		}
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션을 죽이기
		
		return "/index.jsp";

	}

	@RequestMapping("/membership.do")
	public String membership() {
		return "/fmember/membership.jsp";

	}

	@RequestMapping("/memberOk.do")
	public void memberOk(FmemberVo vo, HttpServletResponse response) throws Exception {
		
		System.out.println("저장확인");
		System.out.println("저장테스트");

		String pwd = testSHA256(vo.getFpwd()); // 암호화메소드를만들어 비번번호를 암호화하여 저장할수있게
		vo.setFpwd(pwd);

		if (vo.getFjender().equals("m")) {
			vo.setFjender("남자");
		} else if (vo.getFjender().equals("w")) {
			vo.setFjender("여자");
		}

		System.out.println(vo.getFjender());
		fservice.insert(vo);
		PrintWriter out = response.getWriter();
		out.println("success");

	}
	
	@RequestMapping("/memberck.do")
	public void memberck(FmemberVo vo, HttpServletResponse response) throws Exception {
		
		
		System.out.println(vo.getFid());

		
		FmemberVo vo2 = fservice.fmemberck(vo);
		
		int flag = 0;
		if(vo2 != null ) {
			flag= 0;
		}
		else {
			flag = 100;
		}
		
		PrintWriter out =response.getWriter();
		out.println(flag);
		log.info("로그찍어보기");
		log.debug("=============================로그======================");
		

	
		
//		Map<String,Object> resultmap = new LinkedHashMap<String, Object>();
//		if(vo2 != null) {
//			
//			resultmap.put("flag", 1);
//			resultmap.put("message","아이디가 중복됩니다..");
//			
//		
//			
//		}
//		else  {
//			resultmap.put("flag", 100);
//			resultmap.put("message","사용가능한 아이디입니다 .");
//			
//		}
//		
//		
//		
//		return resultmap;
	
	}

}
