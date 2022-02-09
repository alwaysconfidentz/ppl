package com.food.k1.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.food.k1.fboard.FboardService;
import com.food.k1.fboard.FboardVo;
import com.food.k1.fmember.FmemberVo;

@Controller
public class FboardController {

	@Autowired
	FboardService service;

	private String path = "";

	@RequestMapping("/fboard.do")
	public String form() {
		System.out.println("글등록");
		return "/fboard/form.jsp";

	}

	// 글등록을위한 매핑
	@RequestMapping("/insert.do")
	public String finsert(FboardVo vo, HttpServletRequest request) throws Exception {
		System.out.println("등록하기컨트롤1");
		
		
		// 경로잡아주기
		path = request.getSession().getServletContext().getRealPath("./files/");
		System.out.println("path:" + path);
		// 시,분,초
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("HHmmss");

		String time1 = dayTime.format(time);
		String onlyFilename = "";
		String extension = "";

		MultipartFile uploadFile = vo.getUpdateFile();
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path + fileName);

		if (!uploadFile.isEmpty()) { // 업로드파일이 존재하면
			if (f.exists()) {
				System.out.println("동일한 파일이 존재 합니다.");
				// 파일명 확인하기
				onlyFilename = fileName.substring(0, fileName.indexOf("."));

				// 확장자 확인하기
				extension = fileName.substring(fileName.indexOf("."));

				// 파일명 = 파일명 + 시간 + 확장자
				fileName = onlyFilename + "_" + time1 + extension;
				uploadFile.transferTo(new File(path + fileName));

			} else {
				System.out.println("동일한 파일이 존재 하지 않습니다.");
				uploadFile.transferTo(new File(path + fileName));
			}

		}

		vo.setFimg(fileName);
		service.finsert(vo);
		System.out.println("등록하기컨트롤2");
		return "/fboard_list.do";
	}

	// 목록을보기위한 매핑
	@RequestMapping("/fboard_list.do")
	public String getfoodList(FboardVo vo, Model m) {
		System.out.println("리스트컨트롤");
		if (vo.getStartIdx() == 0) {
			vo.setStartIdx(1);
		}
		if (vo.getCh2() != null && vo.getCh2() == "") {
			vo.setCh2(vo.getCh2().toLowerCase());
		}

		int totalPage = (int) Math.ceil(service.fbcount(vo) / 10.0);
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
		m.addAttribute("tc", service.fbcount(vo));
		m.addAttribute("li", service.getFoodList(vo));

		return "/fboard/getfoodlist.jsp";

	}

	// 삭제를하기위한 매핑
	@RequestMapping("/fdelete.do")
	public String fdelte(FboardVo vo, HttpServletRequest request, HttpServletResponse response) throws Exception {

		path = request.getSession().getServletContext().getRealPath("./files/"); // 임시파일 경로잡기
		System.out.println("삭제하기 컨트롤");
		FboardVo str = service.getFood(vo);
		String filename = str.getFimg();
		String delfile = path + filename;
		File f = new File(delfile);
		f.delete();
		service.fdelete(vo);
		return "/fboard_list.do";

	}

	// 수정을하기위해 먼저 자세히보기
	@RequestMapping("/fboard_edit.do")
	public String fboard_edit(FboardVo vo, Model m, FmemberVo vo1) {
		vo.setFcustno(vo1.getFcustno());
		m.addAttribute("m", service.getFood(vo));

		return "/fboard/edit.jsp";
	}

	@RequestMapping("/fboard_update.do")
	public String fupdate(FboardVo vo, HttpServletRequest request) throws Exception {
		System.out.println("업데이트확인");

		path = request.getSession().getServletContext().getRealPath("./files/");

		System.out.println("path:" + path);

		long time = System.currentTimeMillis(); // 시,분,초
		SimpleDateFormat dayTime = new SimpleDateFormat("HHmmss");

		String time1 = dayTime.format(time);
		String onlyFilename = "";
		String extension = "";

		MultipartFile uploadFile = vo.getUpdateFile();
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path + fileName);

		if (!uploadFile.isEmpty()) { // 업로드파일이 존재하면
			if (f.exists()) {
				System.out.println("동일한 파일이 존재 합니다.");
				// 파일명 확인하기
				onlyFilename = fileName.substring(0, fileName.indexOf("."));

				// 확장자 확인하기
				extension = fileName.substring(fileName.indexOf("."));

				// 파일명 = 파일명 + 시간 + 확장자
				fileName = onlyFilename + "_" + time1 + extension;
				uploadFile.transferTo(new File(path + fileName));

			} else {
				System.out.println("동일한 파일이 존재 하지 않습니다.");
				uploadFile.transferTo(new File(path + fileName));
			}

		}

		vo.setFimg(fileName);
		service.fupdate(vo);

		return "/fboard_list.do";

	}

	@RequestMapping("/fsaveinsert.do")
	public void saveinsert(FboardVo vo, HttpServletResponse response, HttpSession session) throws Exception {
		session.getAttribute("fcustno");
		service.saveinsert(vo);
		PrintWriter out = response.getWriter();
		out.println("success");

	}

	@RequestMapping("/savelist.do")
	public String savelist(FboardVo vo, Model m) {
		m.addAttribute("li", service.savelist(vo));
		return "/fboard/savelist.jsp";

	}

}
