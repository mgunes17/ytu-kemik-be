package org.ytu.kemik.crawler.common.filter;

import java.io.IOException;

import zemberek.langid.LanguageIdentifier;

public class LanguageFilter implements ITextPredicate {

	private static LanguageIdentifier lid;
	private String language;
	
	public LanguageFilter(String language) throws IOException {
		this.language = language;
		if(lid == null)
			lid = LanguageIdentifier.fromInternalModels();
	}
	
	@Override
	public boolean test(String str) {
		return lid.containsLanguage(str, language, 100);
	}
}
