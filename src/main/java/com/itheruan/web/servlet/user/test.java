package com.itheruan.web.servlet.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.itheruan.utils.FileUtils;
import com.itheruan.utils.UuidUtil;

//oss-cn-beijing.aliyuncs.com
public class test {
	public static void main(String[] args) throws IOException {
	/*	// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = "https://oss-cn-beijing.aliyuncs.com";
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
		String accessKeyId = "LTAI4G93VpUPYcKGadmZAXr4";
		String accessKeySecret = "3Ih49kZXvin3C3dmLcTZ4JyraI3Kjq";
		String bucketName = "travelremark";
		// <yourObjectName>从OSS下载文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
		String objectName = "image/ce0a4856-af5d-49e2-af28-5dc0169281c1.txt";

		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		// 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
		OSSObject ossObject = ossClient.getObject(bucketName, objectName);
		// 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
		InputStream content = ossObject.getObjectContent();
		if (content != null) {
		    BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		    while (true) {
		        String line = reader.readLine();
		        if (line == null || line.length()==0) break;
		        System.out.println("\n" + line);
		    }
		    // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
		    content.close();
		}

		// 关闭OSSClient。
		ossClient.shutdown(); */

		FileUtils.upload("C:\\Users\\11137\\Desktop\\旅途点评\\profile.png" ,"remarkImage/" + UuidUtil.getUuid());
	}
}
