package com.hn.sanya.xintou.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

        /**
         　　* @Description: 通用异常处理
         　  * @author syiti
         * @Method
        　　* @params
        　　* @return
        　　* @date 2018/3/16 11:06
        　　*/
        @Controller
        public class DefaultErrorController implements ErrorController {

            private static final String ERROR_PATH = "/error";


            @RequestMapping(value=ERROR_PATH)
            public String handleError(HttpServletResponse response){
                if(HttpStatus.NOT_FOUND.value()==response.getStatus()){
                    return "error/404";
                }
                if(HttpStatus.INTERNAL_SERVER_ERROR.value()==response.getStatus()){
                    return "error/500";
                }
                return null;
            }

            @Override
            public String getErrorPath() {
                // TODO Auto-generated method stub
                return ERROR_PATH;
            }

}