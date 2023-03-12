package com.poc.contrainte.errors;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */

    ERR_MCS_USER_USERNAME_EMPTY("Error occurred - user username shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_PASSWORD_EMPTY("Error occurred - user password shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_ID_NOT_FOUND("Error occurred - no user found with this id"),
    ERR_MCS_USER_NOT_FOUND("Error occurred - no user found with this username");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
