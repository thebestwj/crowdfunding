package com.wj.funding.admin.web.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wj.funding.admin.result.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.wj.funding.admin.utils.UtilTools.stringEffective;

/**
 * Created by white_wolf on 2019/10/19.
 *
 * @author thebestwj
 */

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(Exception.class)
    public ModelAndView resolveException(Exception e, HttpServletRequest request, HttpServletResponse response){

        if (checkAsyncRequest(request)){
            ResultEntity<String> resultEntity = ResultEntity.failed(ResultEntity.NO_DATA, e.getMessage());

            ObjectMapper mapper = new ObjectMapper();
            //Json映射为对象
            String json = null;
            try {
                json = mapper.writeValueAsString(resultEntity);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }

            // 5.将json作为响应数据返回给浏览器
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.getWriter().write(json);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return null;

        }else{
            ModelAndView mav=new ModelAndView();
            mav.addObject("EXCEPTION",e.getMessage());
            mav.setViewName("system-error");
            return mav;
        }

    }

    public static boolean checkAsyncRequest(HttpServletRequest request) {

        // 1.获取相应请求消息头
        String accept = request.getHeader("Accept");
        String xRequested = request.getHeader("X-Requested-With");

        // 2.判断请求消息头数据中是否包含目标特征
        if(
                (stringEffective(accept) && accept.contains("application/json"))
                        ||
                        (stringEffective(xRequested) && xRequested.contains("XMLHttpRequest")) ) {
            return true;
        }

        return false;
    }


}
