package com.heta.repo;

import com.heta.entity.Contact;
import com.heta.entity.User;

import java.util.List;

public interface ContactRepository {

    /**
     * 根据联系人 ID 获取联系人信息
     * @param id 联系人 ID
     * @return 若存在则返回对应的 Contact 对象，不存在则返回 null
     */
    List<Contact> getContactsById(int id);

    /**
     * 根据参与聊天的两个用户获取联系人信息
     * @param chatter1 第一个用户
     * @param chatter2 第二个用户
     * @return 若存在则返回对应的 Contact 对象，不存在则返回 null
     */
    Contact getContactByChatters(User chatter1, User chatter2);

    /**
     * 保存联系人信息
     *
     * @param contact 要保存的 Contact 对象
     * @return 保存成功后返回该 Contact 对象
     */
    int saveContact(Contact contact);
    /**
     * 获取所有联系人信息
     * @return 包含所有 Contact 对象的列表
     */
    List<Contact> getAllContacts();
}