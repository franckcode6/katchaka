package fr.humanbooster.franck.katchaka.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.franck.katchaka.business.Invitation;

public interface InvitationDao extends JpaRepository<Invitation, Long> {

}
