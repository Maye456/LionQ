package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public MessageService(MessageRepository messagerepository) {
        this.messageRepository = messagerepository;
    }

    public Message findById(int message_id) {
        return messageRepository.findById(message_id);
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getLastMessages() {
        return entityManager.createQuery("SELECT p FROM Message p ORDER BY p.id desc", Message.class).setMaxResults(3).getResultList();
    }

    public List<Message> searchForTextinMessages(String text) {
        return entityManager.createQuery("SELECT p FROM Message p WHERE p.content LIKE '" + text + "%'", Message.class).getResultList();
    }

    public List<Message> searchForMessagesbyUserName(String userName) {
        return entityManager.createQuery("SELECT p FROM Message p WHERE p.username = '" + userName +"'", Message.class).setMaxResults(3).getResultList();
    }
}
