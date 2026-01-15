// SpringSample4 - com.mbc.pro.util - Util.java
package com.mbc.pro.util;

public class Util {
	// 답글 화살표 이미지
	public static String arrow(int depth){
		String rs = "<img src='./images/arrow.png' width='20px' height='20px'/>";
		String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
		
		String ts = "";
		for (int i = 0; i < depth; i++){
			ts += nbsp;
		}
		return (depth == 0) ? "": (ts + rs);	
	}
	
	// 제목 길 때 뒤에 ...으로 표시
	public static String dot3(String title) {
		String str = "";
		
		if (title.length() >= 35) {
			str = title.substring(0, 35);
			str += "...";
		} else {
			str = title.trim();
		}
		return str;
	}
}