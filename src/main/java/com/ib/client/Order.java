/* Copyright (C) 2013 Interactive Brokers LLC. All rights reserved.  This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */

package com.ib.client;

import java.util.Vector;

public class Order {
	final public static int CUSTOMER = 0;
	final public static int FIRM = 1;
	final public static char OPT_UNKNOWN = '?';
	final public static char OPT_BROKER_DEALER = 'b';
	final public static char OPT_CUSTOMER = 'c';
	final public static char OPT_FIRM = 'f';
	final public static char OPT_ISEMM = 'm';
	final public static char OPT_FARMM = 'n';
	final public static char OPT_SPECIALIST = 'y';
	final public static int AUCTION_MATCH = 1;
	final public static int AUCTION_IMPROVEMENT = 2;
	final public static int AUCTION_TRANSPARENT = 3;
	final public static String EMPTY_STR = "";

	// main order fields
	public int m_orderId;
	public int m_clientId;
	public int m_permId;
	public String m_action;
	public int m_totalQuantity;
	public String m_orderType; // 限价单(LMT),市价单(MKT),触及限价(LIT),触及市价(MIT),收盘市价(MOC),收盘限价(LOC),挂钩市价(PEGMKT)
	// 相对(REL),止损(STP),止损限价(STPLMT),跟踪止损(TRAIL),跟踪止损限价(TRAILLIMIT),交易量加权平均价格(VWAP)
	// 波动率定单(VOL)
	public double m_lmtPrice;
	public double m_auxPrice;

	// extended order fields
	public String m_tif; // "Time in Force" - DAY, GTC, etc.
	public String m_activeStartTime; // GTC orders
	public String m_activeStopTime; // GTC orders
	public String m_ocaGroup; // one cancels all group name
	public int m_ocaType; // 1 = CANCEL_WITH_BLOCK, 2 = REDUCE_WITH_BLOCK, 3 =
							// REDUCE_NON_BLOCK
	public String m_orderRef;
	public boolean m_transmit; // if false, order will be created but not
								// transmited
	public int m_parentId; // Parent order Id, to associate Auto STP or TRAIL
							// orders with the original order.
	public boolean m_blockOrder;
	public boolean m_sweepToFill;
	public int m_displaySize;
	public int m_triggerMethod; // 0=Default, 1=Double_Bid_Ask, 2=Last,
								// 3=Double_Last, 4=Bid_Ask, 7=Last_or_Bid_Ask,
								// 8=Mid-point
	public boolean m_outsideRth;
	public boolean m_hidden;
	public String m_goodAfterTime; // FORMAT: 20060505 08:00:00 {time zone}
	public String m_goodTillDate; // FORMAT: 20060505 08:00:00 {time zone}
	public boolean m_overridePercentageConstraints;
	public String m_rule80A; // Individual = 'I', Agency = 'A', AgentOtherMember
								// = 'W', IndividualPTIA = 'J', AgencyPTIA =
								// 'U', AgentOtherMemberPTIA = 'M', IndividualPT
								// = 'K', AgencyPT = 'Y', AgentOtherMemberPT =
								// 'N'
	public boolean m_allOrNone;
	public int m_minQty;
	public double m_percentOffset; // REL orders only; specify the decimal, e.g.
									// .04 not 4
	public double m_trailStopPrice; // for TRAILLIMIT orders only
	public double m_trailingPercent; // specify the percentage, e.g. 3, not .03

	// Financial advisors only
	public String m_faGroup;
	public String m_faProfile;
	public String m_faMethod;
	public String m_faPercentage;

	// Institutional orders only
	public String m_openClose; // O=Open, C=Close
	public int m_origin; // 0=Customer, 1=Firm
	public int m_shortSaleSlot; // 1 if you hold the shares, 2 if they will be
								// delivered from elsewhere. Only for
								// Action="SSHORT
	public String m_designatedLocation; // set when slot=2 only.
	public int m_exemptCode;

	// SMART routing only
	public double m_discretionaryAmt;
	public boolean m_eTradeOnly;
	public boolean m_firmQuoteOnly;
	public double m_nbboPriceCap;
	public boolean m_optOutSmartRouting;

	// BOX or VOL ORDERS ONLY
	public int m_auctionStrategy; // 1=AUCTION_MATCH, 2=AUCTION_IMPROVEMENT,
									// 3=AUCTION_TRANSPARENT

	// BOX ORDERS ONLY
	public double m_startingPrice;
	public double m_stockRefPrice;
	public double m_delta;

