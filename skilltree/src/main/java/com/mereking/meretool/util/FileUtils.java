package com.mereking.meretool.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件操作工具
 * @author mereKing
 * @date 2016年6月9日
 */
public class FileUtils {
	
	public static String restoreFile(MultipartFile file, HttpServletRequest request) {
		String filePath = "";
		// 判断是否为空
		if (!file.isEmpty()) {
			// linux与windows通用
			filePath = request.getSession().getServletContext().getRealPath("/")+"fileTemp/"+file.getOriginalFilename();
			try {
				File newFile = new File(filePath);
				newFile.getParentFile().mkdir();
				file.transferTo(newFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
	/**
	 * 读取文件内容
	 * @param targetUrl 目标文件路径
	 * @return
	 */
	public static StringBuffer readFileToString(String targetUrl) throws FileNotFoundException {
		StringBuffer content = new StringBuffer();
		FileReader read = null;
		BufferedReader br = null;
		try {
			read = new FileReader(new File(targetUrl));
			br = new BufferedReader(read);
			while (br.ready() != false) {
				content.append(br.readLine());
				content.append("\r\n");
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (read != null) {
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
	

}
