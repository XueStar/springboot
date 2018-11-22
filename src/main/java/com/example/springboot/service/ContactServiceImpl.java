package com.example.springboot.service;

import com.example.springboot.mapper.ContactMapper;
import com.example.springboot.model.Contact;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Contact record) {
        contactMapper.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(Contact record) {
        return 0;
    }

    @Override
    public Contact selectByPrimaryKey(Integer id) {
        return contactMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Contact record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Contact record) {
        return 0;
    }

    @Override
    public List<Contact> getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return contactMapper.getList();
    }
}
