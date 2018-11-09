package com.lhf.exam.controller;

import com.lhf.exam.pojo.Desk;
import com.lhf.exam.service.DeskService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeskController {
    @Autowired
    @Setter
    private DeskService deskService;

    @RequestMapping(path = "/DeleteDesk", method = RequestMethod.POST)
    public void deleteDesk(HttpServletRequest request, String pageNum, String deskId) {
        boolean flag = deskService.deleteDesk(Integer.parseInt(deskId));
        request.getSession().setAttribute("pageold", pageNum);
    }

    @RequestMapping(path = "/InsertDesk", method = RequestMethod.POST)
    public void insertDesk(HttpServletRequest request) {
        Desk desk = new Desk();
        desk.setName(request.getParameter("dname"));
        desk.setContent(Integer.parseInt(request.getParameter("dcontent")));
        deskService.insertDesk(desk);
    }

    @RequestMapping(path = "/UpdateDeskServlet", method = RequestMethod.POST)
    public void updateDesk(HttpServletRequest request) {
        String olddesk = request.getParameter("oldname");
        Desk desk = new Desk();
        desk.setName(request.getParameter("dname"));
        desk.setContent(Integer.parseInt(request.getParameter("dcontent")));
        boolean flag = deskService.updateDesk(olddesk, desk);
    }
}
