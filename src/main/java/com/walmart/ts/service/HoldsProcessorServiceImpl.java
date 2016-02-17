package com.walmart.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.ts.dao.ReservationDao;

@Service
public class HoldsProcessorServiceImpl implements HoldsProcessorService {

	private ReservationDao ticketingServiceDao;

	@Autowired
	public void setTicketingServiceDao(ReservationDao ticketingServiceDao) {
		this.ticketingServiceDao = ticketingServiceDao;
	}

	@Override
	public void processSeatHolds() {
		ticketingServiceDao.releaseHoldOrders();
	}

}
