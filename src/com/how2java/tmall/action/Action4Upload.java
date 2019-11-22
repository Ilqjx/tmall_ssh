package com.how2java.tmall.action;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.how2java.tmall.util.ImageUtil;

public class Action4Upload {

	protected File img;
	protected String imgFileName;
	protected String imgContentType;
	
	/**
	 * uploadImg
	 * 上传图片
	 * @param object 图片所对应的对象
	 * @param path 存储图片的路径
	 */
	public void uploadImg(Object object, String path) {
	    if (img != null) {
	        try {
	            Class clazz = object.getClass();
	            int id = (int) clazz.getMethod("getId").invoke(object);
	            File imageFolder = new File(ServletActionContext.getServletContext().getRealPath(path));
	            File image = new File(imageFolder, id + ".jpg");
	            image.getParentFile().mkdirs();
	            FileUtils.copyFile(img, image);
	            BufferedImage bufferedImage = ImageUtil.chang2jpg(image);
	            ImageIO.write(bufferedImage, "jpg", image);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	/**
	 * deleteImg
	 * 删除图片
	 * @param object 图片所对应的对象
	 * @param path 存储图片的路径
	 */
	public void deleteImg(Object object, String path) {
		try {
			Class clazz = object.getClass();
			int id = (int) clazz.getMethod("getId").invoke(object);
			File imageFolder = new File(ServletActionContext.getServletContext().getRealPath(path));
			File image = new File(imageFolder, id + ".jpg");
			image.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public File getImg() {
		return img;
	}
	
	public void setImg(File img) {
		this.img = img;
	}
	
	public String getImgFileName() {
		return imgFileName;
	}
	
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	
	public String getImgContentType() {
		return imgContentType;
	}
	
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	
}
