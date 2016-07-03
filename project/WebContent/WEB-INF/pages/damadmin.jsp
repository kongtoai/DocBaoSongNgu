<%@page import="java.util.Comparator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>File Uploading Form</title>

</head>
<body>
	<c:if test="${not empty msg }">
		<h3>${msg }</h3>
	</c:if>
	<h3>File Upload:</h3>
	Select a file to upload:
	<br />
	<form action="damuploadfile?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		<input type="file" name="file" size="50" multiple="true" /> <br /> <input type="submit" value="Upload File" />
	</form>
	<hr>

	<%
		String file = application.getRealPath("/assets");

		File f = new File(file);
		if (f.exists()) {
			// 			String[] fileNames = f.list();
			File[] fileObjects = f.listFiles();

			Arrays.sort(fileObjects, new Comparator<File>() {
				public int compare(File f1, File f2) {
					return Long.compare(f2.lastModified(), f1.lastModified());
				}
			});

			for (int i = 0; i < fileObjects.length; i++) {
				String path = fileObjects[i].getAbsolutePath();
				String fname = "..\\assets" + File.separator + path.substring(path.lastIndexOf(File.separator) + 1);

				if (!fileObjects[i].isDirectory()) {
					out.println("<br><img width=\"300px\" height=\"200px\" src=\"" + fname + "\"/>");
					out.println("<br>" + fname);
				} else {
					out.println("<br> DIR: " + fname);
				}
			}
		} else {
			out.println("<br>" + file);
		}
	%>
	<form action="" method="post">
		<p>
			<label for="editor1"> Editor 1:</label>
			<textarea cols="80" id="editor1" name="editor1" rows="10"></textarea>
		</p>
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
	<ckeditor:replaceAll basePath="../ckeditor/" />
</body>
</html>