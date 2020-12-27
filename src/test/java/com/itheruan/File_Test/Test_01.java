package com.itheruan.File_Test;

import org.junit.Test;

import com.itheruan.utils.FileUtils;
import com.itheruan.utils.UuidUtil;

public class Test_01 {
		@Test
		public void test_01() {
			String upload = FileUtils.upload("C:\\Users\\11137\\Desktop\\image\\2020-12-10.png", "travelimage/"+UuidUtil.getUuid()+".png");
			System.out.println(upload);
		}
		
		
		@Test
		public void test_02() {
			String upload = FileUtils.upload("I:\\00 全套资料\\a.txt", "travelimage/"+UuidUtil.getUuid()+".txt");
			System.out.println(upload);
		}
		
		
		@Test
		public void test_03() {
		/*
		 * String upload = FileUtils.upload("I:\\00 全套资料\\a.txt",
		 * "travelimage/"+UuidUtil.getUuid()+".txt"); System.out.println(upload);
		 */
			
			String download = FileUtils.download("travelimage/5aa18228b5b54837803ef61d2c3cca42.txt");
			System.out.println(download);
		}
}
