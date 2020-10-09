package com.example.corso.flow.rest.controller;

import com.example.corso.flow.entity.TeamMember;
import com.example.corso.flow.rest.resources.TeamMemberResource;
import com.example.corso.flow.rest.viewmodel.PatchTeamMemberDto;
import com.example.corso.flow.service.TeamMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.example.corso.flow.rest.resources.TeamMemberListResource;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team-members")
public class TeamMembersController {
	// possiamo dichiarare la dipendenza
	@Autowired
	private TeamMemberService teamMemberService;

	@GetMapping
	public ResponseEntity<TeamMemberListResource> getResources() {
		// obiettivo di questo metodo è quello di invocare findTeamMemberAll dal Service
		List<TeamMember> list = teamMemberService.findTeamMemberAll();
		// devo creare una List<TeamMemberResouce> partendo dalla List<TeamMember>
		List<TeamMemberResource> teamMembers = new ArrayList<>();
		for (TeamMember source : list) {
			TeamMemberResource target = new TeamMemberResource();
			// NOTA BENE: per aiutare in questa operazione Spring ci mette a disposizione
			// un metodo che si chiama copyProperties
			// source sarà il nostro oggetto TeamMember e target sarà il nostro oggetto
			// TeamMemberResource
			// Il metodo copyProperties cerca tutti i getter di source e tutti i setter di target
			// Se un getter di source fa match con un setter di target (per nome e tipo)
			// allora invoca il getter in source e, con il valore che ottiene, invoca
			// il setter in target
			BeanUtils.copyProperties(source, target);
			//
			teamMembers.add(target);
		}
		// a questo punto creo l'oggetto TeamMemberListResource e invoco il setter
		TeamMemberListResource teamMemberListResource = new TeamMemberListResource();
		teamMemberListResource.setTeamMembers(teamMembers);
		// restituisco la nuova variabile
		return ResponseEntity.ok(teamMemberListResource);
	}

	// GET /team-members/29
	@GetMapping("/{teamMemberId}")
	public ResponseEntity<TeamMemberResource> getSingleResource(@PathVariable("teamMemberId") long teamMemberId) {
		// NON si fa così, ma ci manca il metodo findByTeamMemberId nel service
		// possiamo ciclare sulla list restituita da findTeamMemberAll e trovare il TeamMember con getTeamMemberPk()
		// uguale al parametro che ci è stato passato
		List<TeamMember> list = teamMemberService.findTeamMemberAll();
		for (TeamMember source : list) {
			if (source.getTeamMemberPk() == teamMemberId) {
				// dalla list otteniamo un source: TeamMember (scritto come lo scrive IntelliJ)
				// dobbiamo restituire un ResponseEntity<TeamMemberResource> per cui procediamo come sopra:
				TeamMemberResource target = new TeamMemberResource();
				BeanUtils.copyProperties(source, target);
				// mutatis mutandis (cambiando ciò che c'è da cambiare)
				return ResponseEntity.ok(target);
			}
		}
		// manca ancora qualcosa e anche IntelliJ se ne accorge
		// Dalle specifiche REST, se la risorsa non è trovata la risposta è 404 Not Found
		// Il metodo è notFound() con la differenza che devo invocare anche il metodo build() per avere un ResponseEntity.
		return ResponseEntity.notFound().build();
	}

	@PatchMapping("/{teamMemberId}")
	public ResponseEntity<?> patchTeamMember(@PathVariable("teamMemberId") long teamMemberId, @RequestBody PatchTeamMemberDto patchTeamMemberDto) {
		// prima posso fare il controllo formale: se in patchTeamMemberDto non mi viene passato il valore di phoneNumber
		// posso già rispondere con status 400 Bad Request
		if (!StringUtils.hasText(patchTeamMemberDto.getPhoneNumber())) {
			return ResponseEntity.badRequest().build();
		}
		// posso invocare il metodo updatePhoneNumberByTeamMemberPk e so che mi viene restituito null se non esiste
		// la risorsa identificata da teamMemberId
		// Se mi viene restituito not null so che invece è stata eseguita l'operazione e quindi posso restituire
		// 204 No Content (perché è giò stata eseguita, altrimenti sarebbe 202 Accepted).
		TeamMember test = teamMemberService.updatePhoneNumberByTeamMemberPk(teamMemberId, patchTeamMemberDto.getPhoneNumber());
		if (test != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
