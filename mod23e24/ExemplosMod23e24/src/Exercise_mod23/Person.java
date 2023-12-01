package Exercise_mod23;

class Person{
    private String name;
    private char gender;
    private String nationality;

    public Person() {
    	
    }
    
    public Person(String name, char gender2, String nationality) {
        this.name = name;
        this.gender = gender2;
        this.nationality = nationality;
    }

    public String getNome() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }
}

