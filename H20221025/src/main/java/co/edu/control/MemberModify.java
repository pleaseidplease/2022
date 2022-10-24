package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;

public class MemberModify implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자입력정보를 parameter 읽어와야된다.
		MemberService service=new MemberServiceImpl();
		service.modifyMember(null);
		HttpUtil.forward(req, resp, "memberResult/memberUpdateOutput.jsp");
	}

}
