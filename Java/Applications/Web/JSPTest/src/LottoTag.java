package classic.web.app;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class LottoTag extends SimpleTagSupport {

	private static Random rdm = new Random();

	private int digits = 8;
	private String var;

	public void setDigits(int value) { digits = value; }

	public void setVar(String name) { var = name; }

	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = super.getJspContext();
		JspFragment body = super.getJspBody();
		for(int i = 0; i < digits; ++i){
			int val = rdm.nextInt(10);
			context.setAttribute(var, val); //setting value in the page-context  identified by name given in var
			body.invoke(null); //output body content in current response
		}
	}

}

