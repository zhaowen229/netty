package com.netty.client;

public class AppClient {

	public static void main(String[] args) {
		NettyClient client = new NettyClient("localhost", 8000);
		client.start();
	}

}
