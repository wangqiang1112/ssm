package com.htjs.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class T1 {

	@Test
	public void t1(){
		List list = new ArrayList();
		list.add(new A());
		list.add(new B());
		TestCh tc = new TestCh();
		for(int i = 0;i < list.size();i++){
			tc.getClass_Name(list.get(i));
		}
		
	}
	
}

class A{
	public A(){
		super();
		System.out.println("构造A");
	}
}

class B{
	public B(){
		super();
		System.out.println("构造B");
	}
}