	// pegged to stock or VOL orders
	public double m_stockRangeLower;
	public double m_stockRangeUpper;

	// VOLATILITY ORDERS ONLY
	public double m_volatility; // enter percentage not decimal, e.g. 2 not .02
	public int m_volatilityType; // 1=daily, 2=annual
	public int m_continuousUpdate;
	public int m_referencePriceType; // 1=Bid/Ask midpoint, 2 = BidOrAsk
	public String m_deltaNeutralOrderType;
	public double m_deltaNeutralAuxPrice;
	public int m_deltaNeutralConId;
	public String m_deltaNeutralSettlingFirm;
	public String m_deltaNeutralClearingAccount;
	public String m_deltaNeutralClearingIntent;
	public String m_deltaNeutralOpenClose;
	public boolean m_deltaNeutralShortSale;
	public int m_deltaNeutralShortSaleSlot;
	public String m_deltaNeutralDesignatedLocation;

	// COMBO ORDERS ONLY
	public double m_basisPoints; // EFP orders only, download only
	public int m_basisPointsType; // EFP orders only, download only

	// SCALE ORDERS ONLY
	public int m_scaleInitLevelSize;
	public int m_scaleSubsLevelSize;
	public double m_scalePriceIncrement;
	public double m_scalePriceAdjustValue;
	public int m_scalePriceAdjustInterval;
	public double m_scaleProfitOffset;
	public boolean m_scaleAutoReset;
	public int m_scaleInitPosition;
	public int m_scaleInitFillQty;
	public boolean m_scaleRandomPercent;
	public String m_scaleTable;

	// HEDGE ORDERS ONLY
	public String m_hedgeType; // 'D' - delta, 'B' - beta, 'F' - FX, 'P' - pair
	public String m_hedgeParam; // beta value for beta hedge (in range 0-1),
								// ratio for pair hedge

	// Clearing info
	public String m_account; // IB account
	public String m_settlingFirm;
	public String m_clearingAccount; // True beneficiary of the order
	public String m_clearingIntent; // "" (Default), "IB", "Away", "PTA"
									// (PostTrade)

	// ALGO ORDERS ONLY
	public String m_algoStrategy;
	public Vector<TagValue> m_algoParams;

	// What-if
	public boolean m_whatIf;

	// Not Held
	public boolean m_notHeld;

	// Smart combo routing params
	public Vector<TagValue> m_smartComboRoutingParams;

	// order combo legs
	public Vector<OrderComboLeg> m_orderComboLegs = new Vector<OrderComboLeg>();

	// order misc options
	public Vector<TagValue> m_orderMiscOptions;

