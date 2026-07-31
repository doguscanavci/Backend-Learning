package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final EntityManager entityManager;

    @Autowired
    public CardRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Card save(Card card) {
        entityManager.persist(card);
        return card;
    }

    @Override
    public List<Card> findByColor(String color) {
        TypedQuery<Card> query = entityManager.createQuery(
                "SELECT c FROM Card c WHERE c.color = :color", Card.class);
        try {
            query.setParameter("color", Color.valueOf(color.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new CardException("Card not found", HttpStatus.NOT_FOUND);
        }

        List<Card> cards = query.getResultList();
        if (cards.isEmpty()) {
            throw new CardException("Card not found", HttpStatus.NOT_FOUND);
        }
        return cards;
    }

    @Override
    public List<Card> findAll() {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c", Card.class);
        return query.getResultList();
    }

    @Override
    public List<Card> findByValue(Integer value) {
        TypedQuery<Card> query = entityManager.createQuery(
                "SELECT c FROM Card c WHERE c.value = :value", Card.class);
        query.setParameter("value", value);
        return query.getResultList();
    }

    @Override
    public List<Card> findByType(String type) {
        TypedQuery<Card> query = entityManager.createQuery(
                "SELECT c FROM Card c WHERE c.type = :type", Card.class);
        try {
            query.setParameter("type", Type.valueOf(type.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new CardException("Card not found", HttpStatus.NOT_FOUND);
        }
        return query.getResultList();
    }

    @Override
    @Transactional
    public Card update(Card card) {
        return entityManager.merge(card);
    }

    @Override
    @Transactional
    public Card remove(Long id) {
        Card card = entityManager.find(Card.class, id);
        if (card == null) {
            throw new CardException("Card not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        entityManager.remove(card);
        return card;
    }
}