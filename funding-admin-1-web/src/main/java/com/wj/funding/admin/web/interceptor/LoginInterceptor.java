package com.wj.funding.admin.web.interceptor;

import com.wj.funding.admin.model.adminDO;
import com.wj.funding.admin.utils.AdminConst;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by white_wolf on 2019/10/19.
 *
 * @author thebestwj
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        adminDO adminDO = (com.wj.funding.admin.model.adminDO) session.getAttribute(AdminConst.ATT_NAME_LOGIN_ADMIN);
        if (adminDO == null){
            request.setAttribute(AdminConst.ATT_NAME_MESSAGE,AdminConst.MESSAGE_ACCESS_DENIED);
            request.getRequestDispatcher("/admin/to/login").forward(request,response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
