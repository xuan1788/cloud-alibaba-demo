package com.yx.boot.web;

import com.yx.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/10/4 15:39
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    // 创建线程安全的map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    // 处理GET请求，用来获取用户列表
    // 可以通过@RequestParam获取从页面中传递出来的查询条件或者翻页信息等参数
    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    // 处理POST请求，用来创建User
    // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/", method=RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        users.put(user.getId(), user);
        System.out.println("user=="+users.get(user.getId()));
        return "success";
    }

    // 处理GET请求， 用来获取url中的id值的User信息；
    // url 中的id 可通过@PathVariable绑定到函数的参数中。
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    // 处理PUT请求，用来更新User信息。
    @ApiOperation(value = "更新用户详细信息",notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    // 处理DELETE请求，用来删除User
    @ApiOperation(value = "删除用户",notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
