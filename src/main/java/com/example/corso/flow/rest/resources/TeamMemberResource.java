package com.example.corso.flow.rest.resources;

public class TeamMemberResource {
	private long teamMemberPk;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;

	public long getTeamMemberPk() {
		return teamMemberPk;
	}

	public void setTeamMemberPk(long teamMemberPk) {
		this.teamMemberPk = teamMemberPk;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String role;

}
