package com.grademanager;

import java.util.Scanner;

/**
 * 学生成绩管理系统
 * 实现的功能
 * 1.初始化数学成绩
 * 2.求成绩的平均值
 * 3.统计成绩大于85分的人数
 * 4.修改指定位置处的成绩
 * 5.打印输出所有成绩
 * 0.退出
 * @author QY
 *
 */
public class GradeManager {
/**
 * 显示菜单
 */
	public void displayMenu() {
		System.out.println("************************************************");
		System.out.println("                1--初始化数学成绩");
		System.out.println("                2--求成绩的平均值");
		System.out.println("                3--统计成绩大于85分的人数");
		System.out.println("                4--修改指定位置处的成绩");
		System.out.println("                5--打印输出所有成绩");
		System.out.println("                0--退出");
		System.out.println("************************************************");
	}
/**
 * 初始化数学成绩
 * @return 数组
 */
	public float[] initScore() {
		float[] scoreArry = null;
		int length = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要存储的数学成绩的数量：");
		while(true)
		{
			try {
				length = sc.nextInt();
				if(length <= 0) {
					System.out.println("请输入正确的人数！");
					continue;
				}
				scoreArry = new float[length];
				break;
			} catch (java.util.InputMismatchException err) {
				System.out.println("请输入正确的数字");
				sc.next();
				continue;
			}
		}
		for(int i = 0; i < length; i++) {
			try {
				System.out.println("请输入第" + (i + 1) + "个数据：");
				scoreArry[i] = sc.nextFloat();
			} catch(java.util.InputMismatchException err) {
				System.out.println("请输入正确的格式!");
				sc.next();
				i--;
				continue;
			}
		}
		return scoreArry;
	}
/**
 * 求平均成绩
 * @param f 成绩数组
 * @return 返回平均值
 */
	public float average(float[] f) {
		float ave = 0;
		float sum = 0;
		if(f != null) {
			for(float n:f) {
				sum +=n;
			}
			ave = sum / f.length;
			System.out.println("数学平均成绩为：" + ave);
		} else {
			System.out.println("数组为空，请先添加数据！");
		}
		return ave;
	}
/**
 * 统计成绩大于85分的人数
 * @param f 成绩数组
 * @return  统计人数
 */
	public int count(float[] f) {
		int cnt = 0;
		if(f != null) {
			for(float n:f) {
				if(n > 85)cnt++;
			}
			System.out.println("成绩大于85分的人数为：" + cnt);
		} else {
			System.out.println("数组为空，请先添加数据！");
		}
		return cnt;
	}
/**
 * 修改指定位置的成绩
 * @param f 成绩数组
 */
	public void update(float[] f) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		float newScore = 0;
		if(f != null) {
			System.out.println("修改前的成绩：");
			for (float n:f) {
				System.out.print(n + "  ");
			}
			//换行
			System.out.println();
			//获取要修改的下标
			while(true) {
				try {
					System.out.println("请输入要修改数据的位置（从0开始）");
					index = sc.nextInt();
					//判断是否超出数组范围
					if (index < f.length && index >=0) {
						break;
					} else {
						System.out.println("位置超出数据的范围！！");
						continue;
					}
				} catch (java.util.InputMismatchException err) {
					//输入格式异常判断
					sc.next();
					System.out.println("请输入正确的数字！");
					continue;
				}
			}
			//获取要修改的成绩
			while(true) {
				try {
					System.out.println("请输入要修改的成绩");
					newScore = sc.nextFloat();
					f[index] = newScore;
					System.out.println("修改后的成绩：");
					for(float n:f) {
						System.out.print(n + "   ");
					}
					//换行
					System.out.println("");
					break;
				} catch(java.util.InputMismatchException err) {			
					System.out.println("请输入正确的分数！");
					sc.next();
					continue;
				}
			}
		} else {
			System.out.println("数组为空，请先添加数据！");
		}
	}
/**
 * 打印输出所有成绩
 * @param f 成绩数组
 */
	public void displayAllScore(float [] f) {
		if (f != null) {
			for (float n:f) {
				System.out.print(n + "   ");
			}
			System.out.println();
		} else {
			System.out.println("数组为空，请先添加数据！");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GradeManager gm = new GradeManager();
		Scanner sc = new Scanner(System.in);
		//键盘输入
		int input;
		//判断while循环
		boolean flag = true;
		//成绩数组
		float[] score = null;
		//成绩平均值
		float ave = 0;
		//统计人数
		int count = 0;
		while(flag) {
			gm.displayMenu();
			System.out.println("请输入对应的数字进行操作：");
			try {
				input  = sc.nextInt();
				switch(input) {
				//初始化数学成绩
				case 1:
					score = gm.initScore();
					break;
				//求成绩的平均值
				case 2:
					ave = gm.average(score);
					break;
				//求统计大于85分的人数
				case 3:
					count = gm.count(score);
					break;
				//修改指定位置处的成绩
				case 4:
					gm.update(score);
					break;
				//打印输出所有成绩
				case 5:
					gm.displayAllScore(score);
					break;
				//退出程序
				case 0:
					flag = false;
					System.out.println("已退出！");
					break;
				//异常
				default:
					System.out.println("请输入0-5进行操作！");
					break;
				}
			} catch (java.util.InputMismatchException err) {
				System.out.println("请输入0-5进行操作！");
				sc.next();
			}
		}
	}
}
