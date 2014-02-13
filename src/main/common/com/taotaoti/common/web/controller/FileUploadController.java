package com.taotaoti.common.web.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.vo.ReturnFileUpVo;

@Controller
@RequestMapping("/other")
public class FileUploadController {
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		System.out.println(multipartRequest.getFileMap().size());
		Map<String, MultipartFile>  filess=multipartRequest.getFileMap();
		Iterator<String> keys=filess.keySet().iterator();
		
		while(keys.hasNext()){
			String key=keys.next();
			System.out.println(key);
			MultipartFile multipartFile=filess.get(key);
			
		}
		
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
				.getFile("file");

		String name = multipartRequest.getParameter("name");
		System.out.println("name: " + name);
		// 获得文件名：
		String realFileName = file.getOriginalFilename();
		System.out.println("获得文件名：" + realFileName);
		// 获取路径
		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "images/";
		System.out.println(ctxPath);
		// 创建文件
		File dirPath = new File(ctxPath);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		File uploadFile = new File(ctxPath + realFileName);
		FileCopyUtils.copy(file.getBytes(), uploadFile);
		request.setAttribute("files", loadFiles(request));
		return new ModelAndView("other/success");
	}

	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public ModelAndView onSubmit2(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {

		// 转型为MultipartHttpRequest
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 根据前台的name名称得到上传的文件
		MultipartFile file = multipartRequest.getFile("file");
		// 获得文件名：
		String realFileName = file.getOriginalFilename();
		// 获取路径
		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "\\" + "images\\";
		// 创建文件
		File dirPath = new File(ctxPath);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		File uploadFile = new File(ctxPath + realFileName);
		FileCopyUtils.copy(file.getBytes(), uploadFile);
		request.setAttribute("files", loadFiles(request));
		return new ModelAndView("other/success");
	}

	@RequestMapping(value = "/upload3", method = RequestMethod.POST)
	public String upload(@RequestParam("file")
	MultipartFile image, HttpServletRequest request) throws IOException {

		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "\\" + "images\\";
		System.out.println("路径：" + ctxPath);
		File file = new File(ctxPath + "/" + image.getOriginalFilename());
		// FileCopyUtils.copy(image.getBytes(),new
		// File(ctxPath+"/"+image.getOriginalFilename()));
		try {
			image.transferTo(file); // 保存上传的文件
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("files", loadFiles(request));
		return "success";
	}

	// 多文件上传
	//@ResponseBody
	@RequestMapping(value = "/upload4", method = RequestMethod.POST)
	public ModelAndView fileUpload(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "\\" + "images\\";
		File file = new File(ctxPath);
		if (!file.exists()) {
			file.mkdir();
		}
		String fileName = null;
		System.out.println(fileMap.size());
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 上传文件名
			System.out.println("key: " + entity.getKey());
			MultipartFile mf = entity.getValue();
			fileName = mf.getOriginalFilename();
			System.out.println(fileName);
			File uploadFile = new File(ctxPath + fileName);
			FileCopyUtils.copy(mf.getBytes(), uploadFile);
		}
		
		request.setAttribute("files", loadFiles(request));
		  System.out.println("#################ViewController ##################");
		    ModelAndView mav = new ModelAndView("othter/success");
		    List<ReturnFileUpVo> list = new ArrayList<ReturnFileUpVo>();
		    for (int i = 0; i < 3; i++) {
		        ReturnFileUpVo returnFileUpVo=new ReturnFileUpVo();
		        list.add(returnFileUpVo);
		    }
		    mav.addObject(list);
		    return mav;
	}
	
	@RequestMapping(value = "/upload4.json", method = RequestMethod.POST)
	public ModelAndView fileUploadJson(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "\\" + "images\\";
		File file = new File(ctxPath);
		if (!file.exists()) {
			file.mkdir();
		}
		String fileName = null;
		System.out.println(fileMap.size());
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 上传文件名
			System.out.println("key: " + entity.getKey());
			MultipartFile mf = entity.getValue();
			fileName = mf.getOriginalFilename();
			System.out.println(fileName);
			File uploadFile = new File(ctxPath + fileName);
			FileCopyUtils.copy(mf.getBytes(), uploadFile);
		}
		
		request.setAttribute("files", loadFiles(request));
		  System.out.println("#################ViewController defaultJsonView upload4.json##################");
		    ModelAndView mav = new ModelAndView("other.json");
		    List<ReturnFileUpVo> list = new ArrayList<ReturnFileUpVo>();
		    for (int i = 0; i < 3; i++) {
		        ReturnFileUpVo returnFileUpVo=new ReturnFileUpVo();
		        list.add(returnFileUpVo);
		    }
		    mav.addObject(list);
		    return mav;
	}
	@RequestMapping(value = "/upload4")
	public ModelAndView fileUploadP(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		
		return new ModelAndView("success");
	}
	
	@RequestMapping(value = "/upload5.json")
	public ModelAndView fileUploadPJson(HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		return new ModelAndView("success");
	}
	@RequestMapping(value = "/upload6")
	public String fileUploadPJson6(ModelMap model){
		System.out.println("/upload6");
		List<ReturnFileUpVo> list = new ArrayList<ReturnFileUpVo>();
	    for (int i = 0; i < 3; i++) {
	        ReturnFileUpVo returnFileUpVo=new ReturnFileUpVo();
	        list.add(returnFileUpVo);
	    }
		 model.addAttribute("files", list);
		return "other/success";
	}
	@RequestMapping(value = "/upload6",method = RequestMethod.GET)
	public String fileUploadPJsonNO6(ModelMap model){
		System.out.println("/upload6");
		model.addAttribute("files", null);
		return "other/success";
	}

	// @ModelAttribute("files")//此属性用于初始类时调用,但上传文件后不能时时反应上传文件个数,不适合动态数据
	public List<String> loadFiles(HttpServletRequest request) {
		List<String> files = new ArrayList<String>();
		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "\\" + "images\\";
		File file = new File(ctxPath);
		if (file.exists()) {
			File[] fs = file.listFiles();
			String fname = null;
			for (File f : fs) {
				fname = f.getName();
				if (f.isFile()) {
					files.add(fname);
				}
			}
		}
		return files;
	}

	@RequestMapping("/download/{fileName}")
	public ModelAndView download(@PathVariable("fileName")
	String fileName, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "\\" + "images\\";
		String downLoadPath = ctxPath + fileName;
		System.out.println(downLoadPath);
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}
}
