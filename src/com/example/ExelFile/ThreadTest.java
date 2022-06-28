package com.example.ExelFile;

import java.util.List;

class PrintListObject implements Runnable{

	List<String> list;

	@Override
	public void run() {
		if(list != null) {
			for(String el : list) {
				System.err.println(el);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			System.err.println("empty list");
		}
	}

	public void setList(List<String> list) {
		this.list = list;
	}


}

public class ThreadTest {

	public static void main(String[] args) {
		List<String> list = List.of("ram", "mohan", "geeta", "sita");
		PrintListObject task1 = new PrintListObject();
		task1.setList(list);
		Thread t1 = new Thread(task1);
		t1.start();

		List<String> list2 = List.of("Ronan", "mack", "gita", "senorita");
		PrintListObject task2 = new PrintListObject();
		Thread t2 = new Thread(task2);
		task2.setList(list2);
		t2.start();

		//		System.err.println(Thread.currentThread().getName());
	}

}
