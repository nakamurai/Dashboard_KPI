<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
		th.ac.kmutt.service.connectionJNDI jndi = new th.ac.kmutt.service.connectionJNDI();
           String query="SELECT * FROM eduqa.sys_year";
           String columns="1,2";
           
     jndi.selectByIndexDwh(query,columns);
    // System.out.println(jndi.getData());
     out.println(jndi.getData());
     
%>