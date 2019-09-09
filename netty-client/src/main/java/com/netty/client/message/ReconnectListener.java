package com.netty.client.message;

import java.util.Properties;

import com.netty.client.NettyClient;
import com.netty.client.utils.Constants;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

public class ReconnectListener implements ChannelFutureListener{
	private NettyClient client;

	//@Override
	public void operationComplete(ChannelFuture future) throws Exception {
		if (future.isSuccess()) {
			System.out.println("client connect successfully.");
		} else {
			reconnect();
		}
	}
	
	public void reconnect() {
		client = new NettyClient(new Properties().getProperty(Constants.connect_ip), Integer.valueOf(new Properties().getProperty(Constants.connect_port)));
		client.start();
	}

}
