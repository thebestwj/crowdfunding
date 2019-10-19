package com.wj.funding.admin.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by white_wolf on 2019/10/19.
 *
 * @author thebestwj
 */

@ControllerAdvice(basePackages = "com.wj.funding.admin.web")
public class ExceptionResolver {

    @ExceptionHandler(Exception.class)
    public ModelAndView resolveException(Exception e){
        ModelAndView mav=new ModelAndView();
        mav.addObject("EXCEPTION",e.getMessage());
        mav.setViewName("system-error");
        return mav;
    }

}
