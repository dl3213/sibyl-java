package com.sibyl.reative;

import com.sibyl.reative.utils.Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname AsyncNonBlockingServlet
 * @Description TODO
 * @Date 2021/8/16 20:58
 * @Created by dyingleaf3213
 */
@WebServlet(name = "async-non-blocking",urlPatterns = "/anb",asyncSupported = true)
public class AsyncNonBlockingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        AsyncContext asyncContext = req.startAsync();
        Utils.prinf("start");
        //非阻塞回调
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                ServletResponse suppliedResponse = event.getSuppliedResponse();
                suppliedResponse.getOutputStream().println("new hello,world 1111 ");
                Utils.prinf("异步done");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {

            }

            @Override
            public void onError(AsyncEvent event) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {

            }
        });

        ServletOutputStream outputStream = resp.getOutputStream();
        //非阻塞IO
        outputStream.setWriteListener(new WriteListener() {
            @Override
            public void onWritePossible() throws IOException {
                outputStream.println("new hello,world 222");
                Utils.prinf("异步+非阻塞done");
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

        Utils.prinf(" will done");
//        asyncContext.complete();

        asyncContext.start(()->{
            Utils.prinf("done 2");
            asyncContext.complete();
        });
    }
}
