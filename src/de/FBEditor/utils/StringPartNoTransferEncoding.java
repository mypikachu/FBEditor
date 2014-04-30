package de.FBEditor.utils;

import org.apache.commons.httpclient.methods.multipart.StringPart;

public class StringPartNoTransferEncoding extends StringPart {

	public StringPartNoTransferEncoding(String name, String value) {
		super(name, value);
	}

        @Override
	public String getTransferEncoding() {
		return null;
	}

        @Override
	public String getContentType() {
		return null;
	}
}
