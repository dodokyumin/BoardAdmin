package kr.ac.kopo.ctc.kopo44.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.domain.BoardItem;

public interface BoardItemDao {
	final static String COULUMN_ID = "id";
	final static String TABLE_NAME = "gongji";
	
	//create
	int createOne(BoardItem BoardItem);
	
	//read
	BoardItem readOne(int id);
	List<BoardItem> readAll(int startIndex, int countPerPage);
	
	//update
	BoardItem updateOne(BoardItem BoardItem);
	
	//delete
	int deleteOne(int id);

	//count rows
	int RowCount();	
	
	//delete all
	int deleteAll();	
}
