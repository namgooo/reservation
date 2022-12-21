package com.green.sbb;

import lombok.Getter;

@Getter
public enum UserRole {
	
	//SUPERADMIN("ROLE_SUPERADMIN"),
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");
	

    UserRole(String value) {
        this.value = value;
    }

    private String value;
	
}
