package fr.humanbooster.franck.katchaka.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.franck.katchaka.business.Message;

public interface MessageDao extends JpaRepository<Message, Long> {

}
