package com.walmart.ts.mock;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.jboss.netty.util.internal.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

import com.walmart.ts.enums.SeatStatusType;
import com.walmart.ts.model.Seat;
import com.walmart.ts.model.SeatHold;
import com.walmart.ts.model.VenueLevel;

@Repository
public final class MockData {
	
	public static VenueLevel[] levels = new VenueLevel[] {
			new VenueLevel(1, "Orchestra", 100.00, 25, 50),
			new VenueLevel(2, "Main", 75.00, 20, 100),
			new VenueLevel(3, "Balcony 1", 50.00, 15, 100),
			new VenueLevel(4, "Balcony 2", 25.00, 15, 100),
	};
	
	public static Map<VenueLevel, List<Seat>> seatsMap = new ConcurrentHashMap<VenueLevel, List<Seat>>();
	
	public static Map<Integer, SeatHold> holdsMap = new ConcurrentHashMap<Integer, SeatHold>();

	public static Map<String, SeatHold> reservedMap = new ConcurrentHashMap<String, SeatHold>();

	static {
		Seat seat = null;
		List<Seat> seatList = null;
		for (VenueLevel level : levels) {
			for (int i = 1; i <= level.getTotalRows(); i++) {
				for (int j = 1; j <= level.getTotalSeatsInRow(); j++) {
					seat = new Seat(level.getLevelId() + "-" + i + "-" + j,
							SeatStatusType.AVAILABLE, level);

					if (seatsMap.containsKey(seat.getVenueLevel())) {
						seatList = seatsMap.get(seat.getVenueLevel());
					} else {
						seatList = new CopyOnWriteArrayList<Seat>();
						seatsMap.put(level, seatList);
					}
					seatList.add(seat);
				}
			}
		}
	}

}
