package com.sibyl.ca.handler;

import com.alibaba.fastjson.JSON;
import com.sibyl.base.domain.CommonEnum;
import com.sibyl.base.domain.R;
import com.sibyl.ca.util.WebUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname AuthenticationEntryPointImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/26 16:04
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        R error = R.error(CommonEnum.SIGNATURE_NOT_MATCH);
        WebUtil.renderString(response, JSON.toJSONString(error));
    }
}
