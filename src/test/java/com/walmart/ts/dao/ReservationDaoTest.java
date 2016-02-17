package com.walmart.ts.dao;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.walmart.ts.BaseTest;

public class ReservationDaoTest extends BaseTest {

	@Autowired
	private ReservationDao reservationDao;

	@Override
	protected void setupInternal() throws Exception {
		// TODO Auto-generated method stub

	}

	@Test
	public void testGetNumSeatsAvailable() {
		Integer numSeatsAvailable = reservationDao
				.getNumSeatsAvailable(Optional.ofNullable(null));
		Assert.assertTrue(numSeatsAvailable > 0);
	}

}
