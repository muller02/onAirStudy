package com.kh.onairstudy.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.onairstudy.member.model.dao.MemberDAO;

/*@Transactional(propagation = Propagation.REQUIRED,
isolation = Isolation.READ_COMMITTED,
rollbackFor = Exception.class)*/
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
}
