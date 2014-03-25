package com.mycena.mvc.utils.StringParser.Impl;

import com.mycena.mvc.utils.StringParser.StringParserApi;

public class BeverageTagParser implements StringParserApi {

	@Override
	public String webStringParser(String stringData) {
		switch (stringData) {
		case "1":
			return "原味茶";
		case "2":
			return "熱門排行";
		case "3":
			return "調味茶";
		case "4": 
			return "新鮮茶";
		case "5":
			return "奶香茶";
		case "6":
			return "拿鐵茶";
		case "7":
			return "夏季限定";
		case "8":
			return "冬季限定";
		default:
			return "unknow";
		}
		
//		<option value="1">原味茶</option>
//		<option value="2">熱門排行</option>
//		<option value="3">調味茶</option>
//		<option value="4">新鮮茶</option>
//		<option value="5">奶香茶</option>
//		<option value="6">拿鐵茶</option>
//		<option value="7">夏季限定</option>
//		<option value="8">冬季限定</option>
	}

}
