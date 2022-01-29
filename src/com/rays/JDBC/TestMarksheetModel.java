package com.rays.JDBC;

import java.util.Iterator;
import java.util.List;

import com.rays.JDBC.Javabean.MakrsheetModel;
import com.rays.JDBC.Javabean.MarksheetBean;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testUpdate();
		//testDelete();
		//testGetRecord();
		//testSearchSelectAll();
		testGetMeritList();
		
		
		
		
	}

	public static void testGetMeritList() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MakrsheetModel ms = new MakrsheetModel();
		
		List<MarksheetBean> list = ms.getMeritList(bean);
		
		Iterator<MarksheetBean> it = list.iterator();
		
		
		System.out.println("ID\tRoll no.\tFirst Name\tLast Name\tPhysics\tChemistry\tMathematics\tTotal\tPercentage");
		
		while(it.hasNext()) {
			MarksheetBean bean1 = (MarksheetBean) it.next();
			
			System.out.print(bean1.getId());
			System.out.print("\t"+bean1.getRollNo());
			System.out.print("\t\t"+bean1.getFirstName());
			System.out.print("\t\t"+bean1.getLastName());
			System.out.print("\t\t"+bean1.getPhysics());
			System.out.print("\t\t"+bean1.getChemistry());
			System.out.print("\t\t"+bean1.getMathematics());
			System.out.print("\t "+ (bean1.getPhysics()+bean1.getChemistry()+bean1.getMathematics()));
			System.out.println("\t"+ ((bean1.getPhysics()+bean1.getChemistry()+bean1.getMathematics())/3));
			//System.out.println(" ");
			
		}
		
	}

	private static void testSearchSelectAll() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MakrsheetModel ms = new MakrsheetModel();
		
		List<MarksheetBean> list = ms.searchSelectAll(bean);
		
		Iterator<MarksheetBean> it = list.iterator();
		
		
		while(it.hasNext()) {
			MarksheetBean bean1 = (MarksheetBean) it.next();
			
			System.out.print(bean1.getId());
			System.out.print("  " +bean1.getRollNo());
			System.out.print("  " +bean1.getFirstName());
			System.out.print("  " +bean1.getLastName());
			System.out.print("  " +bean1.getPhysics());
			System.out.print("  " +bean1.getChemistry());
			System.out.print("  " +bean1.getMathematics());
			System.out.println(" ");
			
		}
		
	}

	public static void testGetRecord() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo(13078);
		
		MakrsheetModel ms = new MakrsheetModel();
		bean = (MarksheetBean) ms.getRecord(bean);
		
		System.out.print(bean.getId());
		System.out.print("  "+bean.getRollNo());
		System.out.print("  "+bean.getFirstName());
		System.out.print("  "+bean.getLastName());
		System.out.print("  "+bean.getPhysics());
		System.out.print("  "+bean.getChemistry());
		System.out.print("  "+bean.getMathematics());
		
	}

	public static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setRollNo(13024);
		
		MakrsheetModel.deleteRecord(bean);
		
		System.out.println("Record Deleted");
		
	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setRollNo(1478745);
		bean.setFirstName("RamLALji");
		bean.setLastName("SonOfShyamLAl");
		bean.setPhysics(78);
		bean.setChemistry(86);
		bean.setMathematics(99);
		bean.setId(1);
		
		MakrsheetModel ms = new MakrsheetModel();
		ms.updateRecord(bean);
		
		System.out.println("Record Updated");
		
	}

	public static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(1);
		bean.setRollNo(1478745);
		bean.setFirstName("RamLALji");
		bean.setLastName("SonOfShyamLAl");
		bean.setPhysics(78);
		bean.setChemistry(86);
		bean.setMathematics(99);
		
		MakrsheetModel ms = new MakrsheetModel();
		ms.addRecord(bean);
		
		System.out.println("Record Inserted");
		
	}
}
