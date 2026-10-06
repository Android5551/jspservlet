package com.rays.ctl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
import com.rays.util.ServletUtility;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel m = new UserModel();
		UserBean b = new UserBean();
		
		int pageNo = 1;
		int pageSize = 5;
		
		List<UserBean> l= m.search(b, pageNo, pageSize);
		System.out.println("List Size in doGet "+l.size());
		req.setAttribute("pageNo",pageNo);
		req.setAttribute("pageSize",pageSize);
		req.setAttribute("list",l);
		
		ServletUtility.forward("UserListView.jsp", req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		UserModel m = new UserModel();
		UserBean b = new UserBean();
		int pageNo = 1;
		int pageSize = 5;
		System.out.println(op);
		if("next".equals(op)) {
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
			System.out.println("PageNo. in doPost "+pageNo);
			pageNo++;
		}
		if(op == "previous") {
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
			System.out.println("PageNo. in doPost "+pageNo);
			pageNo--;
		}
		
//	 	List<UserBean> l = m.search(b, 1, 5);  So every time you click Next, you're asking the database for page 1 again.
	 	List<UserBean> l = m.search(b, pageNo, pageSize); 
	 	Iterator<UserBean> i = l.iterator();
	 	while(i.hasNext()) {
	 		b = i.next();
	 		System.out.println(b.getFirstName());
	 	}
	 	System.out.println("List Size in doPost "+l.size());
	 	
	 	req.setAttribute("list",l);
	 	req.setAttribute("pageNo", pageNo);
	 	req.setAttribute("pageSize", pageSize);
	 	
	 	ServletUtility.forward("UserListView.jsp", req, resp);
	 	
		
	}
}
