package net.fangcun.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        /*int id;
        try{
            id = Integer.parseInt(request.getParameter(""));
        }catch (Exception e){
            response.sendError(400,e.getMessage());
        }

        if(id == null || id ){

        }*/
    }
}
