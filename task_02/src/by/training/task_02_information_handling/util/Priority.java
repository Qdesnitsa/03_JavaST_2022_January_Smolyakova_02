package by.training.task_02_information_handling.util;

import java.util.HashMap;
import java.util.Map;

public final class Priority {
  private static Integer prior;
  private static Map<String, Integer> priorities;

  static {
    priorities = new HashMap();
    priorities.put("+", 1);
    priorities.put("-", 1);
    priorities.put("*", 2);
    priorities.put("/", 2);
  }

  private Priority() {
  }

  public static Integer obtainPriorityInt(String operator) {
    if (!priorities.containsKey(operator)) {
     throw new RuntimeException("Ask administrator to check 'Priorities table'.");
    }
    prior = priorities.get(operator);

    return prior;
  }
}
