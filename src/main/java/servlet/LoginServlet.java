package servlet;

import com.google.gson.Gson;
import entity.LoginEntity;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService service = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("u");
        Gson gson = new Gson();
        PrintWriter print = resp.getWriter();
        resp.setContentType("application/json; charset=UTF-8");
        String json="";
        if (u != null){
           LoginEntity loginEntity = service.findByUname(u);
            json = gson.toJson(loginEntity);
        }else{
            List<LoginEntity>loginEntities = service.find();
            json = gson.toJson(loginEntities);
        }
        print.print(json);
        print.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine())!= null){
            stringBuffer.append(line);
        }
        String json = stringBuffer.toString();
        Gson gson = new Gson();
        LoginEntity loginEntity = gson.fromJson(json, LoginEntity.class);
        System.out.println(json);
        LoginEntity newLoginEntity = service.insert(loginEntity);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json; charset=UTF-8");
        json = gson.toJson(newLoginEntity);
        writer.print(json);
        writer.flush();
    }
}
