package com.homaer.stock.client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HmClientSocket {
	private final static Logger log = LoggerFactory.getLogger(HmClientSocket.class);

	private static final byte[] EOL = { 0 };
	private static final String CLIENT_VERSION = "63";

	private final String host;
	private final int port;
	private final Socket socket = new Socket();
	private BufferedOutputStream bos;

	// private int m_clientId;

	public HmClientSocket(String host, int port) throws IOException {
		log.debug("init socket {}:{}", host, port);
		this.host = host;
		this.port = port;
	}

	public void connect() throws IOException {
		socket.connect(host != null ? new InetSocketAddress(host, port) : new InetSocketAddress(InetAddress.getByName(null), port));
		this.bos = new BufferedOutputStream(socket.getOutputStream());
		send(CLIENT_VERSION);
	}

	public void checkConnected() {

	}

	protected void send(String str) throws IOException {
		if (StringUtils.isNotBlank(str)) {
			bos.write(str.getBytes());

		}
		bos.write(EOL);
	}
}
