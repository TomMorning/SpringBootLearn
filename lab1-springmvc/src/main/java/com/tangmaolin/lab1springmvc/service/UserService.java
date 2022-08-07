package com.tangmaolin.lab1springmvc.service;

import com.tangmaolin.lab1springmvc.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserVO get(Integer id) {
        return new UserVO().setId(id).setUsername("test");
    }
}
