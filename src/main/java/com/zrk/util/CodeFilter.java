package com.zrk.util;

import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/14 17:23
 */

@WebFilter(filterName = "CodeFilter", urlPatterns = "/*")
public class CodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,"+JWTUtil.TOKEN_HEADER);
        // 暴露token，这里一定要写，如果你的写法与我的相同，检查此行代码是否也添加了
        response.setHeader("Access-Control-Expose-Headers", JWTUtil.TOKEN_HEADER);
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        if ("OPTIONS".equals(request.getMethod())) {
            // 进行我们定义的请求前，浏览器自动发起的options请求
//            System.out.println("options");
            // 服务器正常接收，返回状态码，不响应其他内容
            response.setStatus(HttpStatus.ACCEPTED.value());
            return;
        } else {
            // 非options请求，放行
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
