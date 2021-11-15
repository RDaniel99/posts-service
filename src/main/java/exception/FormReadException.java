package exception;

public class FormReadException extends RuntimeException{

    private final Reason reason;

    public Reason getReason() {

        return reason;
    }

    public FormReadException(Reason reason){

        this.reason = reason;
    }

    public enum Reason{

       FORM_NOT_FOUND("The given form was not found");

        private String reasonText;

        Reason(String text) {
            this.reasonText = text;
        }

        public String getReasonText() {
            return this.reasonText;
        }

    }

   
}
