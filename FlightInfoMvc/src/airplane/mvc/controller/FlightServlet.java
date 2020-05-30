package airplane.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airplane.mvc.FlightApp;
import airplane.mvc.model.Item;


public class FlightServlet extends HttpServlet {


@Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {

	  
	  // 1) index.html(첫 페이지)에서 사용자가 선택한 출발지, 도착지, 출발시간 값을 읽어옴
      String depart = request.getParameter("depart");
      String arrival = request.getParameter("arrival");
      String departTime = request.getParameter("departTime");

      // 2) 사용자가 선택한 위 세가지 조건값으로 FlightApp 객체를 생성하고
      FlightApp flightApp = new FlightApp(depart, arrival, departTime);
      
      // 3) search()를 호출하면 해당 조건에 맞는 모든 비행편이 검색되어 allFlights에 반환됨
      List<Item> allFlights = flightApp.search();
      
      // 4) 반환된 결과값을 request 객체에 저장함
      request.setAttribute("result", allFlights);
     
      // 5) 결과값이 null이냐(검색 건수 0) 아니냐에 따라 각각 다른 JSP 페이지로 처리하도록(결과를 보여주도록) 함
      if (allFlights == null) {
    	  RequestDispatcher dispatcher = request.getRequestDispatcher("/noResult.jsp");
    	  dispatcher.forward(request, response);
      } else {
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/viewFlight.jsp");
	      dispatcher.forward(request, response);
      }
   }

}
