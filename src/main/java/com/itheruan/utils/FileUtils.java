package com.itheruan.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;

/**
 * 文件工具类
 * 
 * @author 11137
 *
 */
public class FileUtils {
	private static String endpoint;
	private static String accessKeyId;
	private static String accessKeySecret;
	private static String bucketName;
	/**
	 * 加载配置文件
	 */
	static {
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		endpoint = "http://oss-cn-beijing.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录
		// https://ram.console.aliyun.com 创建。
		accessKeyId = "LTAI4G93VpUPYcKGadmZAXr4";
		accessKeySecret = "3Ih49kZXvin3C3dmLcTZ4JyraI3Kjq";
		bucketName = "travelremark";
	}

	/**
	 * 图片上传
	 * 
	 * @param filePath
	 * @param fileName
	 */
	public static String upload(String filePath, String fileName) {
		try {
			// 创建OSSClient实例。
			OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
			// 添加 ContentType
			ObjectMetadata objectMetadata = new ObjectMetadata();
			// 直接设置 content_type 解决直接下载无法预览效果
			String getcontentType = getcontentType(".png");
			objectMetadata.setContentType(getcontentType);
			//objectMetadata.setContentType("image/jpg");
			// 上传文件流。
			InputStream inputStream = new FileInputStream(filePath);
			ossClient.putObject(bucketName, fileName+".png", inputStream,objectMetadata);
			ossClient.shutdown();
			return "https://"+bucketName+".oss-cn-beijing.aliyuncs.com/" + fileName+".png";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	  public static String getcontentType(String FilenameExtension) {
	        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
	            return "image/bmp";
	        }
	        if (FilenameExtension.equalsIgnoreCase(".gif")) {
	            return "image/gif";
	        }
	        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
	                FilenameExtension.equalsIgnoreCase(".jpg") ||
	                FilenameExtension.equalsIgnoreCase(".png")) {
	            return "image/jpg";
	        }
	        if (FilenameExtension.equalsIgnoreCase(".html")) {
	            return "text/html";
	        }
	        if (FilenameExtension.equalsIgnoreCase(".txt")) {
	            return "text/plain";
	        }
	        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
	            return "application/vnd.visio";
	        }
	        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
	                FilenameExtension.equalsIgnoreCase(".ppt")) {
	            return "application/vnd.ms-powerpoint";
	        }
	        if (FilenameExtension.equalsIgnoreCase(".docx") ||
	                FilenameExtension.equalsIgnoreCase(".doc")) {
	            return "application/msword";
	        }
	        if (FilenameExtension.equalsIgnoreCase(".xml")) {
	            return "text/xml";
	        }
	        return "image/jpg";
	    }

	
	/**
	 * 文件上传
	 * 
	 * @param filePath
	 * @param fileName
	 */
	public static String Fileupload(String filePath, String fileName) {
		try {
			// 创建OSSClient实例。
			OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
			// 添加 ContentType
	
			// 直接设置 content_type 解决直接下载无法预览效果
			// 上传文件流。
			InputStream inputStream = new FileInputStream(filePath);
			ossClient.putObject(bucketName, fileName, inputStream);
			return endpoint + "/" + fileName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 文件的下载
	 * 
	 * @param objectName
	 * @return
	 */
	public static String download(String objectName) {

		try {
			// 创建OSSClient实例。
			OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

			// 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
			OSSObject ossObject = ossClient.getObject(bucketName, objectName);
			// 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
			InputStream content = ossObject.getObjectContent();
			StringBuffer sb = new StringBuffer();
			if (content != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				while (true) {
					String line = reader.readLine();
					if (line == null) {
						break;
					}
					if (line.length() == 0) {
						continue;
					}

					sb.append("\n" + line);
				}
				// 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
				content.close();
			}
			return sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;

	}

}
