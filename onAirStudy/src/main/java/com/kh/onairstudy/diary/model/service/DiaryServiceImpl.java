package com.kh.onairstudy.diary.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kh.onairstudy.diary.model.dao.DiaryDAO;
import com.kh.onairstudy.diary.model.vo.Diary;
import com.kh.onairstudy.diary.model.vo.DiaryAttachment;

@Transactional(propagation = Propagation.REQUIRED,
isolation = Isolation.READ_COMMITTED,
rollbackFor = Exception.class)
//어떠한 예외가 발생해도 rollback해달라는 말!
@Service
public class DiaryServiceImpl implements DiaryService {


	@Autowired
	private DiaryDAO diaryDAO;

	 @Override public List<Diary> selectDiaryList() { 
		 return diaryDAO.selectDiaryList(); 
	}

	@Override
	public int insertDiary(Diary diary) {
		int result = 0;
		//1. board insert
		result = diaryDAO.insertDiary(diary);
		
		//2. attachment insert
//		if(diary.getAttachList() != null) {
//			
//			for(DiaryAttachment attach : diary.getAttachList()) {
//				//생성된 boardNo값 대입하기
//				attach.setDiaryNo(diary.getNo());
//				result = diaryDAO.insertAttachment(attach);
//			}
//			
//		}
		
		
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public Diary selectOneDiary(int no) {
		Diary diary = diaryDAO.selectOneDiary(no); 
		diaryDAO.diaryReadCount(no);
		
		List<DiaryAttachment> attachList = diaryDAO.selectAttachList(no);
		diary.setAttachList(attachList);
		
		return diary;
	}
	

	



	
}
