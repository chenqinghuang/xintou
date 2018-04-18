package com.hn.sanya.xintou.controller.main;

    /**
　　* @Description: 通用注解模板
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/9 11:26
　　*/
public class Annotatedtemplate {

    /**
　　* @Description: 模板映射配置
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/9 11:29
　　*/
    public static String requestMapping(String template){
        return template+"/**.do";
    }
}
