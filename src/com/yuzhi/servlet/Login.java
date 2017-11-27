package com.yuzhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuzhi.DaoImp.LoginDaoImp;
import com.yuzhi.DaoImp.UserDaoIpm;
import com.yuzhi.dao.LoginDao;
import com.yuzhi.dao.UserDao;
import com.yuzhi.javabean.Person;
import com.yuzhi.javabean.User;

/**
 * 这个就是用于登录验证的逻辑
 * 
 */

/**
 * Servlet implementation class Login
 */
@WebServlet("*.in")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LoginDao loginDao;
	private static UserDao userDao;

	@Override
	public void init() throws ServletException {
		super.init();
		// 登录dao的对象的创建
		loginDao = new LoginDaoImp();
		// 创建用户对象的实现
		UserDao userDao = new UserDaoIpm();

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 从页面的获取数据：User pwd type
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String type = request.getParameter("utype");
		System.out.println(uname + "---" + upwd + "----" + type);
		Person person = new Person();
		person.setName(uname);
		person.setPwd(upwd);
		person.setType(type);
		// 获取页面的servletpath来判断进入
		String path = request.getServletPath();
		// 进行选择
		switch (path) {
		case "/login.in":
			// 调用方法进行校验
			boolean user = isUser(person);
			if (user && "管理员".equals(type)) {
				// 调用方发获取一个集合显示数据库中的信息
				// 进入后先是默认的第一页
				getUserInfo(1, 4);

				request.getRequestDispatcher("admin.jsp").forward(request, response);

			} else if (user && "用户".equals(type)) {
				request.getRequestDispatcher("user.jsp").forward(request, response);

			} else {
				System.out.println("出错了。。。");

			}

			break;

		default:
			break;
		}

	}

	private static List<User> getUserInfo(int paseSize, int content) {
		// 调用分页查询所有的用户
		userDao.selectAllUserByPage(paseSize, content);
		return null;

	}

	private static boolean isUser(Person person) {
		// 这里就调用dao层的方法
		// dao对象应该在servelet 的init方法出来对象
		boolean b = loginDao.findOneById(person);
		if (b) {
			return true;

		}
		return false;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
