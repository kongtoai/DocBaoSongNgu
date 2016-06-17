
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<html>
<head>
<title>Creating CKEditor Instances &mdash; CKEditor Sample</title>
</head>
<body>

	<form action="_samples/assets/sample_posteddata.jsp" method="post">
		<p>
			<label for="editor1"> Editor 1:</label>
			<textarea cols="80" id="editor1" name="editor1" rows="10"></textarea>
		</p>
		<p>
			<label for="editor2"> Editor 2:</label>
			<textarea cols="80" id="editor2" name="editor2" rows="10"></textarea>
		</p>
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
	<ckeditor:replaceAll basePath="ckeditor/" />

</body>
</body>
</html>