package web.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.util.BuildObjectUtil;
import web.util.ResolveObjectUtil;

public class SqlHelper {

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
			Object attrValue=null;
			T object=null;
			while(rs.next()) {
				for(String attr:BuildObjectUtil.getAttrNames(clazz)) {
					try {
						attrValue=rs.getObject(attr);
						map.put(attr, attrValue);
					} catch (Exception e) {
						System.out.println("Mysql查询：获取列"+attr+"失败");
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
			col=col+","+key;
			row+=",";
			if("java.lang.String".equals(className)) {
				row=row+"'"+element.get(key)+"'";
			}else {
				row=row+element.get(key);
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
		for(String key:element.keySet()) {
			Object value=element.get(key);
			if(value==null) {
				continue;
			}
			String className=value.getClass().getName();
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
}
