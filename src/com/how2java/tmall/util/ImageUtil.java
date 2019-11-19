package com.how2java.tmall.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	// ���ļ�ת��Ϊ jpg ��ʽ
	public static BufferedImage chang2jpg(File file) {
		try {
			// ���� Image ����
			java.awt.Image image = Toolkit.getDefaultToolkit().createImage(file.getAbsolutePath());
			// ��ָ����ͼ����ץȡ���ؾ��β���
			PixelGrabber pg = new PixelGrabber(image, 0, 0, -1, -1, true);
			// ���� Image ��ʼ�������� ���ȴ���������ؾ����е���������
			pg.grabPixels();
			// ��ȡͼƬ�Ŀ��
			int width = pg.getWidth();
			// ��ȡͼƬ�ĸ߶�
			int height = pg.getHeight();
			final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF};
			// ����ָ����ָʾ int ���ر�ʾ��ʽ����Щλ������ɫ����ɫ����ɫ��ɫ���������빹�� DirectColorModel
			// ColorModel �洢ͼ�����ɫ����
			final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
			// new DataBufferInt ʹ��ָ�����鹹�����е����洢��Ԫ�һ��������� DataBuffer
			// DataBuffer �������ڰ�װ��������
			DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), width * height);
			// ���� SinglePixelPackedSampleModel ����һ������ָ�� DataBuffer����ȡ��߶ȡ�ɨ���м��� band ����� Raster
			// ͨ�� location ����(���һ������)���� Raster �����Ͻ� ��� location Ϊ null ��ʹ�� (0, 0)
			// WritableRaster ��Ĺ��췽��Ϊ protected Ҫʵ���� WritableRaster ��ʹ�� Raster ���е�һ�� createWritableRaster ��������
			// WritableRaster ����չ�� Raster ���ṩ����д�빦��
			// raster �洢ͼ�����������
			WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
			// ����һ������ָ�� ColorModel �� Raster ���� BufferedImage
			BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
			return img;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// �ı�ͼƬ��С
	public static void resizeImage(File srcFile, int width, int height, File destFile) {
		try {
			Image image = ImageIO.read(srcFile);
			image = resizeImage(image, width, height);
			ImageIO.write((RenderedImage) image, "jpg", destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Image resizeImage(Image srcImage, int width, int height) {
		try {
			// ����width��ʾͼ��Ŀ�� height��ʾͼ��ĸ߶� ���һ��������ʾͼ���ֽڻҶ�ͼ��
			BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
			return buffImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
