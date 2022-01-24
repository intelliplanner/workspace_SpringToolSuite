package com.ipssi.ppgcl.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Misc {
	public static final int UNDEF_VALUE = -1111111;// -1999999999;
	public static final int UNDEF_SHORT_VALUE = -11111;
	public static final int UNDEF_BYTE_VALUE = -1;
	public static final double UNDEF_FLOAT_VALUE = -1e12f;// UNDEF_VALUE * 100000;
	public static final double UNDEF_FLOAT_VALUE_CMP = -1e11f;// UNDEF_VALUE * 100000;
	public static java.text.DecimalFormat m_formatter = new java.text.DecimalFormat("###,###.##");
	public static java.text.DecimalFormat frac_formatter = new java.text.DecimalFormat("0.000");
	public static java.text.DecimalFormat perc_formatter = new java.text.DecimalFormat("0");
	public static java.text.DecimalFormat m_currency_formatter = new java.text.DecimalFormat("0.00");
	public static java.text.SimpleDateFormat m_indepFormatterFull = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static boolean isExplicitAny(int val) {
		return val == (UNDEF_VALUE + 1);
	}

	public static short getUndefShort() {
		return UNDEF_SHORT_VALUE;
	}

	public static int getUndefInt() {
		return (int) UNDEF_VALUE;
	}

	public static byte getUndefByte() {
		return UNDEF_BYTE_VALUE;
	};

	public static int getExplicitAny() {
		return (int) UNDEF_VALUE + 1;
	}

	public static double getUndefDouble() {
		return (double) UNDEF_FLOAT_VALUE;
	}

	public static boolean isUndef(short val) {
		return val == UNDEF_SHORT_VALUE;
	}

	public static boolean isUndef(int val) {
		return val == UNDEF_VALUE;
	}

	public static boolean isUndef(byte b) {
		return b == UNDEF_BYTE_VALUE;
	}

	public static boolean isUndef(long val) {
		return val == UNDEF_VALUE;
	}

	public static boolean isUndef(double val) {
		return val <= UNDEF_FLOAT_VALUE_CMP;
	}

	public static String convertDate(java.util.Date date, DateFormat dateOutFormat) {
		String strDate = "";
		if (date != null)
			strDate = dateOutFormat.format(date);
		return strDate;
	}

	public static String getPrintableInt(int val) {
		return Misc.isUndef(val) ? "" : Integer.toString(val);
	} // dont use

	public static String getPrintablePercent(double val) {
		return Misc.isUndef(val) ? "" : perc_formatter.format(val * 100);
	} // dont use

	public static String getPrintableDouble(double val) {
		return Misc.isUndef(val) ? "" : m_currency_formatter.format(val);
	} // dont use

	public static String getPrintableString(String val) {
		return val == null ? "" : val;
	} // dont use

}
