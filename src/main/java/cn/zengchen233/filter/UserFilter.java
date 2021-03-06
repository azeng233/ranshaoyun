package cn.zengchen233.filter;

import cn.zengchen233.pojo.User;
import cn.zengchen233.utils.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserFilter", urlPatterns = "/user/*")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);

        if (user == null) {
            //已经被移除，注销，未登录
            resp.sendRedirect( req.getContextPath() + "/without permission.html");
            return;
        }

        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
