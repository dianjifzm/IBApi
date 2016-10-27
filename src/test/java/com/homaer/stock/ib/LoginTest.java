package com.homaer.stock.ib;

import org.junit.Test;

import com.homaer.stock.client.HmWrapper;
import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.Order;

public class LoginTest {

	@Test
	public void reqManagedAccts() throws Exception {
		HmWrapper ac = new HmWrapper();
		EClientSocket client = new EClientSocket("127.0.0.1", 4002, 0, ac);
		client.reqManagedAccts();// 用户列表查询
		Thread.sleep(1000);
		client.eDisconnect();
	}

	@Test
	public void placeOrder() throws Exception {
		HmWrapper ac = new HmWrapper();
		EClientSocket client = new EClientSocket("127.0.0.1", 4002, 0, ac);
		Contract contract = new Contract();
		contract.m_exchange = "SMART";// 交易所
		contract.m_secType = "STK";
		contract.m_currency = "USD";
		contract.m_symbol = "TSLA";

		Order order = new Order();
		order.m_action = "BUY";
		order.m_totalQuantity = 100;
		order.m_orderType = "LMT";
		order.m_lmtPrice = 100;
		order.m_account = "DF16105";

		client.placeOrder(7, contract, order);
		Thread.sleep(4000);
		client.eDisconnect();
	}

	@Test
	public void reqOpenOrders() throws Exception {
		HmWrapper ac = new HmWrapper();
		EClientSocket client = new EClientSocket("127.0.0.1", 4002, 0, ac);
		client.reqOpenOrders();
		Thread.sleep(1000);
		client.eDisconnect();
	}
}