	public Order() {
		m_lmtPrice = Double.MAX_VALUE;
		m_auxPrice = Double.MAX_VALUE;
		m_activeStartTime = EMPTY_STR;
		m_activeStopTime = EMPTY_STR;
		m_outsideRth = false;
		m_openClose = "O";
		m_origin = CUSTOMER;
		m_transmit = true;
		m_designatedLocation = EMPTY_STR;
		m_exemptCode = -1;
		m_minQty = Integer.MAX_VALUE;
		m_percentOffset = Double.MAX_VALUE;
		m_nbboPriceCap = Double.MAX_VALUE;
		m_optOutSmartRouting = false;
		m_startingPrice = Double.MAX_VALUE;
		m_stockRefPrice = Double.MAX_VALUE;
		m_delta = Double.MAX_VALUE;
		m_stockRangeLower = Double.MAX_VALUE;
		m_stockRangeUpper = Double.MAX_VALUE;
		m_volatility = Double.MAX_VALUE;
		m_volatilityType = Integer.MAX_VALUE;
		m_deltaNeutralOrderType = EMPTY_STR;
		m_deltaNeutralAuxPrice = Double.MAX_VALUE;
		m_deltaNeutralConId = 0;
		m_deltaNeutralSettlingFirm = EMPTY_STR;
		m_deltaNeutralClearingAccount = EMPTY_STR;
		m_deltaNeutralClearingIntent = EMPTY_STR;
		m_deltaNeutralOpenClose = EMPTY_STR;
		m_deltaNeutralShortSale = false;
		m_deltaNeutralShortSaleSlot = 0;
		m_deltaNeutralDesignatedLocation = EMPTY_STR;
		m_referencePriceType = Integer.MAX_VALUE;
		m_trailStopPrice = Double.MAX_VALUE;
		m_trailingPercent = Double.MAX_VALUE;
		m_basisPoints = Double.MAX_VALUE;
		m_basisPointsType = Integer.MAX_VALUE;
		m_scaleInitLevelSize = Integer.MAX_VALUE;
		m_scaleSubsLevelSize = Integer.MAX_VALUE;
		m_scalePriceIncrement = Double.MAX_VALUE;
		m_scalePriceAdjustValue = Double.MAX_VALUE;
		m_scalePriceAdjustInterval = Integer.MAX_VALUE;
		m_scaleProfitOffset = Double.MAX_VALUE;
		m_scaleAutoReset = false;
		m_scaleInitPosition = Integer.MAX_VALUE;
		m_scaleInitFillQty = Integer.MAX_VALUE;
		m_scaleRandomPercent = false;
		m_scaleTable = EMPTY_STR;
		m_whatIf = false;
		m_notHeld = false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [m_orderId=").append(m_orderId).append(", m_clientId=").append(m_clientId).append(", m_permId=").append(m_permId)
				.append(", ");
		if (m_action != null)
			builder.append("m_action=").append(m_action).append(", ");
		builder.append("m_totalQuantity=").append(m_totalQuantity).append(", ");
		if (m_orderType != null)
			builder.append("m_orderType=").append(m_orderType).append(", ");
		builder.append("m_lmtPrice=").append(m_lmtPrice).append(", m_auxPrice=").append(m_auxPrice).append(", ");
		if (m_tif != null)
			builder.append("m_tif=").append(m_tif).append(", ");
		if (m_activeStartTime != null)
			builder.append("m_activeStartTime=").append(m_activeStartTime).append(", ");
		if (m_activeStopTime != null)
			builder.append("m_activeStopTime=").append(m_activeStopTime).append(", ");
		if (m_ocaGroup != null)
			builder.append("m_ocaGroup=").append(m_ocaGroup).append(", ");
		builder.append("m_ocaType=").append(m_ocaType).append(", ");
		if (m_orderRef != null)
			builder.append("m_orderRef=").append(m_orderRef).append(", ");
		builder.append("m_transmit=").append(m_transmit).append(", m_parentId=").append(m_parentId).append(", m_blockOrder=").append(m_blockOrder)
				.append(", m_sweepToFill=").append(m_sweepToFill).append(", m_displaySize=").append(m_displaySize).append(", m_triggerMethod=")
				.append(m_triggerMethod).append(", m_outsideRth=").append(m_outsideRth).append(", m_hidden=").append(m_hidden).append(", ");
		if (m_goodAfterTime != null)
			builder.append("m_goodAfterTime=").append(m_goodAfterTime).append(", ");
		if (m_goodTillDate != null)
			builder.append("m_goodTillDate=").append(m_goodTillDate).append(", ");
		builder.append("m_overridePercentageConstraints=").append(m_overridePercentageConstraints).append(", ");
		if (m_rule80A != null)
			builder.append("m_rule80A=").append(m_rule80A).append(", ");
		builder.append("m_allOrNone=").append(m_allOrNone).append(", m_minQty=").append(m_minQty).append(", m_percentOffset=")
				.append(m_percentOffset).append(", m_trailStopPrice=").append(m_trailStopPrice).append(", m_trailingPercent=")
				.append(m_trailingPercent).append(", ");
		if (m_faGroup != null)
			builder.append("m_faGroup=").append(m_faGroup).append(", ");
		if (m_faProfile != null)
			builder.append("m_faProfile=").append(m_faProfile).append(", ");
		if (m_faMethod != null)
			builder.append("m_faMethod=").append(m_faMethod).append(", ");
		if (m_faPercentage != null)
			builder.append("m_faPercentage=").append(m_faPercentage).append(", ");
		if (m_openClose != null)
			builder.append("m_openClose=").append(m_openClose).append(", ");
		builder.append("m_origin=").append(m_origin).append(", m_shortSaleSlot=").append(m_shortSaleSlot).append(", ");
		if (m_designatedLocation != null)
			builder.append("m_designatedLocation=").append(m_designatedLocation).append(", ");
		builder.append("m_exemptCode=").append(m_exemptCode).append(", m_discretionaryAmt=").append(m_discretionaryAmt).append(", m_eTradeOnly=")
				.append(m_eTradeOnly).append(", m_firmQuoteOnly=").append(m_firmQuoteOnly).append(", m_nbboPriceCap=").append(m_nbboPriceCap)
				.append(", m_optOutSmartRouting=").append(m_optOutSmartRouting).append(", m_auctionStrategy=").append(m_auctionStrategy)
				.append(", m_startingPrice=").append(m_startingPrice).append(", m_stockRefPrice=").append(m_stockRefPrice).append(", m_delta=")
				.append(m_delta).append(", m_stockRangeLower=").append(m_stockRangeLower).append(", m_stockRangeUpper=").append(m_stockRangeUpper)
				.append(", m_volatility=").append(m_volatility).append(", m_volatilityType=").append(m_volatilityType)
				.append(", m_continuousUpdate=").append(m_continuousUpdate).append(", m_referencePriceType=").append(m_referencePriceType)
				.append(", ");
		if (m_deltaNeutralOrderType != null)
			builder.append("m_deltaNeutralOrderType=").append(m_deltaNeutralOrderType).append(", ");
		builder.append("m_deltaNeutralAuxPrice=").append(m_deltaNeutralAuxPrice).append(", m_deltaNeutralConId=").append(m_deltaNeutralConId)
				.append(", ");
		if (m_deltaNeutralSettlingFirm != null)
			builder.append("m_deltaNeutralSettlingFirm=").append(m_deltaNeutralSettlingFirm).append(", ");
		if (m_deltaNeutralClearingAccount != null)
			builder.append("m_deltaNeutralClearingAccount=").append(m_deltaNeutralClearingAccount).append(", ");
		if (m_deltaNeutralClearingIntent != null)
			builder.append("m_deltaNeutralClearingIntent=").append(m_deltaNeutralClearingIntent).append(", ");
		if (m_deltaNeutralOpenClose != null)
			builder.append("m_deltaNeutralOpenClose=").append(m_deltaNeutralOpenClose).append(", ");
		builder.append("m_deltaNeutralShortSale=").append(m_deltaNeutralShortSale).append(", m_deltaNeutralShortSaleSlot=")
				.append(m_deltaNeutralShortSaleSlot).append(", ");
		if (m_deltaNeutralDesignatedLocation != null)
			builder.append("m_deltaNeutralDesignatedLocation=").append(m_deltaNeutralDesignatedLocation).append(", ");
		builder.append("m_basisPoints=").append(m_basisPoints).append(", m_basisPointsType=").append(m_basisPointsType)
				.append(", m_scaleInitLevelSize=").append(m_scaleInitLevelSize).append(", m_scaleSubsLevelSize=").append(m_scaleSubsLevelSize)
				.append(", m_scalePriceIncrement=").append(m_scalePriceIncrement).append(", m_scalePriceAdjustValue=")
				.append(m_scalePriceAdjustValue).append(", m_scalePriceAdjustInterval=").append(m_scalePriceAdjustInterval)
				.append(", m_scaleProfitOffset=").append(m_scaleProfitOffset).append(", m_scaleAutoReset=").append(m_scaleAutoReset)
				.append(", m_scaleInitPosition=").append(m_scaleInitPosition).append(", m_scaleInitFillQty=").append(m_scaleInitFillQty)
				.append(", m_scaleRandomPercent=").append(m_scaleRandomPercent).append(", ");
		if (m_scaleTable != null)
			builder.append("m_scaleTable=").append(m_scaleTable).append(", ");
		if (m_hedgeType != null)
			builder.append("m_hedgeType=").append(m_hedgeType).append(", ");
		if (m_hedgeParam != null)
			builder.append("m_hedgeParam=").append(m_hedgeParam).append(", ");
		if (m_account != null)
			builder.append("m_account=").append(m_account).append(", ");
		if (m_settlingFirm != null)
			builder.append("m_settlingFirm=").append(m_settlingFirm).append(", ");
		if (m_clearingAccount != null)
			builder.append("m_clearingAccount=").append(m_clearingAccount).append(", ");
		if (m_clearingIntent != null)
			builder.append("m_clearingIntent=").append(m_clearingIntent).append(", ");
		if (m_algoStrategy != null)
			builder.append("m_algoStrategy=").append(m_algoStrategy).append(", ");
		if (m_algoParams != null)
			builder.append("m_algoParams=").append(m_algoParams).append(", ");
		builder.append("m_whatIf=").append(m_whatIf).append(", m_notHeld=").append(m_notHeld).append(", ");
		if (m_smartComboRoutingParams != null)
			builder.append("m_smartComboRoutingParams=").append(m_smartComboRoutingParams).append(", ");
		if (m_orderComboLegs != null)
			builder.append("m_orderComboLegs=").append(m_orderComboLegs).append(", ");
		if (m_orderMiscOptions != null)
			builder.append("m_orderMiscOptions=").append(m_orderMiscOptions);
		builder.append("]");
		return builder.toString();
	}

}
