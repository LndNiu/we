package com.zzxt.agent.studentt;

public class Student {

	/**
	 * 学号
	 */
	private String stuNo;
	
	/**
	 * 学生姓名
	 */
	private String stuName;
	
	/**
	 * 性别
	 * 
	 * F：女性   
	 * M：男性
	 */
	private char gender;
	
	/**
	 * 年龄
	 */
	private int age;
	
	
	/**
	 * 成绩
	 */
	private int score;


	/**
	 * @return the stuNo
	 */
	public String getStuNo() {
		return stuNo;
	}


	/**
	 * @param stuNo the stuNo to set
	 */
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}


	/**
	 * @return the stuName
	 */
	public String getStuName() {
		return stuName;
	}


	/**
	 * @param stuName the stuName to set
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		if(gender == 'M') {
			return "男";
		}else if(gender == 'F') {
			return "女";
		}
		return null;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		
		if(gender != 'F' && gender != 'M') {
			System.out.println("你输入的数据不合规！");
			return;
		}
		this.gender = gender;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}


	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
}
