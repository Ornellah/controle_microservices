package com.ynov.controle_back.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ynov.controle_back.dao.MessageDAO;
import com.ynov.controle_back.entities.Message;
import com.ynov.controle_back.web.exceptions.MessageIntrouvableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageDAO messageDAO;

    @RequestMapping(value = "/Messages", method = RequestMethod.GET)
    public List<Message> listeMessages() {
        return messageDAO.findAll();
    }

    @GetMapping(value = "/Messages/{id}")
    public Message afficherUnMessage(@PathVariable int id) {
        Message message = messageDAO.findById(id);
        if (message == null)
            throw new MessageIntrouvableException("Le message avec l'id" + id + " est introuvable.");
        return message;
    }

    @GetMapping(value = "/Messages/Recherche/{recherche}")
    public List<Message> afficherMessageTexte(@PathVariable String recherche) {
        return messageDAO.findByTexteLike("%" + recherche + "%");
    }

    @PostMapping(value = "/Messages")
    public Message ajouterMessage(@Valid @RequestBody Message message) {
        return messageDAO.save(message);
    }

    /*@PostMapping(value="/Messages")
    public void ajouterMessage(@RequestBody Message message){
        messageDAO.save(message);
        messageDAO.customeQuery(message);
    }*/
}
