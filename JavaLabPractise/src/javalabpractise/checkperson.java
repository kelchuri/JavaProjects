package javalabpractise;


interface CheckPerson {
    boolean test(Person p);
}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}
class CheckPersonEligibleForSomethingElse implements CheckPerson{}


printPersons(Person[] roster, CheckPerson c){}


printPersons(Person[] roster, new CheckPersonEligibleForSelectiveService()){};
printPersons(Person[] roster, new CheckPersonEligibleForSomethingElse()){};

printPersons(Person[] roster, new CheckPerson() {
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25;
        }
    }
);

printPersons(Person[] roster, new CheckPerson() {
        public boolean test(Person p) {
            doSomthingelse();
        }
    }
);



CheckPerson c = (Person p) -> p.getGender() == Person.Sex.MALE
        && p.getAge() >= 18
        && p.getAge() <= 25
);

printPersons(r, c);

printPersons(Person[] roster, CheckPerson c){}


