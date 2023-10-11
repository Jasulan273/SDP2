package flyweight_design_pattern;

import java.util.HashMap;
import java.util.Random;

//Define the Employee interface that represents an employee with skills and tasks.
interface Employee {
  public void assignSkill(String skill);
  public void task();
}

//Concrete class Developer implementing the Employee interface.
class Developer implements Employee {
  private final String JOB;
  private String skill;

  public Developer() {
    JOB = "Fix the issue";
  }

  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void task() {
    System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
  }
}

//Concrete class Tester implementing the Employee interface.
class Tester implements Employee {
  private final String JOB;
  private String skill;

  public Tester() {
    JOB = "Test the issue";
  }

  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void task() {
    System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
  }
}

//Factory class EmployeeFactory for creating and managing employee instances.
class EmployeeFactory {
  private static HashMap<String, Employee> m = new HashMap<String, Employee>();

  public static Employee getEmployee(String type) {
    Employee p = null;
    if (m.get(type) != null) {
      p = m.get(type);
    } else {
      switch (type) {
        case "Developer":
          System.out.println("Developer Created");
          p = new Developer();
          break;
        case "Tester":
          System.out.println("Tester Created");
          p = new Tester();
          break;
        default:
          System.out.println("No Such Employee");
      }

      m.put(type, p);
    }
    return p;
  }
}

public class FlyweightPattern {
  private static String employeeType[] = { "Developer", "Tester" };
  private static String skills[] = { "Java", "C++", ".Net", "Python" };

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Employee e = EmployeeFactory.getEmployee(getRandEmployee());
      e.assignSkill(getRandSkill());
      e.task();
    }
  }

  public static String getRandEmployee() {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    return employeeType[randInt];
  }

  public static String getRandSkill() {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    return skills[randInt];
  }
}
