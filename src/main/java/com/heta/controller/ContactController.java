package com.heta.controller;

import com.heta.entity.Contact;
import com.heta.entity.User;
import com.heta.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/heta/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // 根据 ID 获取联系人信息
    @GetMapping("/getContactsById/{id}")
    public List<Contact> getContactsById(@PathVariable("id") int id) {
        logger.info("Received contact: {}", id);
        return  contactService.getContactsById(id);
    }


    // 根据两个用户获取联系人信息
//    @GetMapping("/byChatters")
//    public ResponseEntity<Contact> getContactByChatters(@RequestParam("chatter1Id") int chatter1Id,
//                                                        @RequestParam("chatter2Id") int chatter2Id) {
//        User chatter1 = new User();
//        chatter1.setId(chatter1Id);
//        User chatter2 = new User();
//        chatter2.setId(chatter2Id);
//        Optional<Contact> contact = contactService.getContactByChatters(chatter1, chatter2);
//        return contact.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    // 保存联系人信息
    @PostMapping("/saveContact")
    public void saveContact(@RequestBody Contact contact) {

        contactService.saveContact(contact);
    }


    // 获取所有联系人信息
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
}