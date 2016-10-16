package com.bada_admin.controller.board_manage;

public class BoardCommon {
	
	private static BoardCommon current;
	
	public static BoardCommon getInstance() {
		if(current == null) {
			current = new BoardCommon();
		}
		return current;
	}
	
	public static void freeInstance() {
		current = null;
	}
	
	private BoardCommon(){
		super();
	}
	
	public String getBoardName(String category) throws Exception{
		String boardName = null;
		
		if(category.equals("notice")) {
			boardName = "공지사항";
		} else if(category.equals("faq")) {
			boardName = "자주묻는 질문";
		}
		
		if(boardName == null) {
			throw new Exception("존재하지 않는 게시판입니다.");
		}
		
		return boardName;
	}
}
