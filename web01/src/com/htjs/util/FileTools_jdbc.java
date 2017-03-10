package test;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cmr on 2017/3/9.
 */
public class FileTools {

    private static Connection conn;

    static {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@83.16.16.198:1531:jsdb");
        ds.setUsername("hlwsb_cx");
        ds.setPassword("hlwsb_cx");

        ds.setInitialSize(3);
        ds.setMaxIdle(10);
        ds.setMaxActive(50);

        try {
            FileTools.conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUrlFromDB() throws Exception{
        Map<String,String> tableListMap = new HashMap<String, String>();
        List<Map<String,String>> listDm = new ArrayList<Map<String, String>>();
        String sql_sbbzl = "select * from(select rownum rn,n.* from " +
                          "(select t.sbbzl_dm,t.sbbzl_mc,t.url  " +
                          "from hlwsb_kf.dm_sbbzl t where t.url is not null " +
                          "order by t.sbbzl_dm) n )m where m.rn>180 and m.rn < 301";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql_sbbzl);
        while(rs.next()){
            Map<String,String> map =new HashMap<String, String>();
            String url = rs.getString("url");
            String sbbzl_mc = rs.getString("sbbzl_mc");
            String sbbzl_dm =rs.getString("sbbzl_dm");
            String tableName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf(".")).toUpperCase();
            if(tableListMap.containsKey(tableName)){
                String value = tableListMap.get(tableName);
                tableListMap.put(tableName,value+"; "+sbbzl_mc+":"+sbbzl_dm);
            }else{
                tableListMap.put(tableName.toUpperCase(),sbbzl_mc+":"+sbbzl_dm);
            }
            map.put(sbbzl_dm,sbbzl_mc+":"+tableName);

            listDm.add(map);
        }

        //根据查询出的url向查询库插入数据
        insertTest(listDm);
//        System.out.println(tableListMap.size());
//        for (String key:tableListMap.keySet()){
//            System.out.println(key+"===>"+tableListMap.get(key));
//        }
//        System.out.println("===================================");
//        System.out.println(listDm.size());
//        for(int i=0;i<listDm.size();i++){
//            System.out.println(listDm.get(i));
//        }
    }

    //根据查询出的url向查询库插入数据
    public void insertTest(List<Map<String,String>> listDm)throws Exception{
        String content = "";
        int total = 0;
        String tableName = "";
        //根据URL中的action名字找不到的表名保存在E盘errorTables.txt文件中
        FileOutputStream fos = new FileOutputStream("E:\\errorTables.txt");

        //拷贝数据库表
        Statement stmt = conn.createStatement();
        for (Map<String,String> map : listDm){
            for(String key : map.keySet()){
                tableName = map.get(key).toString().split(":")[1];
                try{
                    String querysql = "select * from " + tableName;
                    total = stmt.executeQuery(querysql).getRow();
                    if (total == 0){
                        String sql = "insert into "+tableName+" select * from hlwsb_kf."+tableName;
                        int row = stmt.executeUpdate(sql);
                        System.out.println("表名："+tableName+"  "+"总条数："+total+"  "+"插入条数："+row);
                    }
                }catch (Exception e){
                    content = (key + "  " + tableName);
                    content += "\r\n";
                    fos.write(content.getBytes());
                    continue;
                }
            }

        }
        fos.close();
    }


    @Test
    public void test()throws Exception{
        //E:\svn\sbcxdy\hlwsbWeb\src\htjs\web\hlwsb\actions\cwbb\qykjzd\SB_CWBB_QYKJZD_LRBAction.java
        Map<String,File> filesMap = new HashMap<String, File>();
        List<String> tableNameList = new ArrayList<String>();
        File file = new File("src\\htjs\\web\\hlwsb\\actions\\cwbb\\qykjzd");
        getFiles(file,filesMap);
        System.out.println(filesMap.size());
        for(String key:filesMap.keySet()){
            tableNameList.add(key.substring(0,key.lastIndexOf(".")-6));
        }
//        for(String value:tableNameList){
//            System.out.println(value);
//        }
        //向Java文件中增加查询ejb
        for(String key:filesMap.keySet()){
            //changeFile(filesMap.get(key));
        }
        //拷贝数据库表
        Statement stmt = conn.createStatement();
        for (String tableName:tableNameList){
            String sql = "insert into "+tableName+" select * from hlwsb_kf."+tableName;
            int row = stmt.executeUpdate(sql);
            System.out.println("向"+tableName+"表中插入了"+row+"条数据");
        }
    }


    public static void changeFile(File file)throws Exception{
        String filename = file.getName().substring(0,file.getName().lastIndexOf("."));
        String tablename =filename.substring(0,filename.length()-6);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder("");
        String convertStr="";
        String line;
        while((line=br.readLine())!=null){
            convertStr = line.replace("\\s+","").replace(" ","").toUpperCase();
            //已经已过了的跳过  qysds QYSDS Qysds
//            System.out.println(convertStr);
            if(convertStr.contains("CWBBCXDY")){
                sb = new StringBuilder("");
                return;
            }
            if(convertStr.contains("PRIVATECWBBCWBBUP")){
                sb.append(line);
                sb.append("\n");
                sb.append("    private Cwbb cwbbCxdy;\n");
                continue;
            }
            if(convertStr.contains("(CWBB)JSONHELP.GETBEAN(\"CWBBEJBUP\")")){
                sb.append(line);
                sb.append("\n");
                sb.append("        cwbbCxdy = (Cwbb)JsonHelp.getBean(\"cwbbEJBCXDY\");\n");
                continue;
            }
            if(convertStr.contains("CWBB.GET"+tablename)){
                sb.append("            Map retMap;\n");
                sb.append("            if(HelpTools.isPrint(mapParam))\n");
                sb.append("                retMap = cwbbCxdy.get"+tablename+"(searchMap);\n");
                sb.append("            else\n");
                sb.append("                retMap = cwbb.get"+tablename+"(searchMap);\n");
                continue;
            }
            sb.append(line);
            sb.append("\n");
        }
        br.close();
        String content = sb.toString();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content.getBytes());
        fos.close();
//        System.out.println(content);
    }

    //获取某个目录下的所有文件
    public static void getFiles(File file,Map<String,File> filesMap){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0;i<files.length;i++){
                File file2 = files[i];
                getFiles(file2,filesMap);
            }
        }else{
            filesMap.put(file.getName(),file);
        }
    }

}
