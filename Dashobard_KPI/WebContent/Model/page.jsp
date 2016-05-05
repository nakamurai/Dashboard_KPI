<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
		th.ac.kmutt.service.connectionJNDI jndi = new th.ac.kmutt.service.connectionJNDI();
           String query="select kpi_code, kpi_weight, kpi_name ,target_value,calendar_year,sum(percent_actual_vs_target) as column_chart " + 
		                "from kpi_result where kpi_group_id = 2 group by kpi_code, kpi_weight, kpi_name ,target_value,calendar_year " + 
                        " order by kpi_name";
						//" where kpi_group_id = 2 order by kpi_name;";
           String columns="1,2,3,4,5,6";
           
     jndi.selectByIndexDwh(query,columns);
    // System.out.println(jndi.getData());
     out.println(jndi.getData());
     
%>