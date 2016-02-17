package com.walmart.ts.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.walmart.ts.service.HoldsProcessorService;

@Component
public class ReleaseHoldOrdersTask {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReleaseHoldOrdersTask.class);

	private static final String CLASS_NAME = ReleaseHoldOrdersTask.class
			.getName();

	private HoldsProcessorService seatHoldProcessor;

	@Autowired
	public void setSeatHoldProcessor(HoldsProcessorService seatHoldProcessor) {
		this.seatHoldProcessor = seatHoldProcessor;
	}

	@Scheduled(fixedDelay = 60 * 1000)
	public void run() {
		LOGGER.debug("Releasing the Hold Tickets...");
		seatHoldProcessor.processSeatHolds();
	}
}
