package com.hongjun.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongjun500
 * @date 2021/1/12 22:41
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping(value = {"","/"})
    public String hello() {
        return "hello Thread";
    }
}
