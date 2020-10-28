package com.kh.onairstudy.diary.model.service;


import java.util.List; 

import com.kh.onairstudy.diary.model.vo.Diary;
import com.kh.onairstudy.diary.model.vo.DiaryReply;


public interface DiaryService {

	List<Diary> selectDiaryList();


	int insertDiary(Diary diary);


	Diary selectOneDiary(int no);
	List<DiaryReply> selectDiaryReplyList(int diaryNo);




	int insertDiaryReply(DiaryReply diaryReply);


	int deleteDiary(int no);






}
