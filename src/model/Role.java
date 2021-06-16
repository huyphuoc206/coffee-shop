package model;

public enum Role {
	ADMIN("Quản trị viên"), USER("Nhân viên");

	private String name;

	private Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
