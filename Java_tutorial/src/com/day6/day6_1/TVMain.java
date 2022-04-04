package com.day6_1;

class TV1 {
	protected int inch;

	public TV1(int inch) {
		this.inch = inch;
	}

	public void print() {
		System.out.printf("%dinch ", inch);
	}
}

class ColorTV extends TV1 {
	private int color;

	public ColorTV(int inch, int color) {
		super(inch);
		this.color = color;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(color + "color");
	}
}

class IPTV extends ColorTV {
	private String ip;

	public IPTV(String ip, int inch, int color) {
		super(inch, color);
		this.ip = ip;
	}

	@Override
	public void print() {
		System.out.print(ip + "ip ");
		super.print();
	}

}

public class TVMain {
	public static void main(String[] args) {

		ColorTV mytv = new ColorTV(32, 1024);
		mytv.print();

		ColorTV iptv = new IPTV("192.1.1.2", 32, 2048);
		iptv.print();
	}
}
