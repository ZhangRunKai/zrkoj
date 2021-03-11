package com.zrk.util.config;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/11 20:54
 */
public class AuthFilter extends AuthenticatingFilter {
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        return null;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //仅为“option”时返回true
        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
/*
public class OAuth2Filter extends AuthenticatingFilter {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
            //获取请求token
                    String token = getRequestToken((HttpServletRequest) request);
                    if (StringUtils.isBlank(token)) {
                                return null;
                     }
                     return new OAuth2Token(token);
    }
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
          //仅为“option”时返回true
                 if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
                             return true;
                  }
                  return false;
       }
       @Override
       protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
              //获取请求token，如果token不存在，直接返回401
              String token = getRequestToken((HttpServletRequest) request);
              if (StringUtils.isBlank(token)) {
                     HttpServletResponse httpResponse = (HttpServletResponse) response;
                     httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
                     httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
                     String json = JSON.toJSONString(R.error(HttpStatus.SC_UNAUTHORIZED, "invalid token"));
                      httpResponse.getWriter().print(json);
                      return false;
             }

              return executeLogin(request, response);
        }......}

 */