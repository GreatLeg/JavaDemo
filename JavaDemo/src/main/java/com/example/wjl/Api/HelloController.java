package com.example.wjl.Api;
import java.util.Map;
import java.util.List;


import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;


@RestController
@Controller
public class HelloController {
    public  Map<String,Object> result1;
    public static final String KEY_MAC = "HmacMD5";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/hello")
    @ResponseBody
    public List<Map<String, Object>> getDbType() {
        HashMap result = new HashMap();
        String sql = "select * from Student";
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        List list = jdbcTemplate.queryForList(sql);
//        for (Map<String, Object> map : list) {
//            Set<Entry<String, Object>> entries = map.entrySet();
//            if (entries != null) {
//                Iterator<Entry<String, Object>> iterator = entries.iterator();
//                while (iterator.hasNext()) {
//                    Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
//                    Object key = entry.getKey();
//                    Object value = entry.getValue();
//                    System.out.println(key + ":" + value);
//                }
//            }
//        }
        return list;
    }
    //
    @RequestMapping("/getMap")
//    @ResponseBody
    public Map<String, Object> getDb(@RequestParam("phone") String phone , @RequestParam("code") String code) {
        System.out.print("ddddddddddddded");

        Map result = new HashMap<>();
//        String tel = reqMap.get("phone").toString();
//        String pwd = reqMap.get("code").toString();
////        System.out.print("ddddddddd"+tel+pwd);


//        if(reqMap.get("phone").toString().isEmpty()){
//            result.put("success","失败");
//            result.put("code","0");
//            return result;
//        }

        String sql = "select * from user u,company c where u.cid=c.cid and phone="+phone;
        List list = jdbcTemplate.queryForList(sql);
        if (list.isEmpty()){
          result.put("Successed","0");
          result.put("Phone","该账号不存在！");
        }else{
            result.put("success","成功");
            result.put("data",list.get(0));
        }

//        for (Map<String, Object> map : list) {
//            Set<Entry<String, Object>> entries = map.entrySet();
//            if (entries != null) {i
//                Iterator<Entry<String, Object>> terator = entries.iterator();
//                while (iterator.hasNext()) {
//                    Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
//                    Object key = entry.getKey();
//                    Object value = entry.getValue();
//                    System.out.println(key + ":" + value);
//                }
//            }
//        }
        return result;
   }
 public void checkUserIsLive(String name,String token){

 }
}
