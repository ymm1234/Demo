package example;

import java.util.concurrent.CountDownLatch;

/**
 * 快速排序线程
 * 
 * @author yanmiaomiao
 *
 */
public class QSortThread extends Thread {
	private char[] arr;
	private int start;
	private int end;
	private CountDownLatch countDownLatch;

	public QSortThread(char[] arr, int start, int end, CountDownLatch countDownLatch) {
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.countDownLatch = countDownLatch;
	}

	public void run() {
		try {
			Demo.lock.lock();
			countDownLatch.countDown();
			if (arr.length > 0) {
				Util.charQuickSort(arr, start, end);
				Demo.shortList.add(String.valueOf(arr));
			}
		} finally {
			Demo.lock.unlock();
		}
	}
}