<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
		th.ac.kmutt.service.connectionJNDI jndi = new th.ac.kmutt.service.connectionJNDI();
           String query="select distinct kpi_code, kpi_weight from kpi_result " +
						" where kpi_group_id = 2 order by kpi_name;";
           String columns="1,2";
           
     jndi.selectByIndexDwh(query,columns);
    // System.out.println(jndi.getData());
     out.println(jndi.getData());
     
%>