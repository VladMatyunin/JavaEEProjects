package medlinesoft.servlets;

import com.sun.deploy.net.HttpRequest;
import medlinesoft.entity.Part;
import medlinesoft.repository.PartRepository;
import medlinesoft.viewmodels.PartViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Vlad on 08/12/17.
 */
@WebServlet(value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            repository = new PartRepository();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        super.init();
    }

    private PartRepository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("partList", repository.getAll(new PartViewModel()));
            req.setAttribute("filter", new PartViewModel());
            req.setAttribute("header_text", "Hello, Vlad");
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/part.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("error", "SQL error occurred while accessing database:"+e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PartViewModel filter = convert(req);
            req.setAttribute("partList", repository.getAll(filter));
            req.setAttribute("filter", filter);
        } catch (SQLException e) {
            req.setAttribute("error", "SQL error occurred while accessing database:"+e.getMessage());
        } catch (ParseException e) {
            req.setAttribute("error", "error while parsing date, use pattern MMM dd, yyyy: "+e.getMessage());
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/part.jsp").forward(req, resp);
    }

    // method for helper, can be replaced to another file
    private PartViewModel convert(HttpServletRequest request) throws ParseException {
        PartViewModel viewModel = new PartViewModel();
        viewModel.setName(request.getParameter("name"));
        viewModel.setNumber(request.getParameter("number"));
        viewModel.setVendor(request.getParameter("vendor"));
        String qty = request.getParameter("qty");
        if (!Objects.equals(qty, ""))viewModel.setQty(Integer.valueOf(qty));
        else viewModel.setQty(Integer.MAX_VALUE);
        // parse dates
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);
        viewModel.setReceivedAfter(parseDate(request.getParameter("receivedAfter"), simpleDateFormat));
        viewModel.setReceivedBefore(parseDate(request.getParameter("receivedBefore"), simpleDateFormat));
        viewModel.setShippedAfter(parseDate(request.getParameter("shippedAfter"),simpleDateFormat));
        viewModel.setShippedBefore(parseDate(request.getParameter("shippedBefore"),simpleDateFormat));
        //parse hidden
        String orderBy = request.getParameter("orderByParameter");
        viewModel.setOrderByParameter(orderBy.equals("")?"number":orderBy);
        viewModel.setAsc(Boolean.parseBoolean(request.getParameter("asc")));
        return viewModel;
    }
    private Date parseDate(String parameter, SimpleDateFormat dateFormat) throws ParseException {
        return parameter.equals("")?null:dateFormat.parse(parameter);
    }

    @Override
    public void destroy() {
        try {
            repository.dispose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.destroy();
    }
}
