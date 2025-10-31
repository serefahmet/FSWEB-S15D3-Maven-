package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {

    // ✅ 1. Tekrar eden Employee’leri bul
    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();
        if (list == null) return duplicates;

        Map<Integer, Integer> counter = new HashMap<>();
        for (Employee e : list) {
            if (e == null) continue;
            counter.put(e.getId(), counter.getOrDefault(e.getId(), 0) + 1);
        }

        Set<Integer> addedIds = new HashSet<>();
        for (Employee e : list) {
            if (e == null) continue;
            if (counter.get(e.getId()) > 1 && !addedIds.contains(e.getId())) {
                duplicates.add(e);
                addedIds.add(e.getId());
            }
        }
        return duplicates;
    }

    // ✅ 2. Her id için sadece bir tane employee içeren map
    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> map = new HashMap<>();
        if (list == null) return map;

        for (Employee e : list) {
            if (e == null) continue;
            map.putIfAbsent(e.getId(), e);
        }
        return map;
    }

    // ✅ 3. Yalnızca bir kez geçen employee’leri listeye ekle
    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> uniques = new LinkedList<>();
        if (list == null) return uniques;

        Map<Integer, Integer> counter = new HashMap<>();
        for (Employee e : list) {
            if (e == null) continue;
            counter.put(e.getId(), counter.getOrDefault(e.getId(), 0) + 1);
        }

        for (Employee e : list) {
            if (e == null) continue;
            if (counter.get(e.getId()) == 1) {
                uniques.add(e);
            }
        }
        return uniques;
    }

    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques map: " + findUniques(employees));
        System.out.println("Remove duplicates: " + removeDuplicates(employees));
    }
}
