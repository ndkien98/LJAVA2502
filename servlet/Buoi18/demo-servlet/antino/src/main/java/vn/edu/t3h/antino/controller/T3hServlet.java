package vn.edu.t3h.antino.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.antino.model.UserModel;
import vn.edu.t3h.antino.service.IUserService;
import vn.edu.t3h.antino.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/t3h-helloworld")
/*
- giúp chỉ định rằng khi truy cập vào url
      domain:port/url_webservlet
      domain: localhost
      port: 8080
      url_webservlet: /t3h-helloworld
      => class T3hServlet sẽ được mapping với url: localhost:8080/t3h-helloworld

 */
public class T3hServlet extends HttpServlet { // tạo ra 1 class servlet, tiếp nhận các request, response

    /*
    chạy khi khởi tạo 1 serverlet
    khi tạo ra 1 object server

    - constructor:
        + được su dụng để khởi tạo object trong java và lưu object trong heap
    - init trong servlet:
        + chỉ là 1 method thông thường sẽ được gọi đầu tiên sau khơi tạo được object bằng construcor
        + chỉ được su dụng để khợi tạo các đối tượng biến globe trong servlet
     */
    private IUserService iUserService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        iUserService = new UserServiceImpl();
    }

    /*
     khi kết thúc vòng đời của servlet
     */
    @Override
    public void destroy() {
        iUserService = null;
    }

    /*
    khi client sử dụng phương thức GET để gửi request lến server trong url
        url:  localhost:8080/t3h-helloworl
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserModel> userModels = iUserService.getListUser();
        String message = "Hello Ljava 2502";
        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    /*
        - sử dụng để tạo ra dữ liệu khi sử dụng method post với url
        localhost:8080/t3h-helloworl
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

}
