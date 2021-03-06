package th.ac.kmutt.service;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Connection;


public class connectionJNDI {
    private static Logger logger=Logger.getLogger("connectionJNDI");

  String data1 = "";
  String data2 = "";
  String data3 = "";
  String data4 = "";
  String dataMonth="";
  Object dataObject="";
  String returnWord="";
  String locationTypeHTML="";
  String LandlordGroupHTML="";
  String BrandHTML="";
  String RegionHTML="";
  String ProvinceHTML="";
  String AreaHTML="";
  String FormatHTML="";
  String optionBranch="";
  
  

  public void init2() {
        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/TestDB");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
               
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(
                      "select * from register_tbl");
                while(rst.next()) {
                   data1+=rst.getString(1);
                  
                }
                conn.close();
            }
          }
        }catch(Exception e) {
            e.printStackTrace();
            logger.error("erorr"+e);
        }
     }
  public void selectByColumnName(String query,String field) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/TestDB");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataObject="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                String[] fieldSplit=field.split(",");
                
                JSONArray obj_json = new JSONArray();
                while(rst.next()) {
                    JSONArray sub_obj_json = new JSONArray();
                    for(int i=0;i<fieldSplit.length;i++){
                        
                        sub_obj_json.put(rst.getString(fieldSplit[i]));
                        
                    }
                    obj_json.put(sub_obj_json);
                    dataObject=obj_json;
                    
                }
                
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  public void setStoreFactsContractName(String query,String field) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/TestDB");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataObject="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                String[] fieldSplit=field.split(",");
                
                JSONArray obj_json = new JSONArray();
                while(rst.next()) {
                    JSONArray sub_obj_json = new JSONArray();
                    for(int i=0;i<fieldSplit.length;i++){
                        
                        sub_obj_json.put(rst.getString(fieldSplit[i]));
                        
                    }
                    //obj_json.put(sub_obj_json);
                    dataObject=sub_obj_json;
                    
                }
                
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  public void setStoreFactsContractIndex(String query,String field) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataObject="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                String[] fieldSplit=field.split(",");
                
                JSONArray obj_json = new JSONArray();
                
                JSONArray sub_obj_json = new JSONArray();
                while(rst.next()) {
                    
                    
                    for(int i=0;i<fieldSplit.length;i++){
                        
                        sub_obj_json.put(rst.getString(Integer.parseInt(fieldSplit[i])));
                        
                    }
                    

                }
                dataObject=sub_obj_json;
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  public void selectByIndexConfig(String query,String columns) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/snp-Config");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataObject="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                String[] fieldSplit=columns.split(",");
                
                JSONArray obj_json = new JSONArray();
                
                    
                while(rst.next()) {
                    
                    JSONArray sub_obj_json = new JSONArray();
                    for(int i=0;i<fieldSplit.length;i++){
                        
                        sub_obj_json.put(rst.getString(Integer.parseInt(fieldSplit[i])));
                        
                    }
                    obj_json.put(sub_obj_json);

                }
                dataObject=obj_json;
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  public void selectByIndexDwh(String query,String columns) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                  //"java:comp/env/jdbc/TESTShared");
                		"java:comp/env/jdbc/jndiDB");
                		

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataObject="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                String[] fieldSplit=columns.split(",");
                
                JSONArray obj_json = new JSONArray();
                
                    
                while(rst.next()) {
                    
                    JSONArray sub_obj_json = new JSONArray();
                    for(int i=0;i<fieldSplit.length;i++){
                        
                        sub_obj_json.put(rst.getString(Integer.parseInt(fieldSplit[i])));
                        
                    }
                    obj_json.put(sub_obj_json);

                }
                dataObject=obj_json;
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  
  
  public void insert(String query) {

      try{
        Context ctx = new InitialContext();
        if(ctx == null ) 
            throw new Exception("Boom - No Context");

        DataSource ds = 
              (DataSource)ctx.lookup(
                //"java:comp/env/jdbc/TESTShared");
              		"java:comp/env/jdbc/jndiDB");
              		

        if (ds != null) {
        	 System.out.println("pass1");
          Connection conn = ds.getConnection();
                
          if(conn != null)  {
        	  System.out.println("pass2");
        	  returnWord="";
              Statement stmt = conn.createStatement();
              stmt.executeUpdate(query);
              
              returnWord="PASS";
              conn.close();
              System.out.println("pass3");
          }
        }
      }catch(Exception e) {
    	  System.out.println("Error");
        e.printStackTrace();
        logger.error("erorr"+e);
      }
   }
   
   public void selectByQuery(String query) {

      try{
        Context ctx = new InitialContext();
        if(ctx == null ) 
            throw new Exception("Boom - No Context");

        DataSource ds = 
              (DataSource)ctx.lookup(
                //"java:comp/env/jdbc/TESTShared");
              		"java:comp/env/jdbc/jndiDB");
              		

        if (ds != null) {
        	 System.out.println("pass1A");
          Connection conn = ds.getConnection();
                
          if(conn != null)  {
        	  System.out.println("pass2A");
        	  dataObject="";
              Statement stmt = conn.createStatement();
              ResultSet rst = 
                      stmt.executeQuery(query);
              String columns = "1";
              String[] fieldSplit=columns.split(",");
              JSONArray obj_json = new JSONArray();
              int counData = 0;
              while(rst.next()) {
            	  counData++;
            	  JSONObject jobj = new JSONObject();
                 // JSONArray sub_obj_json = new JSONArray();
                  for(int i=0;i<fieldSplit.length;i++){
                      
                      //sub_obj_json.put(rst.getString(Integer.parseInt(fieldSplit[i])));
                      jobj.put("Code", rst.getString(1));
                      jobj.put("Name", rst.getString(2));
                      jobj.put("RefName", rst.getString(2));
                  }
                  obj_json.put(jobj);

              }
              
       
              
              System.out.println("Data Total : "+counData);
              dataObject=obj_json;
              conn.close();
          }
        }
      }catch(Exception e) {
    	  System.out.println("Error");
        e.printStackTrace();
        logger.error("erorr"+e);
      }
   }
   
  
  public void search(String query) {

      try{
        Context ctx = new InitialContext();
        if(ctx == null ) 
            throw new Exception("Boom - No Context");

        DataSource ds = 
              (DataSource)ctx.lookup(
                //"java:comp/env/jdbc/TESTShared");
              		"java:comp/env/jdbc/jndiDB");
              		

        if (ds != null) {
        	 System.out.println("pass1A");
          Connection conn = ds.getConnection();
                
          if(conn != null)  {
        	  System.out.println("pass2A");
        	  dataObject="";
              Statement stmt = conn.createStatement();
              ResultSet rst = 
                      stmt.executeQuery(query);
              String columns = "1";
              String[] fieldSplit=columns.split(",");
              JSONArray obj_json = new JSONArray();
              int counData = 0;
              while(rst.next()) {
            	  counData++;
            	  JSONObject jobj = new JSONObject();
                 // JSONArray sub_obj_json = new JSONArray();
                  for(int i=0;i<fieldSplit.length;i++){
                      
                      //sub_obj_json.put(rst.getString(Integer.parseInt(fieldSplit[i])));
                      jobj.put("Name", rst.getString(Integer.parseInt(fieldSplit[i])));
                      jobj.put("RefName", rst.getString(Integer.parseInt(fieldSplit[i])));
                  }
                  obj_json.put(jobj);

              }
              
       
              
              System.out.println("Data Total : "+counData);
              dataObject=obj_json;
              conn.close();
          }
        }
      }catch(Exception e) {
    	  System.out.println("Error");
        e.printStackTrace();
        logger.error("erorr"+e);
      }
   }
  
  
  public void selectByIndexTest(String query,String columns) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/TestDB");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataObject="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                String[] fieldSplit=columns.split(",");
                
                JSONArray obj_json = new JSONArray();
                
                    
                while(rst.next()) {
                    
                    JSONArray sub_obj_json = new JSONArray();
                    for(int i=0;i<fieldSplit.length;i++){
                        
                        sub_obj_json.put(rst.getString(Integer.parseInt(fieldSplit[i])));
                        
                    }
                    obj_json.put(sub_obj_json);

                }
                dataObject=obj_json;
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  
  public void setStoreFactsContract(String query,String paramBranchCode,String field) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataObject="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                String[] fieldSplit=field.split(",");
                
                JSONArray obj_json = new JSONArray();
                
                    
                while(rst.next()) {
                    
                    JSONArray sub_obj_json = new JSONArray();
                    
                    sub_obj_json.put(paramBranchCode);
                    
                    for(int i=0;i<fieldSplit.length;i++){
                        
                        sub_obj_json.put(rst.getString(Integer.parseInt(fieldSplit[i])));
                        
                    }
                    obj_json.put(sub_obj_json);

                }
                dataObject=obj_json;
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
 //StoreFactsContract
  
  public void selectExpiring(String query,String query2,String query3) {

        try{
          
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                
                Statement stmt = conn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                JSONArray obj_json = new JSONArray();
                int i=0;
                while(rst.next()) {
                    JSONArray sub_obj_json = new JSONArray();
                        //sub_obj_json.put("i"+i);
                        String[] subStringNumber;
                        subStringNumber=rst.getString(1).split("-");
                        sub_obj_json.put(rst.getString(1));
                        sub_obj_json.put(rst.getString(2));
                        sub_obj_json.put(rst.getString(3));
                        sub_obj_json.put(rst.getString(4));
                        sub_obj_json.put(rst.getString(5));
                        String concat="CALL SparkLineNetSalesSqM('"+subStringNumber[1]+"',"+query2+")";
                        monthSparkline(concat);
                        sub_obj_json.put(getMonthSparkline());
                        
                        String concat2="CALL SparkLineRentNetSales('"+subStringNumber[1]+"',"+query3+")";
                        monthSparkline(concat2);
                        sub_obj_json.put(getMonthSparkline());
                        
                        //SparkLineRentNetSales    
                         
                        obj_json.put(sub_obj_json);
                    
                i++;
                }
                dataObject=obj_json;
                
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  public void monthSparkline(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataMonth="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);

                while(rst.next()) {
                    dataMonth+=""+rst.getString(2)+","+rst.getString(3)+","+rst.getString(4)+","+rst.getString(5)+","+rst.getString(6)+","+rst.getString(7)+","+rst.getString(8)+","+rst.getString(9)+","+rst.getString(10)+","+rst.getString(11)+","+rst.getString(12)+","+rst.getString(13)+"";
                    
                }
                
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  public void listLocationType(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataMonth="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                locationTypeHTML+="<ul>";
                int i=0;
                while(rst.next()) {
                    
                    locationTypeHTML+="<li>";
                    locationTypeHTML+="<a href=\"#\" class=\"listLocationType\" id=\"locationTypeId"+i+"\">";
                    locationTypeHTML+=rst.getString(1);
                    locationTypeHTML+="</li>";
                    i++;
                    
                }
                locationTypeHTML+="</ul>";
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  public void listLandlordGroup(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/TESTShared");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataMonth="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                int i=0;
                LandlordGroupHTML+="<ul>";
                while(rst.next()) {
                    
                    LandlordGroupHTML+="<li>";
                    LandlordGroupHTML+="<a href=\"#\" class=\"listLandlordGroup\" id=\"landlordGroupId"+i+"\">";
                    LandlordGroupHTML+=rst.getString(1);
                    LandlordGroupHTML+="</li>";
                    i++;
                    
                }
                LandlordGroupHTML+="</ul>";
                
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  public void listBrand(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataMonth="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                int i=0;
                BrandHTML+="<ul>";
                while(rst.next()) {
                    
                    BrandHTML+="<li>";
                    BrandHTML+="<a href=\"#\" class=\"listBrand\" id=\"brandId"+i+"\">";
                    BrandHTML+=rst.getString(1);
                    BrandHTML+="</li>";
                    i++;
                    
                }
             
                BrandHTML+="</ul>";
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  public void listRegion(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataMonth="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                int i=0;
                RegionHTML+="<ul>";
                while(rst.next()) {
                    
                    RegionHTML+="<li>";
                    RegionHTML+="<a href=\"#\" class=\"listRegion\" id=\"regionId"+i+"\">";
                    RegionHTML+=rst.getString(1);
                    RegionHTML+="</li>";
                    i++;
                    
                }
             
                RegionHTML+="</ul>";
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  //listRegion
  
  public void listProvince(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataMonth="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                int i=0;
                ProvinceHTML+="<ul>";
                while(rst.next()) {
                    
                    ProvinceHTML+="<li>";
                    ProvinceHTML+="<a href=\"#\" class=\"listProvince\" id=\"provinceId"+i+"\">";
                    ProvinceHTML+=rst.getString(1);
                    ProvinceHTML+="</li>";
                    i++;
                    
                }
             
                ProvinceHTML+="</ul>";
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
//listProvince
  
  public void listArea(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataMonth="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                int i=0;
                AreaHTML+="<ul>";
                while(rst.next()) {
                    
                    AreaHTML+="<li>";
                    AreaHTML+="<a href=\"#\" class=\"listArea\" id=\"areaId"+i+"\">";
                    AreaHTML+=rst.getString(1);
                    AreaHTML+="</li>";
                    
                    i++;
                    
                }
             
                AreaHTML+="</ul>";
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
//listArea
//listFormat
  public void listFormat(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                dataMonth="";
                Statement stmt = conn.createStatement();
                ResultSet rst = 
                    stmt.executeQuery(query);
                int i=0;
                FormatHTML+="<ul>";
                while(rst.next()) {
                    
                    FormatHTML+="<li>";
                    FormatHTML+="<a href=\"#\" class=\"listFormat\" id=\"formatId"+i+"\">";
                    FormatHTML+=rst.getString(1);
                    FormatHTML+="</li>";
                    
                    i++;
                    
                }
                FormatHTML+="</ul>";
                
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  //optionBranch
  public void setOptionBranch(String query) {

        try{
          Context ctx = new InitialContext();
          if(ctx == null ) 
              throw new Exception("Boom - No Context");

          DataSource ds = 
                (DataSource)ctx.lookup(
                   "java:comp/env/jdbc/kmutt_jndi");

          if (ds != null) {
            Connection conn = ds.getConnection();
                  
            if(conn != null)  {
                
                Statement stmt = conn.createStatement();
                ResultSet rst = stmt.executeQuery(query);
                optionBranch="";
                optionBranch+="<select class=\"listSelect1\" id=\"branch\">";
                while(rst.next()){
                    optionBranch+="<option value='"+rst.getString(1)+"'>"+rst.getString(2)+"</option>";
                }
                optionBranch+="</select>";
                
                conn.close();
            }
          }
        }catch(Exception e) {
          e.printStackTrace();
          logger.error("erorr"+e);
        }
     }
  
  


//public String getdata1() { return data1;}
// public String getdata2() { return data2;}
 public String getMonthSparkline() { return dataMonth;}
 public String getLocationTypeHTML() { return locationTypeHTML;}
 public String getLandlordGroupHTML() { return LandlordGroupHTML;}
 public String getBrandHTML() { return BrandHTML;}
 public String getRegionHTML() { return RegionHTML;}
 public String getProvinceHTML() { return ProvinceHTML;}
 public String getAreaHTML() { return AreaHTML;}
 public String getFormatHTML() { return FormatHTML;}
 public String getOptionBranch() { return optionBranch;}
 
 public String getResult() { return returnWord;}
 public Object getData() { return dataObject;}
}