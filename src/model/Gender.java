package model;

public enum Gender {
	MALE("Nam"), FEMALE("Nữ");

	private String name;

	private Gender(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
