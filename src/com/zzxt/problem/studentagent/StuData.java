package com.zzxt.problem.studentagent;

import java.util.*;

public class StuData {

	private Student[] stuArray = new Student[10];
	
	private Student stu=new Student();
	
	private int dataIndex = 0;
	
	Scanner scanner=new Scanner(System.in);
	
	/**
	 * 增加学生信息
	 * @param stu
	 */
	public void insertStu(Student stu) {
		/**
		 * 
		 */
		if(dataIndex == (stuArray.length - 1)) {
			Student[] newStuArray = new Student[stuArray.length + stuArray.length>>1];
			for(int i = 0; i < dataIndex; i++) {
				newStuArray[i] = stuArray[i];
			}
			stuArray = newStuArray;
		}
		
		stuArray[dataIndex] = stu;
		dataIndex++;
	}
	
	/**
	 * 删除学生信息
	 * @param stuNo
	 */
	public void deleteStu() {
		System.out.println("请输入要删除的学生学号：");
		String stuNo=scanner.next();
		for(int i=0;i<stuArray.length;i++)
		{
			if(stuArray[i]==null)
			{
				break;
			}else
			{
				if(stuArray[i].getStuNo().equals(stuNo))
				{
					System.out.println("要删除的学生信息为：\t");
					stu.toString(stuArray[i]);
					for(int a=i+1;a<stuArray.length;a++)
					{
						stuArray[a-1]=stuArray[a];
					}
					Student[] stu2=new Student[9];
					for(int b=0;b<9;b++)
					{
						stu2[b]=stuArray[b];
					}
					
					stuArray=stu2;
				}else
				{
					continue;
				}
			}
		}
		getAllStus();
		
	}
	
	/**
	 * 修改学生信息
	 */
	public void updateStu() {
		System.out.println("请输入要修改的学生学号：");
		String stuNo=scanner.next();
		for(int i=0;i<stuArray.length;i++)
		{
			if(stuArray[i]==null)
			{
				break;
			}else
			{
				if(stuArray[i].getStuNo().equals(stuNo))
				{
					Student student = new Student();
					System.out.println("请按姓名，性别，年龄，成绩的顺序输入要修改的数据，以空格分割");
					student.setStuNo(stuNo);
					student.setStuName(scanner.next().trim());
					student.setGender(scanner.next().trim().charAt(0));
					student.setAge(scanner.nextInt());
					student.setScore(scanner.nextInt());
					
					stuArray[i]=student;
					
					System.out.println("更改的信息为 ：");
					stu.toString(stuArray[i]);
				}else
				{
					continue;
				}
				
			}
		}
		getAllStus();
		
		
	}
	
	/**
	 * 根据学生编号打印学生信息
	 * @param stuNo
	 */
	public Student getStuInfoByStuo(){
		    System.out.println("请输入要查询的学生号:");
		    
		    String stuNo=scanner.next();
			int a=0;
			for(int i=0;i<stuArray.length-1;i++)
			{
				if(stuArray[i]==null)
				{
					break;
				}else 
				{
					if(stuArray[i].getStuNo().equals(stuNo))
					{
						stu.toString(stuArray[i]);
						a=1;
					}else
					{
						continue;
					}
				}
			}
			if(a!=1)
			{
				System.out.println("该系统中没有您要查找的数！");
			}
			return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Student getAllStus() {
		
		System.out.println("全部学生信息如下：");
		for(int i=0;i<stuArray.length;i++)
		{
			if(stuArray[i]!=null)
			{
				stu.toString(stuArray[i]);
			}else
			{
				break;
			}
		}
		return null;
	}

}
