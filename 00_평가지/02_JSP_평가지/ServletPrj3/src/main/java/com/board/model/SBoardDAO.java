package com.board.model;

import java.util.ArrayList;

public interface SBoardDAO {
	// board method
	public void boardInsert(SBoardDTO board);

	public void boardUpdate(SBoardDTO board);

	public ArrayList<SBoardDTO> boardList(int startRow, int endRow, String field, String word);

	public ArrayList<SBoardDTO> boardList(); // ¿¸¡¶∫∏±‚ ∆‰¿Ã¬° æ∆¥‘

	public int boardDelete(int num);

	public int boardCount(String field, String word);

	public SBoardDTO findByNum(int num);

	// comment method
	public void commentInsert(SCommentDTO comment);

	public ArrayList<SCommentDTO> findAllComment(int bnum);

	public int commentCount(int bnum);

}
