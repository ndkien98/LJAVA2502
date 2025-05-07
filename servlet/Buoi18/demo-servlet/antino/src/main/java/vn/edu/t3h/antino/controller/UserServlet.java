package vn.edu.t3h.antino.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.antino.dao.IUserDao;
import vn.edu.t3h.antino.dao.impl.UserDaoImpl;
import vn.edu.t3h.antino.dao.impl.UserDaoOracleImpl;
import vn.edu.t3h.antino.model.UserModel;
import vn.edu.t3h.antino.service.IUserService;
import vn.edu.t3h.antino.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

// localhost:8080/user-manager
/*
localhost:8080/user-manager?name=kiennd25
parameter

localhost:8080/user/1
pacthavable

@WebServlet
    - khai báo đường dẫn url cho servlet
    - giúp servlet mapping được url đó sẽ được servlet nào xử lý

 */
@WebServlet("/user-manager")
public class UserServlet extends HttpServlet {

    private IUserService iUserService;

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        // lấy ra model từ các tầng service, dao
        List<UserModel> userModelsDatabase = iUserService.getListUser();
        // gắn model vào view
        req.setAttribute("userModels", userModelsDatabase);
        // trả ra view đã chứa model
        req.getRequestDispatcher("/pages/user-manager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
