package com.mycena.mvc.utils.StringParser;

public abstract class ParserOperte {
	
	public String webStringParser(String stringData) {
		StringParserApi api = factoryMethod();
		return api.webStringParser(stringData);
	}

	protected abstract StringParserApi factoryMethod();

}
