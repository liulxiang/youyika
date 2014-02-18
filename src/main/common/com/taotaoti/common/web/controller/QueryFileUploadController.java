package com.taotaoti.common.web.controller;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/query")
public class QueryFileUploadController {
	 private static final Log log = LogFactory.getLog(QueryFileUploadController.class);
	String fileUploadDirectory="/home/liulxiang/youyika/";
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	@ResponseBody
    public Map list() {
        List<Image> list =new ArrayList<Image>();
        for(Image image : list) {
            image.setUrl("/picture/"+image.getId());
            image.setThumbnailUrl("/thumbnail/"+image.getId());
            image.setDeleteUrl("/delete/"+image.getId());
            image.setDeleteType("DELETE");
        }
        Map<String, Object> files = new HashMap<String, Object>();
        files.put("files", list);
        return files;
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public  Map upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        log.debug("uploadPost called");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        List<Image> list = new LinkedList<Image>();
        System.out.println("hello");
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            
            String newFilenameBase = UUID.randomUUID().toString();
            String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
            String newFilename = newFilenameBase + originalFileExtension;
            String storageDirectory = fileUploadDirectory;
            String contentType = mpf.getContentType();
            storageDirectory=request.getSession().getServletContext().getRealPath("/");
            System.out.println(storageDirectory);
            File newFile = new File(storageDirectory + "/" + newFilename);
            try {
                mpf.transferTo(newFile);
                
                BufferedImage thumbnail = Scalr.resize(ImageIO.read(newFile), 290);
                String thumbnailFilename = newFilenameBase + "-thumbnail.png";
                File thumbnailFile = new File(storageDirectory + "/" + thumbnailFilename);
                ImageIO.write(thumbnail, "png", thumbnailFile);
                
                Image image = new Image();
                image.setName(mpf.getOriginalFilename());
                image.setThumbnailFilename(thumbnailFilename);
                image.setNewFilename(newFilename);
                image.setContentType(contentType);
                image.setSize(mpf.getSize());
                //image = imageDao.create(image);
                
                image.setUrl("/picture/"+image.getId());
                //image.setThumbnailUrl("/thumbnail/"+image.getId());
                image.setThumbnailUrl("/youyika/"+thumbnailFilename);
               // image.setDeleteUrl("/delete/"+image.getId());
                image.setDeleteUrl("/youyika/query/delete/"+1);
                image.setDeleteType("DELETE");
                
                list.add(image);
                
            } catch(IOException e) {
            	
            }
            
        
        }
        
        Map<String, Object> files = new HashMap<String, Object>();
        files.put("files", list);
        return files;
    }
    
    @RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
    public void picture(HttpServletResponse response, @PathVariable Long id) {
//        Image image = imageDao.get(id);
//        File imageFile = new File(fileUploadDirectory+"/"+image.getNewFilename());
//        response.setContentType(image.getContentType());
//        response.setContentLength(image.getSize().intValue());
//        try {
//            InputStream is = new FileInputStream(imageFile);
//            IOUtils.copy(is, response.getOutputStream());
//        } catch(IOException e) {
//            log.error("Could not show picture "+id, e);
//        }
    }
    
    @RequestMapping(value = "/thumbnail/{id}", method = RequestMethod.GET)
    public void thumbnail(HttpServletResponse response, @PathVariable Long id) {
//        Image image = imageDao.get(id);
//        File imageFile = new File(fileUploadDirectory+"/"+image.getThumbnailFilename());
//        response.setContentType(image.getContentType());
//        response.setContentLength(image.getSize().intValue());
//        try {
//            InputStream is = new FileInputStream(imageFile);
//            IOUtils.copy(is, response.getOutputStream());
//        } catch(IOException e) {
//            log.error("Could not show thumbnail "+id, e);
//        }
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody List delete(@PathVariable Long id) {
        // Image image = imageDao.get(id);
//        File imageFile = new File(fileUploadDirectory+"/"+image.getNewFilename());
//        imageFile.delete();
//        File thumbnailFile = new File(fileUploadDirectory+"/"+image.getThumbnailFilename());
//        thumbnailFile.delete();
      //  imageDao.delete(image);
        List<Map<String, Object>> results = new ArrayList<Map<String,Object>>();
        Map<String, Object> success = new HashMap<String, Object>();
        success.put("success", true);
        results.add(success);
        return results;
    }
}
