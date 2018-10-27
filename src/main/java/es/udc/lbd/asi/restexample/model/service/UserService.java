package es.udc.lbd.asi.restexample.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.lbd.asi.restexample.model.repository.UserDAO;
import es.udc.lbd.asi.restexample.model.service.dto.UserDTOPublic;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<UserDTOPublic> findAll() {
        return userDAO.findAll().stream().map(user -> new UserDTOPublic(user)).collect(Collectors.toList());
    }
}
