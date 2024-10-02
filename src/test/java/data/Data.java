package data;

public enum Data {
    choiceEmailRu("kate@kate.ru"),
    choiceEmailCom("kate@kate.com"),
    choiceEmailGmail("kate@kate.ggg");

    private final String email;

    Data(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;

    }



}


