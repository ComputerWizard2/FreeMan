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
 * ����������ڵ�¼��֤���߼�
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
		// ��¼dao�Ķ���Ĵ���
		loginDao = new LoginDaoImp();
		// �����û������ʵ��
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
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// ��ҳ��Ļ�ȡ���ݣ�User pwd type
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String type = request.getParameter("utype");
		System.out.println(uname + "---" + upwd + "----" + type);
		Person person = new Person();
		person.setName(uname);
		person.setPwd(upwd);
		person.setType(type);
		// ��ȡҳ���servletpath���жϽ���
		String path = request.getServletPath();
		// ����ѡ��
		switch (path) {
		case "/login.in":
			// ���÷�������У��
			boolean user = isUser(person);
			if (user && "����Ա".equals(type)) {
				// ���÷�����ȡһ��������ʾ���ݿ��е���Ϣ
				// ���������Ĭ�ϵĵ�һҳ
				getUserInfo(1, 4);

				request.getRequestDispatcher("admin.jsp").forward(request, response);

			} else if (user && "�û�".equals(type)) {
				request.getRequestDispatcher("user.jsp").forward(request, response);

			} else {
				System.out.println("�����ˡ�����");

			}

			break;

		default:
			break;
		}

	}

	private static List<User> getUserInfo(int paseSize, int content) {
		// ���÷�ҳ��ѯ���е��û�
		userDao.selectAllUserByPage(paseSize, content);
		return null;

	}

	private static boolean isUser(Person person) {
		// ����͵���dao��ķ���
		// dao����Ӧ����servelet ��init������������
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
