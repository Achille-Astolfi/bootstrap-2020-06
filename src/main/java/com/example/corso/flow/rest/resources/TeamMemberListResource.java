package com.example.corso.flow.rest.resources;

import java.util.List;

public class TeamMemberListResource {
	private List<TeamMemberResource> teamMembers;

	public List<TeamMemberResource> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<TeamMemberResource> teamMembers) {
		this.teamMembers = teamMembers;
	}

}
