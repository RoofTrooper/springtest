package app.controller;

import app.model.Person;
import app.repository.PersonRepository;
import app.repository.UnitRepository;
import app.repository.UnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/person")
    public String addPerson(@RequestParam(value="name") String name){
        personRepository.save(new Person(name));
        return name + " recruited! ";
    }

    @RequestMapping("/getPersons")
    public String getPersons(){
        String result = "";

        for (Person person : personRepository.findAll()){
            result += person.toString() + "<br>";
        }
        return result;
    }
    @RequestMapping("/getPersonsByUnit")
    public String getPersonsByUnit(@RequestParam(value="unit") long unit) {
        String result = "";

        for (Person person: personRepository.findAll()){
            if (person.getUnit()==unit) {
                result += person.toString();
            }
        }
        return result;
    }
    @RequestMapping("/findPersonById")
    public String findById(@RequestParam("id") long id) {
        return personRepository.findOne(id).toString();
    }
}
