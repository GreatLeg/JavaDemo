package com.example.wjl.Admin;

import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {
    @RequestMapping("/index")
    public String backgroud(Model map){
        Map   user = new HashMap();
            user.put("name","王家乐");
            map.addAllAttributes(user);
        return "admin/hAdmin/index";
    }
    @RequestMapping("/toIndex")
    public String sencondVC(){
        return "admin/hAdmin/blog";
    }
}
