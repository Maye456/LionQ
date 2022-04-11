package com.gcu.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcu.model.Message;

@Repository("messageRepository")
public interface MessageRepository extends JpaRepository<Message, Long> {
	/**
	 * Get Message By ID
	 * @param message_id
	 * @return a message by its id
	 */
    Message findById(int message_id);
}
