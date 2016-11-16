package com.mycompany;

import com.kpfu.model.users.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vlad.M on 16.11.2016.
 */

public class TestServlet extends HttpServlet{
    @Inject
    UserRepositoryEJB userRepositoryEJB;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("testUser", "testUser@gmail.com","qwerty");
        //userRepositoryEJB.add();
        System.out.println("Hello world!");
        resp.getOutputStream().print("HELLO WORLD");
        userRepositoryEJB.add(user);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
