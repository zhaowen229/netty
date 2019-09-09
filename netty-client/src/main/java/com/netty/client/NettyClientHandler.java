package com.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
	
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("接受到server响应数据: ");
        super.channelRead(ctx, msg);
    }

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
	@Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
        	
        	IdleState idString = ((IdleStateEvent) evt).state();
        	switch (idString) {
			case READER_IDLE:
				//reconnect
				break;
			case WRITER_IDLE:
//				System.out.println("长期未向服务器发送数据");
				ctx.writeAndFlush(new Object());
				break;
			default:
				break;
			}
		} else {
			super.userEventTriggered(ctx, evt);
		}
    }

}
