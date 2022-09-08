package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Lesson1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Test 01</title>\n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("                font-size: 25px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <form name=\"form1\" action=\"Lesson1\">\n");
      out.write("            <table style=\"border:2px solid orange;margin:auto\">\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan='3' align='center'>\n");
      out.write("                        <b><label style=\"font-size:30px;font-weight:bold;color:blue\">\n");
      out.write("                                PRIME DIVISOR\n");
      out.write("                            </label>\n");
      out.write("                        </b>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><br></td>\n");
      out.write("                    <td><br></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><i><b>Enter an integer n:</b></i></td>\n");
      out.write("                    <td rowspan='8'>\n");
      out.write("                        <textarea rows='7' cols='10' id=\"c\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ret}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><br></td>\n");
      out.write("                    <td><br></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type='text' id='a' name='numberInput' onkeyup=\"search()\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${n}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"width:150px\">\n");
      out.write("                        <input type='submit' name=\"set\" value='  >>  '>\n");
      out.write("                    </td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><br></td>\n");
      out.write("                    <td><br></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align='center'><input type=\"button\" value=\"RESET\" onclick=\"reload()\"\n");
      out.write("                                              style=\"font-size:20px;font-weight:bold;color:red\"></td>\n");
      out.write("                <script>\n");
      out.write("                    function reload() {\n");
      out.write("                        document.getElementById(\"a\").value = \"\";\n");
      out.write("                        document.getElementById(\"c\").value = \"\";\n");
      out.write("                    }\n");
      out.write("                    var request = new XMLHttpRequest();\n");
      out.write("                    function search() {\n");
      out.write("                        var numberInput = document.form1.numberInput.value;\n");
      out.write("                        var url = \"Lesson1?numberInput=\" + numberInput;\n");
      out.write("\n");
      out.write("                        try {\n");
      out.write("                            request.onreadystatechange = function () {\n");
      out.write("                                if (request.readyState == 4) {\n");
      out.write("                                    var el = document.createElement('html');\n");
      out.write("                                    el.innerHTML = request.responseText;\n");
      out.write("                                    var val = el.getElementsByTagName(\"textarea\")[0].value;\n");
      out.write("                                    if (val == \"Enter an integer n\")\n");
      out.write("                                        document.getElementById(\"a\").value = \"\";\n");
      out.write("                                    document.getElementById(\"c\").value = val;\n");
      out.write("                                }\n");
      out.write("                            }//end of function  \n");
      out.write("                            request.open(\"GET\", url, true);\n");
      out.write("                            request.send();\n");
      out.write("                        } catch (e) {\n");
      out.write("                            alert(\"Unable to connect to server\");\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                </script>\n");
      out.write("                <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><br></td>\n");
      out.write("                    <td><br></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><br></td>\n");
      out.write("                    <td><br></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><br></td>\n");
      out.write("                    <td><br></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><br></td>\n");
      out.write("                    <td><br></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
