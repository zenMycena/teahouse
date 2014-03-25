package com.mycena.mvc.utils.StringParser.Impl;

import com.mycena.mvc.utils.StringParser.StringParserApi;

public class IceValuePaser implements StringParserApi {

	@Override
	public  String webStringParser(String stringData) {
		switch (stringData) {
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
