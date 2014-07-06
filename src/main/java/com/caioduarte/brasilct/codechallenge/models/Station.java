package com.caioduarte.brasilct.codechallenge.models;

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

	private String latitude;

	private String longitude;

	private String name;

	private String displayName;

	private Integer zone;

	private Integer totalLines;

	private Integer rail;

	private Station(Integer id, String latitude, String longitude, String name,
			String displayName, Integer zone, Integer totalLines, Integer rail) {
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

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Integer getZone() {
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

			public MustHaveZone coordinates(String latitude, String longitude) {
				return new MustHaveZone(id, name, latitude, longitude);
			}
		}

		public static class MustHaveZone {
			private final Integer id;
			private final String name;
			private final String latitude;
			private final String longitude;

			public MustHaveZone(Integer id, String name, String latitude,
					String longitude) {
				this.id = id;
				this.name = name;
				this.latitude = latitude;
				this.longitude = longitude;
			}

			public MustHaveTotalLines zone(Integer zone) {
				return new MustHaveTotalLines(id, name, latitude, longitude,
						zone);
			}
		}

		public static class MustHaveTotalLines {
			private final Integer id;
			private final String name;
			private final String latitude;
			private final String longitude;
			private final Integer zone;

			public MustHaveTotalLines(Integer id, String name, String latitude,
					String longitude, Integer zone) {
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
			private final String latitude;
			private final String longitude;
			private final Integer zone;
			private final Integer totalLines;

			public MustHaveRail(Integer id, String name, String latitude,
					String longitude, Integer zone, Integer totalLines) {
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

		static class StationBuilder {
			private Integer id;
			private String latitude;
			private String longitude;
			private String name;
			private Integer zone;
			private Integer totalLines;
			private Integer rail;
			private String displayName;

			public StationBuilder(Integer id, String name, String latitude,
					String longitude, Integer zone, Integer totalLines,
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
