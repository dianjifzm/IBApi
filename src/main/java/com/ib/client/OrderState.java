/* Copyright (C) 2013 Interactive Brokers LLC. All rights reserved.  This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */

package com.ib.client;

public class OrderState {

	public String m_status;

	public String m_initMargin;
	public String m_maintMargin;
	public String m_equityWithLoan;

	public double m_commission;
	public double m_minCommission;
	public double m_maxCommission;
	public String m_commissionCurrency;

	public String m_warningText;

	OrderState() {
		this (null, null, null, null, 0.0, 0.0, 0.0, null, null);
	}

	OrderState(String status, String initMargin, String maintMargin,
			String equityWithLoan, double commission, double minCommission,
			double maxCommission, String commissionCurrency, String warningText) {

		m_initMargin = initMargin;
		m_maintMargin = maintMargin;
		m_equityWithLoan = equityWithLoan;
		m_commission = commission;
		m_minCommission = minCommission;
		m_maxCommission = maxCommission;
		m_commissionCurrency = commissionCurrency;
		m_warningText = warningText;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderState [m_status=").append(m_status).append(", m_initMargin=").append(m_initMargin).append(", m_maintMargin=")
				.append(m_maintMargin).append(", m_equityWithLoan=").append(m_equityWithLoan).append(", m_commission=").append(m_commission)
				.append(", m_minCommission=").append(m_minCommission).append(", m_maxCommission=").append(m_maxCommission)
				.append(", m_commissionCurrency=").append(m_commissionCurrency).append(", m_warningText=").append(m_warningText).append("]");
		return builder.toString();
	}

	 
}
