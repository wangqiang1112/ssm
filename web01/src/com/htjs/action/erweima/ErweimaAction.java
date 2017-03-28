package com.htjs.action.erweima;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.htjs.base.BaseAction;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.swetake.util.Qrcode;

public class ErweimaAction extends BaseAction{
    
	/**
	 * 跳转到二维码页面
	 * @return
	 */
	public String toErweima(){
		return "success";
	}
	
	private static final long serialVersionUID = 1L;  
    private InputStream inputStream;  
    public static int WIDTH=200;  
    public static int HEIGHT=100;  
    public static int NUM=5;  
      
    public String code() {  
        byte[] image = new byte[1000];  
        try {  
            image = createImage();  
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        this.inputStream = new ByteArrayInputStream(image);  
        return "stream";  
    }  
  
    public byte[] createImage() throws UnsupportedEncodingException{  
        Qrcode qrcode = new Qrcode();    
        qrcode.setQrcodeErrorCorrect('M');    
        qrcode.setQrcodeEncodeMode('B');    
        qrcode.setQrcodeVersion(7);    
        //content为需要生成的字符串，可通过请求传入参数  
        String content= "http://www.baidu.com";  
        byte[] bstr = content.getBytes("UTF-8");  
        BufferedImage bi = new BufferedImage(139, 139,BufferedImage.TYPE_INT_RGB);    
        Graphics2D g = bi.createGraphics();    
        g.setBackground(Color.WHITE);   //背景颜色    
        g.clearRect(0, 0, 139, 139);    
        g.setColor(Color.BLACK);    //条码颜色    
        System.out.println(bstr.length);  
        if (bstr.length > 0 && bstr.length < 123) {    
            boolean[][] b = qrcode.calQrcode(bstr);    
            for (int i = 0; i < b.length; i++) {    
                for (int j = 0; j < b.length; j++) {    
                    if (b[j][i]) {    
                        g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);    
                    }    
                }    
            }    
        }    
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);  
        try {  
            encoder.encode(bi);  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return os.toByteArray();  
    }  
  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
    }   
	
	
	
	
    
    
}
