package com.xiaoleilu.hutool.db.dialect;

import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.hutool.db.dialect.impl.AnsiSqlDialect;
import com.xiaoleilu.hutool.db.dialect.impl.MysqlDialect;
import com.xiaoleilu.hutool.db.dialect.impl.OracleDialect;
import com.xiaoleilu.hutool.db.dialect.impl.Sqllite3Dialect;

/**
 * 方言工厂类
 * @author loolly
 *
 */
public class DialectFactory {
	
	/** JDBC 驱动 MySQL */
	public final static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	/** JDBC 驱动 Oracle */
	public final static String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
	/** JDBC 驱动 PostgreSQL */
	public final static String DRIVER_POSTGRESQL = "org.postgresql.Driver";
	/** JDBC 驱动 SQLLite3 */
	public final static String DRIVER_SQLLITE3 = "org.sqlite.JDBC";
	
	private DialectFactory() {
	}
	
	/**
	 * 创建方言
	 * @param driverName JDBC驱动类名
	 * @return 方言
	 */
	public static Dialect newDialect(String driverName) {
		if(StrUtil.isNotBlank(driverName)) {
			if(DRIVER_MYSQL.equalsIgnoreCase(driverName)) {
				return new MysqlDialect();
			}else	if(DRIVER_ORACLE.equalsIgnoreCase(driverName)) {
				return new OracleDialect();
			}else	if(DRIVER_SQLLITE3.equalsIgnoreCase(driverName)) {
				return new Sqllite3Dialect();
			}
		}
		
		return new AnsiSqlDialect();
	}
}