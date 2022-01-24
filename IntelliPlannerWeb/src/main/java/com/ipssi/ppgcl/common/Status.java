package com.ipssi.ppgcl.common;

public class Status {

	public static final int DELETED = 0;
	public static final int ACTIVE = 1;
	public static final int INACTIVE = 2;
	public static final int ERROR = 100;

	public static class TprStatus {
		public static final int ANY = -1;
		public static final int IN_PLANT = 0;
		public static final int DISPATCHED = 1;
		public static final int COMPLETED = 2;

		public static String getStr(int id) {
			switch (id) {
			case ANY:
				return "Any";
			case IN_PLANT:
				return "In Plant";
			case DISPATCHED:
				return "Dispatched";
			case COMPLETED:
				return "Completed";
			default:
				return "NA";
			}
		}
	}

	public static class InvoiceStatus {
		public static final int ANY = -1;
		public static final int NO_RESPONSE = 0;
		public static final int SUCCESS = 1;
		public static final int FAILED = 2;
		public static final int CANCEL = 9; // cancelled from web

		public static String getStr(int id) {
			switch (id) {
			case ANY:
				return "Any";
			case NO_RESPONSE:
				return "No Response";
			case SUCCESS:
				return "Success";
			case FAILED:
				return "Failed";
			case CANCEL:
				return "Cancelled";
			default:
				return "NA";
			}
		}
	}

	public static class Workstate {

		public static final int IDLE = 0;
		public static final int BUSY = 1;
		public static final int CLEAR = 2;

	}

	public static class Token {
		public static final int ASSIGNED = 0;
		public static final int PROCESSED = 1;
		public static final int INSPECTION = 2;
		public static final int CLEAR = 3;
	}

	public static class TPR {
		public static final int OPEN = 0;
		public static final int PENDING = 1;
		public static final int CLOSE = 2;
	}

	public static class VALIDATION {
		public static final int NO_ISSUE = 0;
		public static final int DUPLICATE_CHALLAN = 1;
		public static final int DUPLICATE_LR = 2;
		public static final int DUPLICATE_ALL = 3;
		public static final int EXPIRED = 4;
		public static final int MULTIPLE_CHALLAN_EXIST = 5;
	}

	public static class VEHICLE {
		public static final int EXISTING_RF = 0;
		public static final int EXISTING_MANUAL = 1;
		public static final int NEW_MANUAL = 2;
	}

	public static class TPR_MERGE_STATUS {
		public static final int MERGED = 0;
		public static final int UNMEREGABLE = 1;
		public static final int CREATE_NEW = 2;
		public static final int FILL_BOTH_CURRENT = 3;
		public static final int FILL_RHS_CURRENT = 4;
	}

	public static class TPR_REPORTING_STATUS {
		public static final int REPORTED = 1;
		public static final int DISPATCHED = 2;
		public static final int IN_PLANT = 3;
		public static final int PRE_AUDIT = 4;
		public static final int SAP_READY = 5;
		public static final int SAP_REPORTED = 6;
		public static final int SAP_REJECTED = 7;
		public static final int CANCELLED = 8;
		public static final int NOT_RECIEVED = 9;
		public static final int PRE_DISPATCH_CANCELLED = 10;
	}

}
