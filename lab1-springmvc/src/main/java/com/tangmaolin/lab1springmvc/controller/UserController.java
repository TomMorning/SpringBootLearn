package com.tangmaolin.lab1springmvc.controller;

import com.tangmaolin.lab1springmvc.constants.ServiceExceptionEnum;
import com.tangmaolin.lab1springmvc.core.exception.ServiceException;
import com.tangmaolin.lab1springmvc.dto.UserAddDTO;
import com.tangmaolin.lab1springmvc.dto.UserUpdateDTO;
import com.tangmaolin.lab1springmvc.service.UserService;
import com.tangmaolin.lab1springmvc.vo.CommonResult;
import com.tangmaolin.lab1springmvc.vo.UserVO;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;
    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("list")
    public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("tangmaolin"));
        result.add(new UserVO().setId(2).setUsername("shenluhan"));
        result.add(new UserVO().setId(3).setUsername("heyuhong"));
        return result;
    }

    /**
     * 获得指定用户id的用户VO
     *
     * @param id 用户id
     * @return 用户VO
     */
    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

    /**
     * 获得指定用户id的用户VO
     *
     * @param id 用户id
     * @return 用户VO
     */
    @GetMapping("/get/v2/{id}")
    public UserVO get2(@RequestParam("id") Integer id) {
        return userService.get(id);
    }

    @GetMapping("get/v3")
    public CommonResult<UserVO> get3(@RequestParam("id") Integer id) {
        UserVO userVO = userService.get(id);
        return CommonResult.success(userVO);
    }

    /**
     * @param addDTO 添加用户信息 DTO
     * @return 添加成功的用户id
     */
    @PostMapping("add")
    public Integer add(UserAddDTO addDTO) {
        Integer returnId = UUID.randomUUID().hashCode();
        return returnId;
    }

    /**
     * 更新指定用户id的用户
     *
     * @param updateDTO 更新用户信息 DTO
     * @return 是否修改成功
     */
    @PostMapping("update")
    public Boolean update(UserUpdateDTO updateDTO) {
        Boolean success = true;
        return success;
    }

    /**
     * 删除指定用户id的用户
     *
     * @param id 用户id
     * @return 是否删除成功
     */
    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam("id") Integer id) {
        Boolean success = true;
        return success;
    }

    @GetMapping("/exception-01")
    public UserVO exception01() {
        throw new NullPointerException("nullPointerException");
    }

    @GetMapping("/exception-02")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

    @GetMapping("/do_something")
    public void doSomething() {
        logger.info("[doSomething]");
    }

    @GetMapping("/current_user")
    public UserVO currentUser() {
        logger.info("[currentUser]");
        return new UserVO().setId(10).setUsername(UUID.randomUUID().toString());
    }
}
