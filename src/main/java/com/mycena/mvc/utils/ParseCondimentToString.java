package com.mycena.mvc.utils;

public class ParseCondimentToString {
	static public String sweetnessToString(String sweetness){
		switch (sweetness) {
		case "0":
			return "無糖";
		case "1":		
			return "微糖";
		case "2":
			return "半糖";
		case "3":
			return "少糖";
		case "4":
			return "正常";
		default:
			return "unknow";
		}
	}
	
	static public String iceToString(String ice){
		switch (ice) {
		case "0":
			
			return "去冰";
		case "1":
			
			return "少冰";
		case "2":
	
			return "正常";
		case "3":
	
			return "熱";
		default:
			return "unknow";
		}
		
	}
}
