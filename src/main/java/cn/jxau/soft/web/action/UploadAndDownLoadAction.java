package cn.jxau.soft.web.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("uploadAndDownLoadAction")
@Scope(value="prototype")
public class UploadAndDownLoadAction extends ActionSupport {
	private static final long serialVersionUID = 7069094647672971599L;

	private ByteArrayInputStream inputStream;
	
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	
	/**=========================*/
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	// 下载入口
	public String download() {
		try {
			FileInputStream fis = new FileInputStream(getFileNameWithEncoded(getFileName()));
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			IOUtils.copy(fis, byteOut);
			inputStream = new ByteArrayInputStream(byteOut.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "download";
	}
	private String getFileNameWithEncoded(String fileName) throws UnsupportedEncodingException {
		return new String(fileName.getBytes("ISO-8859-1"), "utf-8");
	}
	/**=========================*/
	
	
	
	
	private String savePath;  // 上传文件的保存路径
	private String allowedTypes;
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public String getAllowedTypes() {
		return allowedTypes;
	}
	public void setAllowedTypes(String allowedTypes) {
		this.allowedTypes = allowedTypes;
	}
	
	
	/**=========================*/
	private File commonUpload;
	private String commonUploadFileName;
	private String commonUploadContentType;
	public File getCommonUpload() {
		return commonUpload;
	}
	public void setCommonUpload(File commonUpload) {
		this.commonUpload = commonUpload;
	}
	public String getCommonUploadFileName() {
		return commonUploadFileName;
	}
	public void setCommonUploadFileName(String commonUploadFileName) {
		this.commonUploadFileName = commonUploadFileName;
	}
	public String getCommonUploadContentType() {
		return commonUploadContentType;
	}
	public void setCommonUploadContentType(String commonUploadContentType) {
		this.commonUploadContentType = commonUploadContentType;
	}
	// 上传入口
	public String upload() {
		if (! fileFilter(getSuffix(getCommonUploadFileName()))) {
			inputStream = new ByteArrayInputStream("{\"message\":\"上传文件类型不支持！\"}".getBytes());
			return "upload";
		}
		
		if (! sizeFilter(getCommonUpload())) {
			inputStream = new ByteArrayInputStream("{\"message\":\"上传文件大于20m！\"}".getBytes());
			return "upload";
		}
		
		try {
			String finalFileName = saveSingleImg(getCommonUpload(), getCommonUploadFileName());
			inputStream = new ByteArrayInputStream(("{\"message\":\"上传成功！\",\"finalFileName\":\""+finalFileName+"\"}").getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "upload";
	}

	/**=========================*/
	
	
	
	/**=========================*/
	private List<File> commonUploads;
	private List<String> commonUploadsFileName;
	private List<String> commonUploadsContentType;
	public List<File> getCommonUploads() {
		return commonUploads;
	}
	public void setCommonUploads(List<File> commonUploads) {
		this.commonUploads = commonUploads;
	}
	public List<String> getCommonUploadsFileName() {
		return commonUploadsFileName;
	}
	public void setCommonUploadsFileName(List<String> commonUploadsFileName) {
		this.commonUploadsFileName = commonUploadsFileName;
	}
	public List<String> getCommonUploadsContentType() {
		return commonUploadsContentType;
	}
	public void setCommonUploadsContentType(List<String> commonUploadsContentType) {
		this.commonUploadsContentType = commonUploadsContentType;
	}
	// 多文件上传入口
	public String multiupload() {
		for (int i=0; i<getCommonUploads().size(); i++) {
			if (! fileFilter(getSuffix(getCommonUploadsFileName().get(i)))) {
				inputStream = new ByteArrayInputStream("{\"message\":\"上传文件类型不支持！\"}".getBytes());
				return "multiupload";
			}
		}
		
		for (int i=0; i<getCommonUploads().size(); i++) {
			if (! sizeFilter(getCommonUpload())) {
				inputStream = new ByteArrayInputStream("{\"message\":\"上传文件大于20m！\"}".getBytes());
				return "upload";
			}
		}
		
		try {
			for (int i=0; i<getCommonUploads().size(); i++) {
					saveSingleImg(getCommonUploads().get(i), getCommonUploadsFileName().get(i));
			}
			inputStream = new ByteArrayInputStream("{\"message\":\"上传成功！\"}".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "multiupload";
	}
	/**=========================*/

	
	
	/**
	 * 判断当前文件后缀名是否在允许上传类型之内
	 * @param ext 文件的后缀名
	 * @return 判断当前文件后缀名是否在允许上传类型之内
	 */
	private boolean fileFilter(String ext) {
		List<String> fileSuffixs = Arrays.asList(getAllowedTypes().split(","));
		
		for (int i=0; i<fileSuffixs.size(); i++) {
			if (ext.equals(fileSuffixs.get(i))) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 保存上传文件到savePath路径下
	 * @param pic savePath路径
	 */
	private String saveSingleImg(File from, String fromFileName) throws Exception {
		String savePathDir = ServletActionContext.getServletContext().getRealPath("\\WEB-INF\\" + getSavePath());
		File file = new File(savePathDir, System.currentTimeMillis() + getSuffix(fromFileName));

		FileInputStream fis = new FileInputStream(from);
		FileOutputStream fos = new FileOutputStream(file);
		
		IOUtils.copy(fis, fos);
		fis.close();
		fos.close();
		String replacedStr = file.toString().replace("\\", "/");
		return replacedStr.substring(replacedStr.indexOf("/WEB-INF"));
	}
	
	/**
	 * 获得文件后缀名
	 * @param fromFileName 文件
	 * @return 文件后缀名
	 */
	private String getSuffix(String fromFileName) {
		return fromFileName.substring(fromFileName.lastIndexOf("."));
	}
	
	private boolean sizeFilter(File fromFile) {
		if (fromFile.length() > 20971520) {
			return false;
		}
		return true;
	}
	
}
