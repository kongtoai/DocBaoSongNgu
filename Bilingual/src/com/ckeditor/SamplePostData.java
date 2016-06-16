/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see http://ckeditor.com/license
*/
package com.ckeditor;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SamplePostData {

	private static final String[] CHARS_FROM  = {"&", "\"", "<", ">"};
	private static final String[] CHARS_TO = {"&amp;", "&quot;", "&lt;", "&gt;"};
	/**
	 * 
	 */
	private static final long serialVersionUID = -8568318698824941902L;
	private HttpServletRequest request;
	
	public SamplePostData(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getAllFormFieldsAndValues() {
		StringBuffer sb = new StringBuffer();

		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String field = (String) e.nextElement();
			String fieldValue = request.getParameter(field);
			sb.append("<tr>");	
			sb.append("<th style=\"vertical-align: top\">");
			sb.append(parse(field));
			sb.append("</th>");
			sb.append("<td><pre class=\"samples\">");
			sb.append(parse(fieldValue));
			sb.append("</pre></td>");
			sb.append("</tr>");
		}
		return sb.toString();
	}

	private Object parse(String fieldValue) {
		String fv = fieldValue;
		for (int i = 0; i < CHARS_FROM.length; i++) {
		//	fv = fv.replaceAll(CHARS_FROM[i], CHARS_TO[i]);
		}
		return fv;
	}

}