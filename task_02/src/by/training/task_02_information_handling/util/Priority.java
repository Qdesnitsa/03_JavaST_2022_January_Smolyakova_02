package by.training.task_02_information_handling.util;

import java.util.HashMap;
import java.util.Map;

public final class Priority {
  private static Integer prior;
  private static Map<String, Integer> priorities = new HashMap<>();

  public static Integer getPriorityInt(String operator) {
    priorities.put("+", 1);
    priorities.put("-", 1);
    priorities.put("*", 2);
    priorities.put("/", 2);
    if (priorities.containsKey(operator)) {
      prior = priorities.get(operator);
    }
    return prior;
  }

}
