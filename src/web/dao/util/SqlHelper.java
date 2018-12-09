package web.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.util.BuildObjectUtil;
import web.util.ResolveObjectUtil;

public class SqlHelper {
	private static final String BaseEntityPacage="web.entity";
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static ResultSet executeQuery(String sql) {
		ResultSet rs=null;
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			rs=preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.err.println("执行Sql出现错误：sql="+sql+"  &|&msg="+e.getMessage());
		}
		return rs;
	}
	
	public static int executeNoQuery(String sql) {
		int i=0;
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("执行Sql出现错误：sql="+sql+"  &|&msg="+e.getMessage());
		}
		return i;
	}
	
	public static <T> T executeQueryOne(Class<?> clazz,String sql) {
		List<T> list=executeQuery(clazz,sql);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	public static <T> List<T> executeQuery(Class<?> clazz,String sql) {
		ArrayList<T> objects=new ArrayList<T>();
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet rs=preparedStatement.executeQuery();
			Map<String,Object> map=new HashMap<String,Object>();
			List<String> columns=getColumnsFromSql(sql);
			if(columns==null) {
				columns=new ArrayList<String>();
			}
			for(String attr:BuildObjectUtil.getAttrNames(clazz)) {
				if(!columns.contains(attr)) {
					columns.add(attr);
				}
			}
			Object attrValue=null;
			T object=null;
			while(rs.next()) {
				for(String attr:columns) {
					try {
						attrValue=rs.getObject(attr);
						map.put(attr, attrValue);
					} catch (Exception e) {
						try {
							Class<?> attrClass=Class.forName(BaseEntityPacage+"."+attr.substring(0, 1).toUpperCase()+attr.substring(1));
							T attr_Object=null;
							Map<String,Object> attr_Object_attrs=new HashMap<String,Object>();
							for(String attr_attr:BuildObjectUtil.getAttrNames(attrClass)) {
								Object attr_attr_value=null;
								try {
									attr_attr_value=rs.getObject(attr_attr);
								} catch (Exception e2) {
									continue;
								}
								if(attr_attr_value==null) {
									continue;
								}
								attr_Object_attrs.put(attr_attr, attr_attr_value);
							}
							attr_Object=BuildObjectUtil.build(attrClass, attr_Object_attrs);
							map.put(attr, attr_Object);
						} catch (Exception e1) {
							System.out.println("SQL查询：获取列"+attr+"失败");
						}
					}
				}
				object=BuildObjectUtil.build(clazz, map);
				if(object!=null) {
					objects.add(object);
				}
				map.clear();
			}
		} catch (Exception e) {
			System.err.println("执行Sql出现错误：sql="+sql+"  &|&msg="+e.getMessage());
		}
		return objects;
	}
	
	public static <E> int executeInsert(String tableName,E object) {
		String sql="insert into "+tableName;
		String col="";
		String row="";
		Map<String,Object> element=ResolveObjectUtil.resolveObject(object);
		for(String key:element.keySet()) {
			Object value=element.get(key);
			if(value==null) {
				continue;
			}
			String className=value.getClass().getName();
			if(!className.startsWith("java.lang")&&!className.startsWith("java.math")&&!className.equals("java.util.Date")) {
				continue;
			}
			col=col+","+key;
			row+=",";
			if("java.lang.String".equals(className)) {
				row=row+"'"+element.get(key)+"'";
			}else {
				Object value1=element.get(key);
				if(className.equals("java.util.Date")) {
					row=row+"'"+sdf.format(value1)+"'";
				}else {
					row=row+element.get(key);
				}
			}
		}
		sql=sql+"("+col.substring(1)+") values("+row.substring(1)+")";
		return SqlHelper.executeNoQuery(sql);
	}
	
	public static <E> int executeInsert(String tableName,List<E> objects) {
		String sql="insert into "+tableName;
		String col="";
		String crow="";
		boolean getedAttrNames=false;
		List<Map<String,Object>> elements=ResolveObjectUtil.resolveObjects(objects);
		for(Map<String,Object> element:elements) {
			String row="";
			for(String key:element.keySet()) {
				Object value=element.get(key);
				if(value==null) {
					continue;
				}
				String className=value.getClass().getName();
				if(!className.startsWith("java.lang")&&!className.startsWith("java.math")) {
					continue;
				}
				if(!getedAttrNames) {
					col=col+","+key;
				}
				row+=",";
				if("java.lang.String".equals(className)) {
					row=row+"'"+element.get(key)+"'";
				}else {
					row=row+element.get(key);
				}
			}
			if(!getedAttrNames) {
				sql=sql+"("+col.substring(1)+")";
				getedAttrNames=true;
			}
			crow=crow+",("+row.substring(1)+")";
		}
		sql=sql+" values"+crow.substring(1)+";";
		return SqlHelper.executeNoQuery(sql);
	}
	
	/**
	 * 执行更新操作
	 * @param tableName 表名
	 * @param object	数据对象
	 * @param whereCause SQL的"Where id=xx"等语句，开头不需要空格
	 * @return
	 */
	public static <E> int executeUpdate(String tableName,E object,String whereCause) {
		String sql="update "+tableName+" set ";
		String sets="";
		Map<String,Object> element=ResolveObjectUtil.resolveObject(object);
		String prikey=getPrimaryKeyFromSqlWhere(whereCause);
		if(prikey!=null&&!"".equals(prikey)) {
			element.remove(prikey);
		}
		for(String key:element.keySet()) {
			Object value=element.get(key);
			if(value==null) {
				continue;
			}
			String className=value.getClass().getName();
			if(!className.startsWith("java.lang")&&!className.startsWith("java.math")) {
				continue;
			}
			sets=sets+","+key+"=";
			if("java.lang.String".equals(className)) {
				sets=sets+"'"+element.get(key)+"'";
			}else {
				sets=sets+element.get(key);
			}
		}
		sql=sql+sets.substring(1)+" "+whereCause;
		return SqlHelper.executeNoQuery(sql);
	}
	
	private static List<String> getColumnsFromSql(String sql){
		List<String> list=new ArrayList<String>();
		if(sql==null) {
			return null;
		}
		sql=sql.toLowerCase();
		int selectEndIndex=sql.indexOf("select")+6;
		int fromStartIndex=sql.indexOf("from")-1;
		String columnString=sql.substring(selectEndIndex, fromStartIndex).trim();
		String[] columnStrs=columnString.split(",");
		for(String columnStr:columnStrs) {
			if(columnStr.contains("*")) {
				continue;
			}
			int whitespaceIndex=columnStr.trim().indexOf(" ");
			if(whitespaceIndex>0) {
				columnStr=columnStr.substring(whitespaceIndex+1).trim();
			}
			int pointIndex=columnStr.trim().indexOf(".");
			if(pointIndex>0) {
				columnStr=columnStr.substring(pointIndex+1).trim();
			}
			list.add(columnStr);
		}
		return list;
	}
	
	private static String getPrimaryKeyFromSqlWhere(String whereCase) {
		String whereCase_LowerCase=whereCase.toLowerCase().trim();
		int whereStrIndex=whereCase_LowerCase.indexOf("where")+6;
		int equalsStrIndex=whereCase_LowerCase.indexOf("=");
		String key=whereCase.substring(whereStrIndex, equalsStrIndex);
		return key;
	}
	
	public static void main(String[] args) throws SQLException {
		
	}
}
