package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.login.coll.loginDAO;
import com.system.connection.EncryptionDecryption;
import com.info.model.staff;
import com.info.model.BillingDetails;
import java.util.ArrayList;
import com.info.model.customerInfo;

public final class Invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Check Bill</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("            .FormMatra {\n");
      out.write("                margin-top: 2%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
 staff s = new staff();
      out.write("\n");
      out.write("\n");
      out.write("        ");

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
      out.write("        ");
if (!found_userID) {
                response.sendRedirect("index.jsp");
            } else {
                s = loginDAO.UserIdToFulStaff_details(EncryptionDecryption.decrypt(waterProject_username));
                if (!(s.getPay_control()) || (s == null)) {
                    response.sendRedirect("Dashboard.jsp");
                }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <button class=\"btn btn-danger\" style=\"margin-left: 5%\"><a href=\"Bill.jsp\">Back to DashBoard</a></button>\n");
      out.write("        ");

            Boolean IsFound = (Boolean) request.getAttribute("isFound");
            String Message = (String) request.getAttribute("Message");
            customerInfo CustomerInfomation = (customerInfo) request.getAttribute("CustomerInfo");
            ArrayList<BillingDetails> Get_AllRemaining_Bills = (ArrayList) request.getAttribute("AllRemaining_Bills");
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
if ((IsFound != null) && (Message != null)) {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert(\"");
out.print(Message);
      out.write("\");\n");
      out.write("        </script>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"test\">\n");
      out.write("            <div class=\"container\"> \n");
      out.write("                <div class=\"FormMatra\">\n");
      out.write("                    <form method=\"post\" action=\"InvoiceController\">\n");
      out.write("                        <input type=\"number\" name=\"case\" hidden=\"\" value=\"1\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-sm-2 col-form-label\" >Enter the Customer ID</label>\n");
      out.write("                            <div class=\"col-sm-2\">\n");
      out.write("                                <input type=\"number\" name=\"CustomerId\" class=\"form-control form-control-warning\" placeholder=\"Customer id\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <div class=\"offset-sm-2 col-sm-10\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\" style=\"    width: 165px;\">Check</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>   \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("             ");
if (IsFound != null && CustomerInfomation != null) {
      out.write("\n");
      out.write("                <form method=\"post\" action=\"InvoiceController\">\n");
      out.write("                    <table class=\"table table-striped table-bordered table-responsive\">\n");
      out.write("                        <th style=\"width: 105px;\">Customer ID</th>\n");
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
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <table class=\"table table-striped table-bordered table-responsive\">\n");
      out.write("                        <th style=\"width: 35px;\">S.N </th>\n");
      out.write("                        <th>Due Date</th>\n");
      out.write("                        <th>Amount</th>\n");
      out.write("                        <th>Fine/Discount</th>\n");
      out.write("                        <th>Total</th>\n");
      out.write("\n");
      out.write("                        ");

                            int i = 0;
                            Double Total = 0.0;
                            Double Fine_Disc = 0.0;
                            String Sign = "+";
                            for (BillingDetails BillDetail : Get_AllRemaining_Bills) {
                                i++;
                                Total = Total + BillDetail.getInvoice_Amt();
                                Fine_Disc = BillDetail.getFine();
                                if (BillDetail.getDiscount() > 0) {
                                    Fine_Disc = BillDetail.getDiscount();
                                    Sign = "-";
                                }
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td> ");
out.println(i);
      out.write(" </td>\n");
      out.write("                            <td> ");
out.println(BillDetail.getBill_Name());
      out.write(" </td>\n");
      out.write("                            <td> ");
out.println(BillDetail.getReading_Bill());
      out.write(" </td>\n");
      out.write("                            <td> ");
out.println(Sign + Fine_Disc);
      out.write(" </td>\n");
      out.write("                            <td> ");
out.println(BillDetail.getInvoice_Amt());
      out.write(" </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"4\" style=\"text-align: center;font-size: 17px;\">Grand Total</td>\n");
      out.write("                            <td>");
out.println(Total);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                        <input type=\"number\" name=\"case\" hidden=\"\" value=\"2\">\n");
      out.write("                        <td colspan=\"4\" style=\"text-align: center;font-size: 17px;\">Receved Amount</td>\n");
      out.write("                        <td><input type=\"number\" name=\"Recieved_Amt\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"4\" style=\"text-align: center;font-size: 17px;\"></td>\n");
      out.write("                            <td><button type=\"submit\" class=\"btn btn-primary\" style=\"    width: 165px;\">Pay</button></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <input hidden=\"\" type=\"text\" name=\"Bill_of\" value=\"");
out.print(CustomerInfomation.getApplicantFName()+" "+CustomerInfomation.getApplicantMName()+" "+CustomerInfomation.getApplicantLName());
      out.write("\">\n");
      out.write("                        <input hidden=\"\" type=\"text\" name=\"Bill_of_id\" value=\"");
out.print(CustomerInfomation.getCusid());
      out.write("\"\n");
      out.write("                               <input hidden=\"\" type=\"text\" name=\"User\" value=\"");
out.print(s.getId());
      out.write("\"\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
