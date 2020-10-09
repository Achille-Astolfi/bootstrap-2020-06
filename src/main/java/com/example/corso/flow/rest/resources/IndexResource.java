package com.example.corso.flow.rest.resources;

public class IndexResource {
	private String teamMembers = "/team-members";
	private String holidays = "/holidays";

	public String getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(String teamMembers) {
		this.teamMembers = teamMembers;
	}

	public String getHolidays() {
		return holidays;
	}

	public void setHolidays(String holidays) {
		this.holidays = holidays;
	}
}
