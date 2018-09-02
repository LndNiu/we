package com.zzxt.agent.studentt;

public class StuData {

	private Student[] stuArray = new Student[10];
	
	private int dataIndex = 0;
	
	/**
	 * 增加学生信息
	 * @param stu
	 */
	public void insertStu(Student stu) {
		if(stu == null) {
			return;
		}
		/**
		 * 当学生数组没有位置存储学生信息时，以1.5倍增长数组长度。
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
	public void deleteStu(String stuNo) {
		if(stuNo == null) {
			return;
		}
		
		boolean boo = false;
		for(int i = 0; i < dataIndex-1; i++) {
			if(boo || stuNo.equals(stuArray[i].getStuNo())) {
				boo = true;
				
			}
			if(boo) {
				stuArray[i] = stuArray[i+1];
			}
		}
		dataIndex--;
	}
	
	/**
	 * 
	 * 
	 * 
	 * 修改学生信息
	 */
	public void updateStu(Student stu) {
		
//		if(stu.getStuNo() != null && stu == null) {
		if(stu == null && stu.getStuNo() != null) {
			return;
		}
		for(int i = 0; i < dataIndex; i++) {
			if(stu.getStuNo().equals(stuArray[i].getStuNo())) {
				stuArray[i] = stu;
			}
		}
		
		
	}
	
	/**
	 * 根据学生编号打印学生信息
	 * @param stuNo
	 */
	public Student getStuInfoByStuo(String stuNo){
		if(stuNo != null) {
			for(int i = 0; i < dataIndex; i++) {
				if(stuNo.equals(stuArray[i].getStuNo())) {
					return stuArray[i];
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Student[] getAllStus() {
		if(dataIndex > 1) {
			Student[] retrunValues = new Student[dataIndex];
			for(int i = 0; i< dataIndex; i++) {
				retrunValues[i] = stuArray[i];
			}
			
			return retrunValues;
		}
		return null;
	}
	
	public void printArray() {
		for(Student stu : stuArray) {
			System.out.println("-------------->" + stu);
		}
	}
	
	public void checkStrEquals(String str) {
		
		if(str.equals("hello")) {
			
		}
		
		if("hello".equals(str)) {
			
		}
		
	}
//	
//	public static void main(String[] args) {
////		StuData sd = new StuData();
////		sd.printArray();
//		
//		Student stu = null;
//		
//		String str0 = null, str1 = "hello";
//		
////		System.out.println("-------------------------->" + (str0.equals(str1)));
//		System.out.println("-------------------------->" + (str1.equals(str0)));
//		
////		System.out.println("-------------->" + stu.getStuNo());
////		System.out.println("-------------->" + Student.getStuNo());
//	}
}
