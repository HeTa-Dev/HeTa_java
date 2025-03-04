package com.heta.service;

import com.heta.entity.Contact;
import com.heta.entity.User;
import com.heta.repo.ContactRepository;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;


    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

//    public Contact getOrCreateContact(User chatter1, User chatter2) {
//        // 尝试获取现有的 Contact
//        Contact existingContact = contactRepository.getContactByChatters(chatter1, chatter2);
//        if (existingContact.isPresent()) {
//            return existingContact.get();
//        }
//
//        // 如果不存在，则创建新的 Contact
//        Contact newContact = new Contact(chatter1, chatter2);
//        return contactRepository.saveContact(newContact);
//    }

    /**
     * 根据联系人 ID 获取联系人信息
     *
     * @param id 联系人 ID
     * @return 若存在则返回对应的 Contact 对象，不存在则返回 null
     */
    public List<Contact> getContactsById(int id) {
        return contactRepository.getContactsById(id);
    }

    /**
     * 根据参与聊天的两个用户获取联系人信息
     *
     * @param chatter1 第一个用户
     * @param chatter2 第二个用户
     * @return 若存在则返回对应的 Contact 对象，不存在则返回 null
     */
    public Contact getContactByChatters(User chatter1, User chatter2) {
        return contactRepository.getContactByChatters(chatter1, chatter2);
    }

    /**
     * 保存联系人信息
     * @param contact 要保存的 Contact 对象
     * @return 保存成功后返回该 Contact 对象
     */


    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    /**
     * 获取所有联系人信息
     * @return 包含所有 Contact 对象的列表
     */
    public List<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }
}