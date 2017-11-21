package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.info.model.BillingDetails;
import com.info.model.staff;
import com.login.coll.loginDAO;
import com.system.connection.EncryptionDecryption;
import com.bill.cols.BiilingDAO;
import com.info.model.customerInfo;

public final class insertReading_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Insert Reading Page</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("            .FormMatra {\n");
      out.write("                margin-top: 2%;\n");
      out.write("            </style>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            ");
 staff s = new staff();
      out.write("\n");
      out.write("\n");
      out.write("            ");

                Cookie cookie = null;
                Cookie[] cookies = null;
                Boolean found_userID = false;
                String waterProject_username = null;
                // Get an array of Cookies associated with the this domain
                cookies = request.getCookies();
                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        cookie = cookies[i];
                        if ((cookie.getName().equals("waterProject_username"))) {
                            //                                                out.println("!!! Cookie found !!!");
                            if ((cookie.getValue() != null) && (cookie.getValue().length() > 0)) //               out.print("Value: " + cookie.getValue( )+" <br/>");
                            {
                                waterProject_username = cookie.getValue();
                                found_userID = !found_userID;
                            }
                        }
                    }
                } else {
                    //                response.sendRedirect("index.jsp");
                    //                                        out.println("<h2>No cookies founds</h2>");
                }
            
      out.write("\n");
      out.write("\n");
      out.write("            ");
if (!found_userID) {
                    response.sendRedirect("index.jsp");
                } else {
                    s = loginDAO.UserIdToFulStaff_details(EncryptionDecryption.decrypt(waterProject_username));
                    if (!(s.getBilling_control()) || (s == null)) {
                        response.sendRedirect("Dashboard.jsp");
                    }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <button class=\"btn btn-danger\" style=\"margin-left: 5%\"><a href=\"Bill.jsp\">Back to DashBoard</a></button>\n");
      out.write("                ");

                    BiilingDAO BilDAO = new BiilingDAO();
                    Boolean IsFound = (Boolean) request.getAttribute("isFound");
                    String Message = (String) request.getAttribute("Message");
                    customerInfo CustomerInfomation = (customerInfo) request.getAttribute("CustomerInfo");
                    BillingDetails Customer_LastReading_Details = (BillingDetails) request.getAttribute("lastReading_Row");
                
      out.write("\n");
      out.write("\n");
      out.write("                ");
if ((IsFound != null) && (Message != null)) {
                
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"");
out.print(Message);
      out.write("\");\n");
      out.write("                </script>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"test\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"FormMatra\">\n");
      out.write("                            <form method=\"post\" action=\"insertReadingController\">\n");
      out.write("                                <input type=\"number\" name=\"case\" hidden=\"\" value=\"1\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-sm-2 col-form-label\" >Enter the Customer ID</label>\n");
      out.write("                                    <div class=\"col-sm-2\">\n");
      out.write("                                        <input type=\"number\" name=\"CustomerId\" class=\"form-control form-control-warning\" placeholder=\"Customer id\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group row\">\n");
      out.write("                                    <div class=\"offset-sm-2 col-sm-10\">\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary\" style=\"    width: 165px;\">Check</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>   \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
if (IsFound != null && CustomerInfomation != null) {
      out.write("\n");
      out.write("                    <table class=\"table table-striped table-bordered table-responsive\">\n");
      out.write("                        <th>Consumer Id</th>\n");
      out.write("                        <th>Name</th>\n");
      out.write("                        <th>Parent's Name</th>\n");
      out.write("                        <th>Address</th>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"color: red; font-size: large;\">");
out.println(CustomerInfomation.getCusid());
      out.write("</td>\n");
      out.write("                            <td style=\"color: red; font-size: large;\">");
out.println(CustomerInfomation.getApplicantFName() + " " + CustomerInfomation.getApplicantMName() + " " + CustomerInfomation.getApplicantLName());
      out.write("</td>\n");
      out.write("                            <td>");
out.println(CustomerInfomation.getParentFName() + " " + CustomerInfomation.getParentMName() + " " + CustomerInfomation.getParentLName());
      out.write("</td>\n");
      out.write("                            <td>");
out.println("House No:" + CustomerInfomation.getHouseNumber() + " " + CustomerInfomation.getStreet() + ", " + CustomerInfomation.getMunicipality() + "-" + CustomerInfomation.getWardNumber() + "," + CustomerInfomation.getDistrict());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    <br>\n");
      out.write("\n");
      out.write("                    ");
if (Customer_LastReading_Details != null) {
      out.write("\n");
      out.write("                    <form action=\"insertReadingController\" method=\"post\">\n");
      out.write("                        <table class=\"table table-striped table-responsive\">\n");
      out.write("                            <th>Present Reading Name</th>\n");
      out.write("                            <th>Previous Reading</th>\n");
      out.write("                            <th>Status</th>\n");
      out.write("                            <th>Present Reading</th>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
out.print(Customer_LastReading_Details.getBill_Name());
      out.write("</td>\n");
      out.write("                                <td>");
out.print(Customer_LastReading_Details.getReading_Value());
      out.write("</td>\n");
      out.write("                                <td><select name=\"status\" class=\"form-group\">\n");
      out.write("                                        <option value=\"1\">Normal</option>\n");
      out.write("                                        <option value=\"2\">Door-Lock</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"CustomerId\" hidden=\"\" value=\"");
out.print(CustomerInfomation.getCusid());
      out.write("\">\n");
      out.write("                                    <input type=\"text\" name=\"Bill_Name\" hidden=\"\" value=\"");
out.print(Customer_LastReading_Details.getBill_Name());
      out.write("\">\n");
      out.write("                                    <input type=\"text\" name=\"Bill_by_id\" hidden=\"\" value=\"");
out.print(s.getId());
      out.write("\">\n");
      out.write("                                    <input type=\"text\" name=\"Last_Unit\" hidden=\"\" value=\"");
out.print(Customer_LastReading_Details.getReading_Value());
      out.write("\">\n");
      out.write("                                    <input type=\"Number\" name=\"case\" hidden=\"\" value=\"2\">\n");
      out.write("                                    <input type=\"Number\" name=\"Units\" style=\"width: -webkit-fill-available;\" placeholder=\"Enter here...........\" required=\"\">\n");
      out.write("                                    <button type=\"submit\" class=\"form-control\" style=\"color: black; background-color: rgba(0, 204, 255, 0.41); margin-top: 4px;\">Process</button>\n");
      out.write("                            </form>\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

//                s.getStaff_first_name();
                }
            
      out.write("\n");
      out.write("        </body>\n");
      out.write("    </html>\n");
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
