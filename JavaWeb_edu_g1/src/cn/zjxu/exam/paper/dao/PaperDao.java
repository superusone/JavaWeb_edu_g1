package cn.zjxu.exam.paper.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjxu.exam.paper.domain.Paper;

public class PaperDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 查询所有试题
	 * 
	 * @return 试题结果集
	 */
	public List<Paper> findAll() {
		try {
			String sql = "select * from paper ";
			return qr.query(sql, new BeanListHandler<Paper>(Paper.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按照试卷类型查询
	 * 
	 * @param note
	 *            A或B卷...
	 * @return 试题集
	 */
	public List<Paper> findByNote(String note) {
		try {
			String sql = "select * from paper where note=" + note;
			return qr.query(sql, new BeanListHandler<Paper>(Paper.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过试题pid查询
	 * 
	 * @param pid
	 *            试题PID
	 * @return 试题
	 */
	public Paper findByPid(String pid) {
		try {
			String sql = "select * from paper where pid=?";
			return qr.query(sql, new BeanHandler<Paper>(Paper.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑试题
	 * 
	 * @param p
	 */
	public void edit(Paper p) {
		try {
			String sql = "update paper set `type`=?,`q_subject`=?,q_answer=?,optionA=?,optionB=?,optionC=?,optionD=?,note=? where pid=?";
			Object[] params = { p.getType(), p.getQ_subject(), p.getQ_answer(),
					p.getOptionA(), p.getOptionB(), p.getOptionC(),
					p.getOptionD(), p.getNote(), p.getPid() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除试题
	 *
	 * @param p
	 */
	public void delete(Paper p) {
		// 伪删除吧记录抹掉

		try {
			String sql = "DELETE FROM `edu`.`paper` WHERE `pid`=?";
			Object[] params = { p.getPid() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除试题
	 *
	 * @param pid
	 */
	public void delete(String pid) {
		// 伪删除吧记录抹掉

		try {
			String sql = "DELETE FROM `edu`.`paper` WHERE `pid`=?";
			Object[] params = { pid };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 插入Paper试题
	 *
	 * @param paper
	 */
	public void add(Paper paper) {
		try {
			String sql = "insert into paper values(?,?,?,?,?,?,?,?,?)";
			Object[] params = { paper.getPid(), paper.getType(),
					paper.getQ_subject(), paper.getQ_answer(),
					paper.getOptionA(), paper.getOptionB(), paper.getOptionC(),
					paper.getOptionD(), paper.getNote() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改指定试题的备注
	 *
	 * @param pid
	 * @param note
	 */
	public void updateMark(String pid, String note) {
		try {
			String sql = "update paper set note=? where pid=?";
			qr.update(sql, note, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 试题备注
	 * @param pid
	 * @return 备注
	 */
	public String getNote(String pid) {
		try {
			String sql = "select * from paper where pid=?";
			Paper paper = qr.query(sql, new BeanHandler<Paper>(Paper.class),
					pid);
			return paper.getNote();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
