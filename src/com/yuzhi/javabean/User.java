package com.yuzhi.javabean;

import java.sql.Date;

public class User {
	private int id;
	private Date date;
	private String name;
	private double jbgz;// ��������
	private double gwgz;// ��λ����
	private double yjj;// �½���
	private double ylbx;// ���ϱ���

	private double zfgjj;// ס��������
	private double yfgz;// ������

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getJbgz() {
		return jbgz;
	}

	public void setJbgz(double jbgz) {
		this.jbgz = jbgz;
	}

	public double getGwgz() {
		return gwgz;
	}

	public void setGwgz(double gwgz) {
		this.gwgz = gwgz;
	}

	public double getYjj() {
		return yjj;
	}

	public void setYjj(double yjj) {
		this.yjj = yjj;
	}

	public double getYlbx() {
		return ylbx;
	}

	public void setYlbx(double ylbx) {
		this.ylbx = ylbx;
	}

	public double getZfgjj() {
		return zfgjj;
	}

	public void setZfgjj(double zfgjj) {
		this.zfgjj = zfgjj;
	}

	public double getYfgz() {
		return yfgz;
	}

	public void setYfgz(double yfgz) {
		this.yfgz = yfgz;
	}

}
