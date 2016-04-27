package com.jking.goods.user.dao;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;

/**
 * 用户模块持久化层
 * @author joker
 *
 */
public class UserDAO {
	private QueryRunner qr = new TxQueryRunner() ;
}
