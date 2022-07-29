import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        //IMPERATIVE WAY
//        List<Person> females = new ArrayList<>();
//        for (Person person : people) {
//            if (person.getGender().equals(Gender.FEMALE)) {
//                females.add(person);
//            }
//        }
//        females.forEach(System.out::println);

        //filter
        List<Person> filter = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE)) //person -> person.getGender - condition of how it's going to filter
                .collect(Collectors.toList()); //extracts the result to the list

//        females.forEach(System.out ::println);

        //sort
        List<Person> collect = people.stream()
                .sorted(Comparator.comparing(Person::getAge))  //factor which is used for comparing is passed like: Comparator.comparing(*WHAT IS GOING TO BE COMPARED*)
//                .sorted(Comparator.comparing(Person::getAge).reversed())   //the same thing but if you want to go from the end fill the beginning
                .collect(Collectors.toList());
//        collect.forEach(System.out::println);


        //allMatch
        boolean b = people.stream()
                .allMatch(person -> person.getAge() > 1);
        //the result is like everyone's age is bigger that 1 so the result is TRUE
//        System.out.println(b);

        //anyMatch
        boolean a = people.stream()
                .anyMatch(person -> person.getAge() > 900);
//        System.out.println(a);

        //noneMatch
        boolean c = people.stream()
                .noneMatch(person -> person.getAge() > 900);
//        System.out.println(c);

        //Max
        Optional<Person> max = people.stream()
                .max(Comparator.comparing(Person::getAge)); //finds the maximum value in the list using comparator!
//        System.out.println(max);


        //Min
        Optional<Person> min = people.stream()
                .min(Comparator.comparing(Person::getAge)); //finds the maximum value in the list using comparator!
//        System.out.println(min);

        //Group
//        Map<Gender, List<Person>> collect1 = people.stream()
//                .collect(Collectors.groupingBy(Person::getGender));
//        collect1.forEach(((gender, people1) -> {
//            System.out.println(gender);
//            people1.forEach(System.out::println);
//        }));

        Optional<String> s = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        System.out.println(s);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }

}
