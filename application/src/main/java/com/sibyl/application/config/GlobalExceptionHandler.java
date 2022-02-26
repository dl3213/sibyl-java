package com.sibyl.application.config;

import com.sibyl.application.base.CommonEnum;
import com.sibyl.application.base.R;
import com.sibyl.application.base.SibylException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname GlobalExceptionHandler
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/25 18:36
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = SibylException.class)
    @ResponseBody
    public R sibylExceptionHandler(HttpServletRequest req, SibylException e){
        logger.error("发生业务异常！原因是：{}",e.getMessage());
        return R.error(e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public R exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return R.error(CommonEnum.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public R exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return R.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}
