package app.controller;


import app.model.*;
import app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HierarchyController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    UnitRepository unitRepository;

    @Autowired
    UnitTypeRepository unitTypeRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    RankRepository rankRepository;

    @RequestMapping("/setDefaults")
    public String setDefaults() {
        rankRepository.deleteAll();
        rankRepository.save(new Rank("Private"));
        rankRepository.save(new Rank("Sergeant"));
        rankRepository.save(new Rank("Captain"));
        rankRepository.save(new Rank("Major"));
        rankRepository.save(new Rank("Colonel"));

        postRepository.deleteAll();
        postRepository.save(new Post("Gunner"));
        postRepository.save(new Post("Radioman"));
        postRepository.save(new Post("Engineer"));
        postRepository.save(new Post("Unit Commander"));

        UnitType currentUnitType;
        unitTypeRepository.deleteAll();
        unitTypeRepository.save(currentUnitType = new UnitType("Squad"));
        unitTypeRepository.save(currentUnitType = new UnitType("Platoon"));
        unitTypeRepository.save(currentUnitType = new UnitType("Company"));
        unitTypeRepository.save(currentUnitType = new UnitType("Regimet"));

        return "Ranks, posts and unit types are set to defaults!";
    }

    @RequestMapping("/unit")
    public String addUnit(@RequestParam(name = "unitType") String unitTypeName) {
        String result="error occured";
        long unitTypeId=0;
        for (UnitType unitType : unitTypeRepository.findAll()) {
            if (unitType.getName().equals(unitTypeName)) {
                unitTypeId = unitType.getId();
            }
        }
        unitRepository.save(new Unit(unitTypeId));
        try {
            result = "Added new " + unitTypeRepository.findOne(unitTypeId).getName() + " unit!";
        }
        catch (Exception e) {}
        return result;
    }

    @RequestMapping("/setRank")
    public String setRankToPerson(@RequestParam(name = "person") String personName, @RequestParam(name = "rank") String rankName){
        String result = "";
        Person person = null;
        Rank rank = null;
        for (Person p: personRepository.findAll()) {
            if (p.getName().equals(personName)) {
                person = p;
            }
        }
        for (Rank r: rankRepository.findAll()) {
            if (r.getName().equals((rankName))) {

                rank = r;
            }
        }

        try{
            person.setRank(rank.getId());
            result = person.getName() + " is promoted to rank " + rank.getName();
        }

        catch (Exception e) {
            result = "Error occured";
        }
        return result;
    }

    @RequestMapping("/setPost")
    public String setPostToPerson(@RequestParam(name = "person") String personName, @RequestParam(name = "post") String postName){
        String result = "";
        Person person = null;
        Post post = null;
        for (Person p: personRepository.findAll()) {
            if (p.getName().equals(personName)) {
                person = p;
            }
        }
        for (Post p: postRepository.findAll()) {
            if (p.getName().equals((postName))) {

                post = p;
            }
        }

        try{
            person.setPost(post.getId());
            result = person.getName() + " is promoted to post " + post.getName();
        }

        catch (Exception e) {
            result = "Error occured";
        }
        return result;
    }

    @RequestMapping("/setUnit")
    public String setUnitToPerson(@RequestParam(name = "person") String personName, @RequestParam(name = "unit") long unitId){
        String result = "";
        Person person = null;
        Unit unit = null;
        for (Person p: personRepository.findAll()) {
            if (p.getName().equals(personName)) {
                person = p;
            }
        }
        for (Unit u: unitRepository.findAll()) {
            if (u.getId() == unitId) {
                unit = u;
            }
        }

        try{
            person.setUnit(unit.getId());
            result = person.getName() + " is recruited to unit #" + unit.getId();
        }

        catch (Exception e) {
            result = "Error occured";
        }
        return result;
    }

    @RequestMapping("/getCommander")
    public String getCommander(@RequestParam(name = "unit") long unitId){
        String result = "Commander not found";
        for (Person person: personRepository.findAll()) {
            if ((person.getUnit() == unitId )&&(postRepository.findOne(person.getPost()).getName().equals("Commander"))){
                result = person.getName();
            }
        }
        return result;
    }

//    @RequestMapping("/test")
//    public String testFunction(@RequestParam(name = "param") long testParam) {
//        String result="";
//        for(UnitType unitType : unitTypeRepository.findAll()){
//            result += unitType.getName() + "<br>";
//        }
//        return result;
//    }
}
