package com.kh.onairstudy.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.onairstudy.report.model.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping
@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;
	
}
