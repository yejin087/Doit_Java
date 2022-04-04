package com.day6_3;

interface PhoneInterface {
	final int TIMEOUT = 10000;

	void sendCall();

	void receiveCall();

	default void printlogo() {
		System.out.println("@@@");
	}
}

interface MobileInerface extends PhoneInterface {
	void sendSMS();

	void receiveSMS();

}

interface MP3Interface extends PhoneInterface {
	void play();

	void stop();
}

class PDA {
	public int calculate(int x, int y) {
		return x + y;
	}
}

public class InterfaceEx extends PDA implements MobileInerface, MP3Interface {
	public static void main(String[] args) {
		InterfaceEx ex = new InterfaceEx();
		ex.sendCall();
		ex.receiveCall();
		ex.sendCall();
		ex.play();
		ex.printlogo();
		System.out.println(ex.calculate(3, 5));
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("play");
	}

	@Override
	public void receiveCall() {
		// TODO Auto-generated method stub
		System.out.println("recive call");
	}

	@Override
	public void receiveSMS() {
		// TODO Auto-generated method stub
		System.out.println("recive sms");
	}

	@Override
	public void sendCall() {
		// TODO Auto-generated method stub
		System.out.println("send call");
	}

	@Override
	public void sendSMS() {
		// TODO Auto-generated method stub
		System.out.println("send sms");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("stop");
	}

}
