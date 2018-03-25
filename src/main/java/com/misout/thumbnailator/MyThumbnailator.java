package com.misout.thumbnailator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.coobird.thumbnailator.Thumbnails;

public class MyThumbnailator {
	
	private static final int PIC_WIDTH_SIZE_600 = 600;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
	
	public static void thumbnailByWidth(String filePath, String outFilepath, int targetWidth) {
		try {
			Thumbnails.of(filePath).width(targetWidth).toFile(outFilepath);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public static String now() {
		return sdf.format(new Date());
	}

	public static void main(String[] args) {
		String basePath = "E:/MySelf/技术博客素材/图片素材/人文风景";
		String fileName = "人文风景13.jpg";
		String[] fileNames = fileName.split("\\.");
		String outFileName = fileNames[0] + "_" + now() + "." + fileNames[1];
		String filePath = basePath + File.separator + fileName;
		String outFilePath = basePath + File.separator + outFileName;
		thumbnailByWidth(filePath, outFilePath, PIC_WIDTH_SIZE_600);
		System.out.println("压缩完成:" + outFilePath);
	}
}
