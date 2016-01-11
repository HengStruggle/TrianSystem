package com.dbDesign.util;

import java.sql.Date;
import java.sql.Time;

public class SqlUtils {

	public static final String SELECT_TABLE = "select * from {0} ";

	public static final String WHERE_CONDITION = " where {0} = {1} ";

	public static final String SINGLE_CONDITION = " {0} = {1} ";

	public static final String AND_CONDITION = "  and {0} = {1} ";

	public static final String COMMA_VALUE = ", {0} ";

	public static final String LIKE_CONDITON = " {0} LIKE {1} ";

	public static final String INSERT_TABLE = "insert into {0} values({1}) ";

	public static final String DELETE_TABLE = "delete from {0} where {1} ";

	public static final String UPDATE_TABLE = "update {0} set {1} where {2} ";

	public static String addQuot(String str) {
		return "\"" + str + "\"";
	}

	public static String valueOfDate(String year, String month, String day) {
		return Date.valueOf(year + "-" + month + "-" + day).toString();
	}

	public static String valueOfTime(String hour, String minute, String second) {
		return Time.valueOf(hour + ":" + minute + ":" + second).toString();
	}

}
