/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import streaming.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import streaming.service.MyService;

/**
 *
 * @author tom
 */
@WebServlet(name = "MyServiceServlet", urlPatterns = {"/MyServiceServlet"}) 
public class MyServiceServlet extends AutowireServlet {

    @Autowired
    private MyService myService;

    @Autowired
    private String tommyLee;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println( myService );
    }
}
