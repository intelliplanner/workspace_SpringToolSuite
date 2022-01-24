package com.ipssi.ppgcl.enums;

import java.util.HashMap;
import java.util.Map;

public class Status {
	public static enum TprStatus {
		ANY(-1, "ANY"), IN_PLANT(0, "IN_PLANT"), DISPATCHED(1, "DISPATCHED"), COMPLETED(2, "COMPLETED");

		private static final Map<Integer, TprStatus> byId = new HashMap<Integer, TprStatus>();
		static {
			for (TprStatus e : TprStatus.values()) {
				if (byId.put(e.getId(), e) != null) {
					throw new IllegalArgumentException("duplicate id: " + e.getId());
				}
			}
		}

		public static TprStatus getById(Integer id) {
			return byId.get(id);
		}

		private String name;

		private Integer id;

		TprStatus(Integer id, String name) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public Integer getId() {
			return id;
		}

	}

	public static enum InvoiceStatus {
		ANY(-1, "ANY"), NO_RESPONSE(0, "NO_RESPONSE"), SUCCESS(1, "SUCCESS"), FAILED(2, "FAILED"), CANCEL(9, "CANCEL");

		private static final Map<Integer, InvoiceStatus> byId = new HashMap<Integer, InvoiceStatus>();
		static {
			for (InvoiceStatus e : InvoiceStatus.values()) {
				if (byId.put(e.getId(), e) != null) {
					throw new IllegalArgumentException("duplicate id: " + e.getId());
				}
			}
		}

		public static InvoiceStatus getById(Integer id) {
			return byId.get(id);
		}

		private String name;

		private Integer id;

		InvoiceStatus(Integer id, String name) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public Integer getId() {
			return id;
		}

	}
}
