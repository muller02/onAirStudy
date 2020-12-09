package com.kh.onairstudy.attendance.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.onairstudy.attendance.model.service.AttendanceService;
import com.kh.onairstudy.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService; 
	

	@RequestMapping("/attend/check.do")
	public String attendCheck(@RequestParam("roomNum") int roomNum,
							  RedirectAttributes redirectAttr, HttpSession session ) {
		
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		Map<String, Object> param = new HashMap<>();
		param.put("memberId", loginMember.getMemberId());
		param.put("roomNum", roomNum);
		
		int result = attendanceService.updateAttendance(param);
		String msg = result == 0 ? "출석체크에 실패하였습니다." : "출석체크에 성공하였습니다";
		
		redirectAttr.addAttribute("roomNum"	, roomNum);
		redirectAttr.addFlashAttribute("msg", msg);
		
		if(result == 1) {
			session.setAttribute("attendAlready", "yes");
		}
		
		return "redirect:/studyroom/main.do";
	}
	
	@RequestMapping("/studyroom/exit.do")
	public String exitRoom() {
		return "redirect:/mypage1_index.do";
	}
	
}
