package demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节流练习:OutputStream和IutputStream
 * 1.给定一个文件的路径,如果此文件存在,就删除它,显示"文件已删除",
 * 2.如果不存在,就创建它,并在里面写入一句"hello world",显示"文件已创建",
 * 3.在文件末尾追加一句"你好,世界",显示"文件已追加内容"
 * 4.显示文件全部内容
 * */
public class Demo1 {

	public static void main(String[] args) {
		File file = new File("E:"+File.separator+"01.txt");
		if(file.exists()) {
			file.delete();
			System.out.println("文件已删除");
		} else {
			try {
				file.createNewFile();
				OutputStream output = new FileOutputStream(file);
				String str = "hello world";
				byte[] b = str.getBytes();
				output.write(b);
				output.close();
				System.out.println("文件已创建");
				OutputStream output1 = new FileOutputStream(file,true);
				// "\r\n"表示换行
				String str1 = "\r\n你好,世界";
				byte[] b1 =str1.getBytes();
				/*
				 output1.write(b1);
				*/

				// (第二种方法)
				for(int i=0; i<b1.length; i++) {
					output1.write(b1[i]);
				}
				output1.close();
				System.out.println("文件已追加内容");
				InputStream input = new FileInputStream(file);
				byte[] b2 = new byte[(int)file.length()];
				/* (第一种方式)
				input.read(b2);
				*/

				// (第二种方式)
				for(int i=0; i<b2.length; i++) {
					b2[i] = (byte) input.read();
				}

				/* (第三种方式)
				byte[] b3 =new byte[1024];
				int len=0;
				int temp=0;
				while((temp=input.read()) != -1) {
					b2[len] = (byte) temp;
					len++;
				}
				input.close();
				System.out.println("文件内容为:"+new String(b3,0,len));
				*/

				input.close();
				String fileContent = new String(b2);
				System.out.println("文件内容为:\n"+fileContent);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
