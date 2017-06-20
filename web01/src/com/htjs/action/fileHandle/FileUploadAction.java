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
	private InputStream isFile;
	
	
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
    		System.out.println(getSavePath());
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
    
    
    public String toFileUpload(){
    	return "success";
    }
    
    public String doUpload(){
    	try{
	    	String root = ServletActionContext.getServletContext().getRealPath("/upload");
	        InputStream is = new FileInputStream(file);
	        OutputStream os = new FileOutputStream(new File(root, fileFileName));
	        System.out.println("fileFileName: " + fileFileName);
	        // 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
	        System.out.println("file: " + file.getName());
	        System.out.println("file: " + file.getPath());
	        byte[] buffer = new byte[500];
	        int length = 0;
	        while(-1 != (length = is.read(buffer, 0, buffer.length))){
	            os.write(buffer);
	        }
	        os.close();
	        is.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return "success";
    }
    
    public String download1(){
    	try {
			isFile = new FileInputStream(getSavePath()+"\\"+fileFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	return "success";
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

	public InputStream getIsFile() {
		return isFile;
	}

	public void setIsFile(InputStream isFile) {
		this.isFile = isFile;
	}
	
	
	
	/**
	 * 多文件上传
	 * private String username;
    
　　//这里用List来存放上传过来的文件，file同样指的是临时文件夹中的临时文件，而不是真正上传过来的文件
    private List<File> file;
    
　　//这个List存放的是文件的名字，和List<File>中的文件相对应
    private List<String> fileFileName;
    
    private List<String> fileContentType;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public List<File> getFile()
    {
        return file;
    }

    public void setFile(List<File> file)
    {
        this.file = file;
    }

    public List<String> getFileFileName()
    {
        return fileFileName;
    }

    public void setFileFileName(List<String> fileFileName)
    {
        this.fileFileName = fileFileName;
    }

    public List<String> getFileContentType()
    {
        return fileContentType;
    }

    public void setFileContentType(List<String> fileContentType)
    {
        this.fileContentType = fileContentType;
    }
    
    @Override
    public String execute() throws Exception
    {
        String root = ServletActionContext.getServletContext().getRealPath("/upload");
        
        for(int i = 0; i < file.size(); i++)
        {
            InputStream is = new FileInputStream(file.get(i));
            
            OutputStream os = new FileOutputStream(new File(root, fileFileName.get(i)));
            
            byte[] buffer = new byte[500];
            
            @SuppressWarnings("unused")
            int length = 0;
            
            while(-1 != (length = is.read(buffer, 0, buffer.length)))
            {
                os.write(buffer);
            }
            
            os.close();
            is.close();
        }
        
        return SUCCESS;
    }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
    
    
    
}
