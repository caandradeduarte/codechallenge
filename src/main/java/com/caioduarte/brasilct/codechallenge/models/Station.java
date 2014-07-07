package com.caioduarte.brasilct.codechallenge.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Once created, a station must not be changed, so if you need to create one,
 * use its {@link Builder}
 * 
 * @author Caio Duarte
 *
 */
@Entity
public class Station {

	@Id
	private Integer id;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String name;

	private String displayName;

	private BigDecimal zone;

	private Integer totalLines;

	private Integer rail;
	
	/**
	 * Created only because of hibernate
	 */
	private Station() {
	}

	private Station(Integer id, BigDecimal latitude, BigDecimal longitude, String name,
			String displayName, BigDecimal zone, Integer totalLines, Integer rail) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.displayName = displayName;
		this.zone = zone;
		this.totalLines = totalLines;
		this.rail = rail;
	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public BigDecimal getZone() {
		return zone;
	}

	public Integer getTotalLines() {
		return totalLines;
	}

	public Integer getRail() {
		return rail;
	}

	public static class Builder {

		public MustHaveName id(Integer id) {
			return new MustHaveName(id);
		}

		public static class MustHaveName {
			private final Integer id;

			public MustHaveName(Integer id) {
				this.id = id;
			}

			public MustHaveCoordinates name(String name) {
				return new MustHaveCoordinates(id, name);
			}
		}

		public static class MustHaveCoordinates {
			private final Integer id;
			private final String name;

			public MustHaveCoordinates(Integer id, String name) {
				this.id = id;
				this.name = name;
			}

			public MustHaveZone coordinates(BigDecimal latitude, BigDecimal longitude) {
				return new MustHaveZone(id, name, latitude, longitude);
			}
		}

		public static class MustHaveZone {
			private final Integer id;
			private final String name;
			private final BigDecimal latitude;
			private final BigDecimal longitude;

			public MustHaveZone(Integer id, String name, BigDecimal latitude,
					BigDecimal longitude) {
				this.id = id;
				this.name = name;
				this.latitude = latitude;
				this.longitude = longitude;
			}

			public MustHaveTotalLines zone(BigDecimal zone) {
				return new MustHaveTotalLines(id, name, latitude, longitude,
						zone);
			}
		}

		public static class MustHaveTotalLines {
			private final Integer id;
			private final String name;
			private final BigDecimal latitude;
			private final BigDecimal longitude;
			private final BigDecimal zone;

			public MustHaveTotalLines(Integer id, String name, BigDecimal latitude,
					BigDecimal longitude, BigDecimal zone) {
				this.id = id;
				this.name = name;
				this.latitude = latitude;
				this.longitude = longitude;
				this.zone = zone;
			}

			public MustHaveRail totalLines(Integer totalLines) {
				return new MustHaveRail(id, name, latitude, longitude, zone,
						totalLines);
			}
		}

		public static class MustHaveRail {
			private final Integer id;
			private final String name;
			private final BigDecimal latitude;
			private final BigDecimal longitude;
			private final BigDecimal zone;
			private final Integer totalLines;

			public MustHaveRail(Integer id, String name, BigDecimal latitude,
					BigDecimal longitude, BigDecimal zone, Integer totalLines) {
				this.id = id;
				this.name = name;
				this.latitude = latitude;
				this.longitude = longitude;
				this.zone = zone;
				this.totalLines = totalLines;
			}

			public StationBuilder rail(Integer rail) {
				return new StationBuilder(id, name, latitude, longitude, zone,
						totalLines, rail);
			}
		}

		public static class StationBuilder {
			private Integer id;
			private BigDecimal latitude;
			private BigDecimal longitude;
			private String name;
			private BigDecimal zone;
			private Integer totalLines;
			private Integer rail;
			private String displayName;

			public StationBuilder(Integer id, String name, BigDecimal latitude,
					BigDecimal longitude, BigDecimal zone, Integer totalLines,
					Integer rail) {
				this.id = id;
				this.name = name;
				this.latitude = latitude;
				this.longitude = longitude;
				this.zone = zone;
				this.totalLines = totalLines;
				this.rail = rail;
			}

			public StationBuilder displayName(String displayName) {
				this.displayName = displayName;
				return this;
			}

			public Station build() {
				return new Station(id, latitude, longitude, name, displayName,
						zone, totalLines, rail);
			}
		}

	}

}
