package com.netty.server;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main(String[] args)
    {
		NettyServer server = new NettyServer();
		server.start(8000);

//		ByteToMessageDecoder
		// MessageToByteEncoder
    }
}
