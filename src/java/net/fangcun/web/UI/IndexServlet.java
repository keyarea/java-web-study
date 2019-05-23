package net.fangcun.web.UI;

import net.fangcun.domain.Article;
import sun.rmi.server.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



@WebServlet(name = "IndexServlet", urlPatterns = {"/","/popular", "/recommend"}, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    final static int PAGE_SIZE = 10;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        int articleCount =
        ArrayList<Article> articles = new ArrayList<>();
        switch (url){
            case "":
                articles = newArticle();
                break;
            case "/recommend":
                articles = recommendArticle();
                break;
            case "/popular":
                articles = popularArticle();
                break;
                default:
                    articles = newArticle();

        }

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/index.jsp");
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    ArrayList<Article> newArticle(){

    }

    ArrayList<Article> recommendArticle(){

    }

    ArrayList<Article> popularArticle(){


    }

    int
}
