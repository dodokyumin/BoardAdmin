package kr.ac.kopo.ctc.kopo44.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.domain.BoardItem;

public interface BoardItemService {

	//조회
	BoardItem readOne(String id);
	
	List<BoardItem> readAll(String strcPage);
	
	//페이지 불러오기
	Pagination getPagination(String strcPage);
	
	//입력
	boolean boardItemCreateOne(String title, String content);
	
	// 수정
	BoardItem boardItemUpdateOne(String title, String content, String strId);
	
	// 삭제
	boolean boardItemDeleteOne(String strId);
	
	boolean boardItemDeleteAll();
	
	//총 갯수
	int getRowCount();
	
	//cPage null 체크
	String checkcPage(String strcPage);
	
	//새로운 날짜 받기
	String newDate();
	
	//페이지 null 체크
	public int checkCPage(String strcPage);
	
}
