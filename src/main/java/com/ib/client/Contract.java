/* Copyright (C) 2013 Interactive Brokers LLC. All rights reserved.  This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */

package com.ib.client;

import java.util.Vector;

public class Contract implements Cloneable {

	public int m_conId;
	public String m_symbol;
	public String m_secType; // STK-美国股票,STOCK.HK - 亚洲股票 ,STOCK.EU - 欧洲股票
	public String m_expiry;
	public double m_strike;
	public String m_right;
	public String m_multiplier;
	public String m_exchange;

	public String m_currency;
	public String m_localSymbol;
	public String m_tradingClass;
	public String m_primaryExch; // pick a non-aggregate (ie not the SMART
									// exchange) exchange that the contract
									// trades on. DO NOT SET TO SMART.
	public boolean m_includeExpired; // can not be set to true for orders.

	public String m_secIdType; // CUSIP;SEDOL;ISIN;RIC
	public String m_secId;

	// COMBOS
	public String m_comboLegsDescrip; // received in open order version 14 and
										// up for all combos
	public Vector<ComboLeg> m_comboLegs = new Vector<ComboLeg>();

	// delta neutral
	public UnderComp m_underComp;

	public Contract() {
		m_conId = 0;
		m_strike = 0;
		m_includeExpired = false;
	}

	@SuppressWarnings("unchecked")
	public Object clone() throws CloneNotSupportedException {
		Contract retval = (Contract) super.clone();
		retval.m_comboLegs = (Vector<ComboLeg>) retval.m_comboLegs.clone();
		return retval;
	}

	public Contract(int p_conId, String p_symbol, String p_secType, String p_expiry, double p_strike, String p_right, String p_multiplier,
			String p_exchange, String p_currency, String p_localSymbol, String p_tradingClass, Vector<ComboLeg> p_comboLegs, String p_primaryExch,
			boolean p_includeExpired, String p_secIdType, String p_secId) {
		m_conId = p_conId;
		m_symbol = p_symbol;
		m_secType = p_secType;
		m_expiry = p_expiry;
		m_strike = p_strike;
		m_right = p_right;
		m_multiplier = p_multiplier;
		m_exchange = p_exchange;
		m_currency = p_currency;
		m_includeExpired = p_includeExpired;
		m_localSymbol = p_localSymbol;
		m_tradingClass = p_tradingClass;
		m_comboLegs = p_comboLegs;
		m_primaryExch = p_primaryExch;
		m_secIdType = p_secIdType;
		m_secId = p_secId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contract [m_conId=").append(m_conId).append(", ");
		if (m_symbol != null)
			builder.append("m_symbol=").append(m_symbol).append(", ");
		if (m_secType != null)
			builder.append("m_secType=").append(m_secType).append(", ");
		if (m_expiry != null)
			builder.append("m_expiry=").append(m_expiry).append(", ");
		builder.append("m_strike=").append(m_strike).append(", ");
		if (m_right != null)
			builder.append("m_right=").append(m_right).append(", ");
		if (m_multiplier != null)
			builder.append("m_multiplier=").append(m_multiplier).append(", ");
		if (m_exchange != null)
			builder.append("m_exchange=").append(m_exchange).append(", ");
		if (m_currency != null)
			builder.append("m_currency=").append(m_currency).append(", ");
		if (m_localSymbol != null)
			builder.append("m_localSymbol=").append(m_localSymbol).append(", ");
		if (m_tradingClass != null)
			builder.append("m_tradingClass=").append(m_tradingClass).append(", ");
		if (m_primaryExch != null)
			builder.append("m_primaryExch=").append(m_primaryExch).append(", ");
		builder.append("m_includeExpired=").append(m_includeExpired).append(", ");
		if (m_secIdType != null)
			builder.append("m_secIdType=").append(m_secIdType).append(", ");
		if (m_secId != null)
			builder.append("m_secId=").append(m_secId).append(", ");
		if (m_comboLegsDescrip != null)
			builder.append("m_comboLegsDescrip=").append(m_comboLegsDescrip).append(", ");
		if (m_comboLegs != null)
			builder.append("m_comboLegs=").append(m_comboLegs).append(", ");
		if (m_underComp != null)
			builder.append("m_underComp=").append(m_underComp);
		builder.append("]");
		return builder.toString();
	}

}
