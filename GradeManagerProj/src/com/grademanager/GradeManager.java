package com.grademanager;

import java.util.Scanner;

/**
 * ѧ���ɼ�����ϵͳ
 * ʵ�ֵĹ���
 * 1.��ʼ����ѧ�ɼ�
 * 2.��ɼ���ƽ��ֵ
 * 3.ͳ�Ƴɼ�����85�ֵ�����
 * 4.�޸�ָ��λ�ô��ĳɼ�
 * 5.��ӡ������гɼ�
 * 0.�˳�
 * @author QY
 *
 */
public class GradeManager {
/**
 * ��ʾ�˵�
 */
	public void displayMenu() {
		System.out.println("************************************************");
		System.out.println("                1--��ʼ����ѧ�ɼ�");
		System.out.println("                2--��ɼ���ƽ��ֵ");
		System.out.println("                3--ͳ�Ƴɼ�����85�ֵ�����");
		System.out.println("                4--�޸�ָ��λ�ô��ĳɼ�");
		System.out.println("                5--��ӡ������гɼ�");
		System.out.println("                0--�˳�");
		System.out.println("************************************************");
	}
/**
 * ��ʼ����ѧ�ɼ�
 * @return ����
 */
	public float[] initScore() {
		float[] scoreArry = null;
		int length = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫ�洢����ѧ�ɼ���������");
		while(true)
		{
			try {
				length = sc.nextInt();
				if(length <= 0) {
					System.out.println("��������ȷ��������");
					continue;
				}
				scoreArry = new float[length];
				break;
			} catch (java.util.InputMismatchException err) {
				System.out.println("��������ȷ������");
				sc.next();
				continue;
			}
		}
		for(int i = 0; i < length; i++) {
			try {
				System.out.println("�������" + (i + 1) + "�����ݣ�");
				scoreArry[i] = sc.nextFloat();
			} catch(java.util.InputMismatchException err) {
				System.out.println("��������ȷ�ĸ�ʽ!");
				sc.next();
				i--;
				continue;
			}
		}
		return scoreArry;
	}
/**
 * ��ƽ���ɼ�
 * @param f �ɼ�����
 * @return ����ƽ��ֵ
 */
	public float average(float[] f) {
		float ave = 0;
		float sum = 0;
		if(f != null) {
			for(float n:f) {
				sum +=n;
			}
			ave = sum / f.length;
			System.out.println("��ѧƽ���ɼ�Ϊ��" + ave);
		} else {
			System.out.println("����Ϊ�գ�����������ݣ�");
		}
		return ave;
	}
/**
 * ͳ�Ƴɼ�����85�ֵ�����
 * @param f �ɼ�����
 * @return  ͳ������
 */
	public int count(float[] f) {
		int cnt = 0;
		if(f != null) {
			for(float n:f) {
				if(n > 85)cnt++;
			}
			System.out.println("�ɼ�����85�ֵ�����Ϊ��" + cnt);
		} else {
			System.out.println("����Ϊ�գ�����������ݣ�");
		}
		return cnt;
	}
/**
 * �޸�ָ��λ�õĳɼ�
 * @param f �ɼ�����
 */
	public void update(float[] f) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		float newScore = 0;
		if(f != null) {
			System.out.println("�޸�ǰ�ĳɼ���");
			for (float n:f) {
				System.out.print(n + "  ");
			}
			//����
			System.out.println();
			//��ȡҪ�޸ĵ��±�
			while(true) {
				try {
					System.out.println("������Ҫ�޸����ݵ�λ�ã���0��ʼ��");
					index = sc.nextInt();
					//�ж��Ƿ񳬳����鷶Χ
					if (index < f.length && index >=0) {
						break;
					} else {
						System.out.println("λ�ó������ݵķ�Χ����");
						continue;
					}
				} catch (java.util.InputMismatchException err) {
					//�����ʽ�쳣�ж�
					sc.next();
					System.out.println("��������ȷ�����֣�");
					continue;
				}
			}
			//��ȡҪ�޸ĵĳɼ�
			while(true) {
				try {
					System.out.println("������Ҫ�޸ĵĳɼ�");
					newScore = sc.nextFloat();
					f[index] = newScore;
					System.out.println("�޸ĺ�ĳɼ���");
					for(float n:f) {
						System.out.print(n + "   ");
					}
					//����
					System.out.println("");
					break;
				} catch(java.util.InputMismatchException err) {			
					System.out.println("��������ȷ�ķ�����");
					sc.next();
					continue;
				}
			}
		} else {
			System.out.println("����Ϊ�գ�����������ݣ�");
		}
	}
/**
 * ��ӡ������гɼ�
 * @param f �ɼ�����
 */
	public void displayAllScore(float [] f) {
		if (f != null) {
			for (float n:f) {
				System.out.print(n + "   ");
			}
			System.out.println();
		} else {
			System.out.println("����Ϊ�գ�����������ݣ�");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GradeManager gm = new GradeManager();
		Scanner sc = new Scanner(System.in);
		//��������
		int input;
		//�ж�whileѭ��
		boolean flag = true;
		//�ɼ�����
		float[] score = null;
		//�ɼ�ƽ��ֵ
		float ave = 0;
		//ͳ������
		int count = 0;
		while(flag) {
			gm.displayMenu();
			System.out.println("�������Ӧ�����ֽ��в�����");
			try {
				input  = sc.nextInt();
				switch(input) {
				//��ʼ����ѧ�ɼ�
				case 1:
					score = gm.initScore();
					break;
				//��ɼ���ƽ��ֵ
				case 2:
					ave = gm.average(score);
					break;
				//��ͳ�ƴ���85�ֵ�����
				case 3:
					count = gm.count(score);
					break;
				//�޸�ָ��λ�ô��ĳɼ�
				case 4:
					gm.update(score);
					break;
				//��ӡ������гɼ�
				case 5:
					gm.displayAllScore(score);
					break;
				//�˳�����
				case 0:
					flag = false;
					System.out.println("���˳���");
					break;
				//�쳣
				default:
					System.out.println("������0-5���в�����");
					break;
				}
			} catch (java.util.InputMismatchException err) {
				System.out.println("������0-5���в�����");
				sc.next();
			}
		}
	}
}
