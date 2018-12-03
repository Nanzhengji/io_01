package demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节流练习:文件复制
 * 因为要复制的文件不一定是文本文件,也肯能包含图片或者视频或声音,所以必须要使用字节流完成
 * 采用边读边写的方式 
 * */
public class Demo3 {

	public static void main(String[] args) {
		//1.创建两个文件,将f1的内容复制到f2
		File f1 = new File("E:"+File.separator+"01.jpg");
		File f2 = new File("E:"+File.separator+"02.jpg");
		if(!f1.exists()) {
			System.out.println("源文件不存在");
			System.exit(1);
		}
		try {
			//2.创建输入,输出流,读写文件内容
			InputStream input = new FileInputStream(f1);
			OutputStream output = new FileOutputStream(f2);
			//3.边读边写
			if(input != null && output != null) {
				int temp = 0;
				while((temp=input.read()) != -1) {
					output.write(temp);
				}
				input.close();
				output.close();
				System.out.println("文件复制完成");
			}
		} catch (Exception e) {
			System.out.println("文件复制失败");
			e.printStackTrace();
		}
		
	}

}
