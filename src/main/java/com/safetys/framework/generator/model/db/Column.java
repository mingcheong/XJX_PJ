package com.safetys.framework.generator.model.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.safetys.framework.generator.utils.DatabaseDataTypesUtils;
import com.safetys.framework.generator.utils.StringHelper;

public class Column {
	/**
	 * Reference to the containing table
	 */
	private final Table _table;

	/**
	 * The java.sql.Types type
	 */
	private final int _sqlType;

	/**
	 * The sql typename. provided by JDBC driver
	 */
	private final String _sqlTypeName;

	/**
	 * The name of the column
	 */
	private final String _sqlName;

	/**
	 * True if the column is a primary key
	 */
	private boolean _isPk;

	/**
	 * True if the column is a foreign key
	 */
	private boolean _isFk;

	/**
	 * @todo-javadoc Describe the column
	 */
	private final int _size;

	/**
	 * @todo-javadoc Describe the column
	 */
	private final int _decimalDigits;

	/**
	 * True if the column is nullable
	 */
	private final boolean _isNullable;

	/**
	 * True if the column is indexed
	 */
	private final boolean _isIndexed;

	/**
	 * True if the column is unique
	 */
	private final boolean _isUnique;

	/**
	 * Null if the DB reports no default value
	 */
	private final String _defaultValue;

	/**
	 * Get static reference to Log4J Logger
	 */
	private static Log _log = LogFactory.getLog(Column.class);

	public Column(Table table, int sqlType, String sqlTypeName, String sqlName, int size, int decimalDigits, boolean isPk, boolean isFk, boolean isNullable, boolean isIndexed,
	        boolean isUnique, String defaultValue) {
		_table = table;
		_sqlType = sqlType;
		_sqlName = sqlName;
		_sqlTypeName = sqlTypeName;
		_size = size;
		_decimalDigits = decimalDigits;
		_isPk = isPk;
		_isFk = isFk;
		_isNullable = isNullable;
		_isIndexed = isIndexed;
		_isUnique = isUnique;
		_defaultValue = defaultValue;
		_log.debug(sqlName + " isPk -> " + _isPk);

	}

	public int getSqlType() {
		return _sqlType;
	}

	public Table getTable() {
		return _table;
	}

	public int getSize() {
		return _size;
	}

	public int getDecimalDigits() {
		return _decimalDigits;
	}

	public String getSqlTypeName() {
		return _sqlTypeName;
	}

	public String getSqlName() {
		return _sqlName;
	}

	public boolean isPk() {
		return _isPk;
	}

	public boolean isFk() {
		return _isFk;
	}

	public final boolean isNullable() {
		return _isNullable;
	}

	public final boolean isIndexed() {
		return _isIndexed;
	}

	public boolean isUnique() {
		return _isUnique;
	}

	public final String getDefaultValue() {
		return _defaultValue;
	}

	public int hashCode() {
		return (getTable().getSqlName() + "#" + getSqlName()).hashCode();
	}

	public boolean equals(Object o) {
		return this == o;
	}

	public String toString() {
		return getSqlName();
	}

	protected final String prefsPrefix() {
		return "tables/" + getTable().getSqlName() + "/columns/" + getSqlName();
	}

	void setFk(boolean flag) {
		_isFk = flag;
	}

	public String getColumnName() {
		return StringHelper.makeAllWordFirstLetterUpperCase(getSqlName());
	}

	public String getColumnNameLower() {
		return StringHelper.uncapitalize(getColumnName());
	}

	public boolean getIsNotIdOrVersionField() {
		return !isPk();
	}

	public String getValidateString() {
		String result = getNoRequiredValidateString();
		if (!isNullable()) {
			result = "required " + result;
		}
		return result;
	}

	public String getNoRequiredValidateString() {
		String result = "";
		if (getSqlName().indexOf("mail") >= 0) {
			result += "validate-email ";
		}
		if (DatabaseDataTypesUtils.isFloatNumber(getSqlType(), getSize(), getDecimalDigits())) {
			result += "validate-number ";
		}
		if (DatabaseDataTypesUtils.isIntegerNumber(getSqlType(), getSize(), getDecimalDigits())) {
			result += "validate-integer ";
		}
		if (DatabaseDataTypesUtils.isDate(getSqlType(), getSize(), getDecimalDigits())) {
			result += "validate-date ";
		}
		return result;
	}

	public boolean getIsDateTimeColumn() {
		return DatabaseDataTypesUtils.isDate(getSqlType(), getSize(), getDecimalDigits());
	}

	public boolean isHtmlHidden() {
		return isPk() && _table.isSingleId();
	}

	public String getJavaType() {
		return DatabaseDataTypesUtils.getPreferredJavaType(getSqlType(), getSize(), getDecimalDigits());
	}

}
