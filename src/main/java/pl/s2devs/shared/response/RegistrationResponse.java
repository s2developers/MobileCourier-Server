package pl.s2devs.shared.response;


import pl.s2devs.person.model.Person;

/**
 * Created by rafal on 14.11.17.
 */
public class RegistrationResponse {

    public enum Code {
        EMAIL_TAKEN, PERSON_REGISTERED
    }

    private Person person;
    private Code code;

    public RegistrationResponse(Person person, Code code) {
        this.person = person;
        this.code = code;
    }

    public Person getPerson() {
        return person;
    }

    public Code getCode() {
        return code;
    }
}
