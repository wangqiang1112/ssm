package com.htjs.action.fileHandle;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.htjs.base.BaseAction;

public class FileUploadAction extends BaseAction{
	/* 
     * 成员变量的名称不能随意更改,  
     * private File file;           变量的名称必须和jsp中上传文件标签中的name属性的值一致. 
     * private String fileFileName;     变量的名称必须为"上传文件的名称+FileName". 
     * private String fileContentType;  变量的名称必须为"上传文件的名称+ContentType",  
     */  
	
	private File file; //和在JS中指定的fileObjName的值相同
	private String fileFileName; //[fileName]FileName    获得上传文件的名称
	private String fileContentType; //[fileName]ContentType  获得上传文件的类型
	
	
    @SuppressWarnings("deprecation")  
    public String fileUpload() throws Exception {  
        String path = getSavePath()+"\\"; //存储地址为D盘根目录
        FileOutputStream fos = new FileOutputStream(path+fileFileName); //输出流
        FileInputStream fis = new FileInputStream(file);    //输出流
 
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len=fis.read(buffer))!=-1){
            fos.write(buffer);
        }
        fos.close();
        fis.close();
        return null;    //这里不需要返回任何东西
    } 
    
    public String toFilePage(){
    	return "success";
    }
    
    public void download(){
    	try{
    		InputStream is = new FileInputStream(getSavePath()+"\\"+fileFileName);
        	HttpServletResponse response = ServletActionContext.getResponse();
        	response.reset(); // 必要地清除response中的缓存信息
    		response.setHeader("Content-Disposition", "attachment;filename="+ fileFileName);
    		response.setContentType("application/data");//根据个人需要,这个是下载文件的类型
    		javax.servlet.ServletOutputStream out = response.getOutputStream();
    		byte[] content = new byte[1024];
    		int length = 0;
    		while ((length = is.read(content)) != -1) {
    		out.write(content, 0, length);
    		}
    		out.write(content);
    		out.flush();
    		out.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }

    
    
    
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
    
    
    
}
