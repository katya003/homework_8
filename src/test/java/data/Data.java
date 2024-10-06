package data;

public enum Data {
    CHOICEEMAILRU("kate@kate.ru"),
    CHOICEEMAILCOM("kate@kate.com"),
    CHOICEEMAILGMAIL("kate@kate.ggg");

    private final String email;

    Data(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;

    }



}


