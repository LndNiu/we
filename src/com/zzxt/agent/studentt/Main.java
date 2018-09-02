package com.zzxt.agent.studentt;

import java.util.Scanner;

public class Main {

	private StuData sd = new StuData();
	
	public static void main(String[] args) {
		Main main = new Main();
		
		
		main.sayHello();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			main.pringMenu();
			switch(scanner.nextInt()) {
			case 0:{
				main.printAllStu();
				break;
			}
			case 1:{
//				sd.getStuInfoByStuo("");
				break;
			}
			case 2:{
				main.addStu(scanner);
				break;
			}
			case 3:{
				main.updateStu(scanner);
				break;
			}
			case 4:{
				main.deleteStu(scanner);
				break;
			}
			case 5:{
				System.out.println("bye bye!");
				System.exit(0);
			}
			//....
			default:{
				System.out.println("你输入的命令不合规！");
			}
			}
		}
		
		
	}
	
	public void sayHello() {
		System.out.println("******************欢迎登陆郑大学生信息管理系统*******************");
	}
	
	public void pringMenu() {
		System.out.println("\n\n\n0、查看学生信息列表；");
		System.out.println("1、查看学生信息");
		System.out.println("2、添加学生信息");
		System.out.println("3、修改学生信息");
		System.out.println("4、删除学生信息");
		System.out.println("5、退出");
		System.out.print("请选择操作：");
	}
	
	/**
	 * 
	 * @param scanner
	 */
	public void addStu(Scanner scanner) {
		System.out.println("请输入学生编号 学生姓名  性别(女：F 男：M)   年龄   成绩   以空格分割");
		Student stu = new Student();
		stu.setStuNo(scanner.next().trim());
		stu.setStuName(scanner.next().trim());
		stu.setGender(scanner.next().trim().charAt(0));
		stu.setAge(scanner.nextInt());
		stu.setScore(scanner.nextInt());
		sd.insertStu(stu);
		System.out.println("\n\n学习信息添加成功！\n\n");
	}
	
	
	public void deleteStu(Scanner scanner) {
		System.out.println("请输入要删除的学生编号：");
		String stuNo = scanner.next();
		if(sd.getStuInfoByStuo(stuNo) != null) {
			sd.deleteStu(stuNo);
			System.out.println("学生信息删除成功！");
		}else {
			System.out.println("你输入的学生编号不存在！");
		}
	}
	
	/**
	 * 
	 * @param scanner
	 */
	public void updateStu(Scanner scanner) {
		System.out.println("请输入要修改的学生编号：");
		String stuNo = scanner.next();
		Student stu = sd.getStuInfoByStuo(stuNo);
		if(stu != null) {
			System.out.println("请输入学生姓名  性别(女：F 男：M)   年龄   成绩   以空格分割");
			stu.setStuName(scanner.next().trim());
			stu.setGender(scanner.next().trim().charAt(0));
			stu.setAge(scanner.nextInt());
			stu.setScore(scanner.nextInt());
			sd.updateStu(stu);
			System.out.println("学生信息修改成功！");
		}else {
			System.out.println("不存在此学生信息！！");
		}
	}
	
	public void printAllStu() {
		System.out.println("\n\n\n 学生编号  |  学生名称        |  性别       |  年龄       | 成绩 ");
		Student[] stuArray = sd.getAllStus();
		if(stuArray == null) {
			System.out.println("-----------无学生信息-----------------");
			return;
		}
		
		for(Student stu : stuArray) {
			System.out.println(stu.getStuNo() + "   |   " + stu.getStuName() + "   |   " + stu.getGender() + "   |   " + stu.getAge() + "   |   " + stu.getScore());
		}
	}
	
}
