package com.entity;

import java.util.Date;

/*
 * �û�ʵ��
 */
public class User {
	private String s_id;   //ѧ��ѧ��
	private String s_password; //����
	private String s_name;	//����
	private Date s_birthday;	//����
	private String s_sex;	//�Ա�
	private String s_card;	//���֤
	private String s_nation;	//����
	private String s_academy;	//ѧԺ
	private String s_grade;	//�꼶
	private String s_major;	//רҵ
	private String s_class;	//�༶
	private String s_phone;	//�绰
	private Date update_time; //����ʱ��
	private int qx; //Ȩ��
	public User(){}
	
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public Date getS_birthday() {
		return s_birthday;
	}
	public void setS_birthday(Date s_birthday) {
		this.s_birthday = s_birthday;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public String getS_card() {
		return s_card;
	}
	public void setS_card(String s_card) {
		this.s_card = s_card;
	}
	public String getS_nation() {
		return s_nation;
	}
	public void setS_nation(String s_nation) {
		this.s_nation = s_nation;
	}
	public String getS_academy() {
		return s_academy;
	}
	public void setS_academy(String s_academy) {
		this.s_academy = s_academy;
	}
	public String getS_grade() {
		return s_grade;
	}
	public void setS_grade(String s_grade) {
		this.s_grade = s_grade;
	}
	public String getS_major() {
		return s_major;
	}
	public void setS_major(String s_major) {
		this.s_major = s_major;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getQx() {
		return qx;
	}

	public void setQx(int qx) {
		this.qx = qx;
	}

	
}
