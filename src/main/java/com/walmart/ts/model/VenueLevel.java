package com.walmart.ts.model;

import java.io.Serializable;

/**
 * 
 * Model Object for Venue Level.
 */
public class VenueLevel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer levelId;
	private String levelName;
	private Double price;
	private long totalRows;
	private long totalSeatsInRow;

	public VenueLevel() {
		super();
	}

	public VenueLevel(Integer levelId, String levelName, Double price,
			long totalRows, long totalSeatsInRow) {
		super();
		this.levelId = levelId;
		this.levelName = levelName;
		this.price = price;
		this.totalRows = totalRows;
		this.totalSeatsInRow = totalSeatsInRow;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public long getTotalSeatsInRow() {
		return totalSeatsInRow;
	}

	public void setTotalSeatsInRow(long totalSeatsInRow) {
		this.totalSeatsInRow = totalSeatsInRow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((levelId == null) ? 0 : levelId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VenueLevel other = (VenueLevel) obj;
		if (levelId == null) {
			if (other.levelId != null)
				return false;
		} else if (!levelId.equals(other.levelId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VenueLevel [levelId=" + levelId + ", levelName=" + levelName
				+ ", price=" + price + ", totalRows=" + totalRows
				+ ", totalSeatsInRow=" + totalSeatsInRow + "]";
	}

}
