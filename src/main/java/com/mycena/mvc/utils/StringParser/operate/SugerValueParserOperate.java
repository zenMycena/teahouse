package com.mycena.mvc.utils.StringParser.operate;

import com.mycena.mvc.utils.StringParser.ParserOperte;
import com.mycena.mvc.utils.StringParser.StringParserApi;
import com.mycena.mvc.utils.StringParser.Impl.SugerValueParser;

public class SugerValueParserOperate extends ParserOperte{

	@Override
	protected StringParserApi factoryMethod() {
		return new SugerValueParser();
	}

}
