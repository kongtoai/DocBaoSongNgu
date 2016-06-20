package com.java.news.bilingual.servlets;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DamAdminController {


	@RequestMapping(value = "/damuploadfile", method = RequestMethod.POST)
	public ModelAndView damupload(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		File file;
		int maxFileSize = 50000 * 1024;
		int maxMemSize = 50000 * 1024;
		String filePath = request.getServletContext().getRealPath("/assets");

		// Verify the content type
		String contentType = request.getContentType();
		if ((contentType.indexOf("multipart/form-data") >= 0)) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			// maximum size that will be stored in memory
			factory.setSizeThreshold(maxMemSize);
			// Location to save data that is larger than maxMemSize.
			factory.setRepository(new File("/tmp"));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// maximum file size to be uploaded.
			upload.setSizeMax(maxFileSize);
			try {
				// Parse the request to get file items.
				List fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator i = fileItems.iterator();

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						// Get the uploaded file parameters
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						// Write the file
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(filePath + "/" + fileName.substring(fileName.lastIndexOf("\\")));
						} else {
							file = new File(filePath + "/" + fileName.substring(fileName.lastIndexOf("\\") + 1));
						}
						fi.write(file);
					}
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		
		model.addObject("msg", "Upload file successfully.");
		model.setViewName("damadmin");
		return model;
	}
	

	@RequestMapping(value = "/damadmin", method = RequestMethod.GET)
	public String damadmin(HttpServletRequest request, HttpServletResponse response) {
		
		return "damadmin";
	}

}