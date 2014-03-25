package com.mycena.mvc.utils.StringParser.operate;

import com.mycena.mvc.utils.StringParser.ParserOperte;
import com.mycena.mvc.utils.StringParser.StringParserApi;
import com.mycena.mvc.utils.StringParser.Impl.BeverageTagParser;

public class BeverageTagParserOperate extends ParserOperte {

	@Override
	protected StringParserApi factoryMethod() {
		return new BeverageTagParser();
	}

}
