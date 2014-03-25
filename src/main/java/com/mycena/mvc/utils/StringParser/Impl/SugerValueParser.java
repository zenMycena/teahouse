package com.mycena.mvc.utils.StringParser.Impl;

import com.mycena.mvc.utils.StringParser.StringParserApi;

public class SugerValueParser implements StringParserApi {

	@Override
	public String webStringParser(String stringData) {
		switch (stringData) {
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

}
