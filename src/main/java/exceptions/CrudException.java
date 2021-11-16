package exceptions;

public class CrudException extends Exception {

    private Reason reason;

    public CrudException(String message) {

        super(message);
    }

    public CrudException(Reason reason) {

        this.reason = reason;
    }

    public Reason getReason() {

        return reason;
    }

    public enum Reason {

        FORM_NOT_FOUND("The given form was not found"),

        ID_CANNOT_BE_CHANGED("Id can not be changed"),

        USER_ID_CANNOT_BE_CHANGED("User Id can not be changed"),

        FORM_ID_CANNOT_BE_CHANGED("Form Id can not be changed"),

        QUESTION_ID_CANNOT_BE_CHANGED("Question Id cannot be changed");

        private String reasonText;

        Reason(String text) {
            this.reasonText = text;
        }

        public String getReasonText() {
            return this.reasonText;
        }

    }
}
