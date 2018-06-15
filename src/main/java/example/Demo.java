package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {

	public static Lock lock = new ReentrantLock();
	public static List<String> shortList = new ArrayList<String>();

	public void  quickSort() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("in.txt"));
		List<String> inList = new ArrayList<String>();
		String line = br.readLine();
		while(line != null)
		{
			inList.add(line);
			line = br.readLine();
		}
		CountDownLatch countDownLatch = new CountDownLatch(inList.size());
		String str = "";
		char[] c;
		for(int i=0;i<inList.size();i++){
			str = inList.get(i);
			c = str.toCharArray();
			new QSortThread(c, 0, c.length - 1,countDownLatch).start();
		}

		
		// 把排序后的字符串写入out.txt
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
		for(int i=0;i<shortList.size();i++){
			System.out.println(shortList.get(i));
			bw.write(shortList.get(i));
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
