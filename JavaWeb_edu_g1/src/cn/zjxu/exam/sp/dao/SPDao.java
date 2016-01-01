package cn.zjxu.exam.sp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjxu.exam.paper.domain.Paper;
import cn.zjxu.exam.sp.domain.SP;

public class SPDao {
	private QueryRunner qr = new TxQueryRunner();

	/*
	 * 插入一条成绩
	 */
	public void add(SP sp) {
		try {
			String sql = "insert into sp values(?,?,?)";
			Object[] params = { sp.getId(), sp.getPid(), sp.getGrade() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * 通过id查询集合
	 */
	public List<SP> findById(String id) {
		try {
			String sql = "select *from sp where id=" + id;
			return qr.query(sql, new BeanListHandler<SP>(SP.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
