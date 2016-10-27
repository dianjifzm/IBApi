package com.homaer.stock.client;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.UnderComp;

public class HmWrapper implements EWrapper {
	private final static Logger log = LoggerFactory.getLogger(HmWrapper.class);

	@Override
	public void error(Exception e) {
		log.error("error", e);
	}

	@Override
	public void error(String str) {
		log.error(str);
	}

	@Override
	public void error(int id, int errorCode, String errorMsg) {
		log.error("error id:{},errorCode:{},errorMsg:{}", id, errorCode, errorMsg);
	}

	@Override
	public void connectionClosed() {
		log.info("connectionClosed");
	}

	@Override
	public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
		log.info("tickPrice tickerId:{},field:{},price:{},canAutoExecute:{}", tickerId, field, price, canAutoExecute);
	}

	@Override
	public void tickSize(int tickerId, int field, int size) {
		log.info("tickSize tickerId:{},field:{},size:{}", tickerId, field, size);
	}

	@Override
	public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice, double pvDividend, double gamma,
			double vega, double theta, double undPrice) {
		log.info(
				"tickOptionComputation. tickerId:{},field:{},impliedVol:{},delta:{},optPrice:{},pvDividend:{},gamma:{},vega:{},theta:{},undPrice:{}",
				tickerId, field, impliedVol, delta, optPrice, pvDividend, gamma, vega, theta, undPrice);
	}

	@Override
	public void tickGeneric(int tickerId, int tickType, double value) {
		log.info("tickGeneric. tickerId:{},tickType:{},value:{}", tickerId, tickType, value);
	}

	@Override
	public void tickString(int tickerId, int tickType, String value) {
		log.info("tickString. tickerId:{},tickType:{},value:{}", tickerId, tickType, value);
	}

	@Override
	public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays,
			String futureExpiry, double dividendImpact, double dividendsToExpiry) {
		log.info("tickEFP. tickerId:{},tickType:{},basisPoints:{},formattedBasisPoints:{}", tickerId, tickType, basisPoints);
	}

	@Override
	public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId, int parentId,
			double lastFillPrice, int clientId, String whyHeld) {
		log.info(
				"orderStatus. orderId:{}, status:{}, filled:{}, remaining:{}, avgFillPrice:{}, permId:{}, parentId:{}, lastFillPrice:{}, clientId:{}, whyHeld:{}",
				orderId, status, filled, remaining, avgFillPrice, permId, parentId, lastFillPrice, clientId, whyHeld);
	}

	@Override
	public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
		log.info("openOrder. orderId:{}, contract:{}, order:{}, orderState:{}", orderId, contract, order, orderState);
	}

	@Override
	public void openOrderEnd() {
		log.info("openOrderEnd.");
	}

	@Override
	public void updateAccountValue(String key, String value, String currency, String accountName) {
		log.info("updateAccountValue. key:{}, value:{}, currency:{}, accountName:{}", key, value, currency, accountName);
	}

	@Override
	public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL,
			double realizedPNL, String accountName) {
		log.info(
				"updatePortfolio. contract:{}, position:{}, marketPrice:{}, marketValue:{}, averageCost:{}, unrealizedPNL:{}, realizedPNL:{}, accountName:{}",
				contract, position, marketPrice, marketValue, averageCost, unrealizedPNL, realizedPNL, accountName);
	}

	@Override
	public void updateAccountTime(String timeStamp) {
		log.info("updateAccountTime. timeStamp:{}", timeStamp);
	}

	@Override
	public void accountDownloadEnd(String accountName) {
		log.info("accountDownloadEnd. accountName:{}", accountName);
	}

	@Override
	public void nextValidId(int orderId) {
		log.info("nextValidId. orderId:{}", orderId);
	}

	@Override
	public void contractDetails(int reqId, ContractDetails contractDetails) {
		log.info("contractDetails. reqId:{}, contractDetails:{}", reqId, contractDetails);
	}

	@Override
	public void bondContractDetails(int reqId, ContractDetails contractDetails) {
		log.info("bondContractDetails. reqId:{}, contractDetails:{}", reqId, contractDetails);
	}

	@Override
	public void contractDetailsEnd(int reqId) {
		log.info("contractDetailsEnd. reqId:{}", reqId);
	}

	@Override
	public void execDetails(int reqId, Contract contract, Execution execution) {
		log.info("execDetails. reqId:{}, contract:{}, execution:{}", reqId, contract, execution);
	}

	@Override
	public void execDetailsEnd(int reqId) {
		log.info("execDetailsEnd. reqId:{}", reqId);
	}

	@Override
	public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {
		log.info("updateMktDepth. tickerId:{}, position:{}, operation:{}, side:{}, price:{}, size:{}", tickerId, position, operation, side, price,
				size);
	}

	@Override
	public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price, int size) {
		log.info("updateMktDepthL2. tickerId:{}, position:{}, marketMaker:{}, operation:{}, side:{}, price:{}, size:{}", tickerId, position,
				marketMaker, operation, side, price, size);
	}

	@Override
	public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
		log.info("updateNewsBulletin. msgId:{}, msgType:{}, message:{}, origExchange:{}", msgId, msgType, message, origExchange);
	}

	@Override
	public void managedAccounts(String accountsList) {
		log.info("managedAccounts. accountsList:{}", accountsList);
	}

	@Override
	public void receiveFA(int faDataType, String xml) {
		log.info("receiveFA. faDataType:{}, xml:{}", faDataType, xml);
	}

	@Override
	public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double WAP,
			boolean hasGaps) {
		log.info("historicalData. reqId:{}, date:{}, open:{}, high:{}, low:{}, close:{}, volume:{}, count:{}, WAP:{}, hasGaps:{}", reqId, date, open,
				high, low, close, volume, count, WAP, hasGaps);
	}

	@Override
	public void scannerParameters(String xml) {
		log.info("scannerParameters. xml:{}", xml);
	}

	@Override
	public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark, String projection, String legsStr) {
		log.info("scannerData. reqId:{}, rank:{}, contractDetails:{}, distance:{}, benchmark:{}, projection:{}, legsStr:{}", reqId, rank,
				contractDetails, distance, benchmark, projection, legsStr);
	}

	@Override
	public void scannerDataEnd(int reqId) {
		log.info("scannerDataEnd. reqId:{}", reqId);
	}

	@Override
	public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count) {
		log.info("realtimeBar. reqId:{}, time:{}, open:{}, high:{}, low:{}, close:{}, volume:{}, wap:{}, count:{}", reqId, time, open, high, low,
				close, volume, wap, count);
	}

	@Override
	public void currentTime(long time) {
		log.info("currentTime. time:{} [{}]", time, new Date(time * 1000));
	}

	@Override
	public void fundamentalData(int reqId, String data) {
		log.info("fundamentalData. reqId:{}, data:{}", reqId, data);
	}

	@Override
	public void deltaNeutralValidation(int reqId, UnderComp underComp) {
		log.info("deltaNeutralValidation. reqId:{}, underComp:{}", reqId, underComp);
	}

	@Override
	public void tickSnapshotEnd(int reqId) {
		log.info("tickSnapshotEnd. reqId:{}", reqId);
	}

	@Override
	public void marketDataType(int reqId, int marketDataType) {
		log.info("marketDataType. reqId:{}, marketDataType:{}", reqId, marketDataType);
	}

	@Override
	public void commissionReport(CommissionReport commissionReport) {
		log.info("commissionReport. commissionReport:{}", commissionReport);
	}

	@Override
	public void position(String account, Contract contract, int pos, double avgCost) {
		log.info("position. account:{}, contract:{}, pos:{}, avgCost:{}", account, contract, pos, avgCost);
	}

	@Override
	public void positionEnd() {
		log.info("positionEnd.");
	}

	@Override
	public void accountSummary(int reqId, String account, String tag, String value, String currency) {
		log.info("accountSummary. reqId:{}, account:{}, tag:{}, value:{}, currency:{}", reqId, account, tag, value, currency);
	}

	@Override
	public void accountSummaryEnd(int reqId) {
		log.info("accountSummaryEnd. reqId:{}", reqId);
	}

	@Override
	public void verifyMessageAPI(String apiData) {
		log.info("verifyMessageAPI. apiData:{}", apiData);
	}

	@Override
	public void verifyCompleted(boolean isSuccessful, String errorText) {
		log.info("verifyCompleted. isSuccessful:{}, errorText:{}", isSuccessful, errorText);
	}

	@Override
	public void displayGroupList(int reqId, String groups) {
		log.info("displayGroupList. reqId:{}, groups:{}", reqId, groups);
	}

	@Override
	public void displayGroupUpdated(int reqId, String contractInfo) {
		log.info("displayGroupUpdated. reqId:{}, contractInfo:{}", reqId, contractInfo);
	}

}
