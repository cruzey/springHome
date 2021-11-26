package com.edu.util;

import java.io.Serializable;

public class Paging implements Serializable{
	
	//페이지 당 게시물의 수
	public static final int PAGE_SCALE = 10;
	//화면 당 페이지의 수
	public static final int BLOCK_SCALE = 3;

	//현재 페이지 위치
	private int curPage = 0;
	
	//전체 페이지 갯수
	private int totPage = 0;
	//전체 페이지 블록 갯수
	private int totBlock = 0;
	//현재 페이지 블록 
	private int curBlock = 0;
	
	private int prevBlock = 0;	//이전 페이지 블록
	private int nextBlock = 0;	//다음 페이지 블록
	
	private int pageBegin = 0;	//#{start}
	private int pageEnd = 0;	//#{end}
	private int blockBegin = 0;	//현재 페이지 블록의 시작번호
	private int blockEnd = 0;	//현재 페이지 블록의 끝번호

	public Paging(int count, int curPage) {
		curBlock = 1;
		this.curPage = curPage;
		setTotPage(count);
		setTotBlock();
		setPageRange();
		setBlockRange();
	}
	
	public void setBlockRange() {
		curBlock = (int) Math.ceil((curPage - 1) / BLOCK_SCALE) + 1;
		blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
		
		blockEnd = blockBegin + BLOCK_SCALE - 1;
		
		if(blockEnd > totPage) {
			blockEnd = totPage;
		}
		
		prevBlock = (curPage == 1) ? 1 : (curBlock - 1) *BLOCK_SCALE;
		nextBlock = curBlock > totBlock ? (curBlock * BLOCK_SCALE) :
			(curBlock * BLOCK_SCALE) + 1;
	
		if(prevBlock <= 0) {
			prevBlock = 1;
		}
		
		if(nextBlock >= totPage) {
			nextBlock = totPage;
		}
	}
	
	public void setPageRange() {
		pageBegin = (curPage - 1) * PAGE_SCALE + 1;
		pageEnd = pageBegin + PAGE_SCALE - 1;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int count) {
		this.totPage = (int)Math.ceil(count * 1.0 / PAGE_SCALE);
	}

	public int getTotBlock() {
		return totBlock;
	}
	
	//페이지 블록의 갯수 계산
	public void setTotBlock() {
		this.totBlock = (int)Math.ceil((double)totPage / (double)BLOCK_SCALE);
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	
	
	
}
