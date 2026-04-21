package com.arthive.backend.service;

import com.arthive.backend.model.TeamMember;
import com.arthive.backend.repository.TeamMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberService(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }
}