package cn.zjxu.exam.sp.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
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
}
