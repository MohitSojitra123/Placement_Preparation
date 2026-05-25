import java.util.*;

public class HashMap_All_Methods {

    public static void main(String[] args) {

        // =====================================================
        // 1. CREATE HASHMAP
        // =====================================================

        HashMap<Integer,String> map =
                new HashMap<>();

        // =====================================================
        // 2. put(K key, V value)
        // Insert key-value pair
        // =====================================================

        map.put(101, "Java");
        map.put(102, "Python");
        map.put(103, "C");
        map.put(104, "JavaScript");

        System.out.println("put(): " + map);

        // =====================================================
        // 3. putIfAbsent()
        // =====================================================

        map.putIfAbsent(105, "React");

        System.out.println("putIfAbsent(): " + map);

        // =====================================================
        // 4. putAll()
        // =====================================================

        HashMap<Integer,String> map2 =
                new HashMap<>();

        map2.put(106, "HTML");
        map2.put(107, "CSS");

        map.putAll(map2);

        System.out.println("putAll(): " + map);

        // =====================================================
        // 5. get(Object key)
        // =====================================================

        System.out.println("get(): " + map.get(101));

        // =====================================================
        // 6. getOrDefault()
        // =====================================================

        System.out.println(
                "getOrDefault(): "
                + map.getOrDefault(500, "Not Found")
        );

        // =====================================================
        // 7. containsKey()
        // =====================================================

        System.out.println(
                "containsKey(): "
                + map.containsKey(102)
        );

        // =====================================================
        // 8. containsValue()
        // =====================================================

        System.out.println(
                "containsValue(): "
                + map.containsValue("Python")
        );

        // =====================================================
        // 9. size()
        // =====================================================

        System.out.println("size(): " + map.size());

        // =====================================================
        // 10. isEmpty()
        // =====================================================

        System.out.println("isEmpty(): " + map.isEmpty());

        // =====================================================
        // 11. remove(Object key)
        // =====================================================

        map.remove(107);

        System.out.println("remove(key): " + map);

        // =====================================================
        // 12. remove(key,value)
        // =====================================================

        map.remove(106, "HTML");

        System.out.println("remove(key,value): " + map);

        // =====================================================
        // 13. replace(key,value)
        // =====================================================

        map.replace(101, "JAVA");

        System.out.println("replace(): " + map);

        // =====================================================
        // 14. replace(key,old,new)
        // =====================================================

        map.replace(102, "Python", "PYTHON");

        System.out.println("replace(old,new): " + map);

        // =====================================================
        // 15. replaceAll()
        // =====================================================

        map.replaceAll((k,v) -> v.toUpperCase());

        System.out.println("replaceAll(): " + map);

        // =====================================================
        // 16. keySet()
        // Access all keys
        // =====================================================

        System.out.println("keySet(): ");

        Set<Integer> keys = map.keySet();

        for(Integer k : keys){
            System.out.println(k);
        }

        // =====================================================
        // 17. values()
        // Access all values
        // =====================================================

        System.out.println("values(): ");

        Collection<String> values =
                map.values();

        for(String v : values){
            System.out.println(v);
        }

        // =====================================================
        // 18. entrySet()
        // Access key and value together
        // =====================================================

        System.out.println("entrySet(): ");

        Set<Map.Entry<Integer,String>> entries =
                map.entrySet();

        for(Map.Entry<Integer,String> e : entries){

            System.out.println(
                    e.getKey()
                    + " : "
                    + e.getValue()
            );
        }

        // =====================================================
        // 19. forEach()
        // =====================================================

        System.out.println("forEach(): ");

        map.forEach((k,v) -> {

            System.out.println(
                    k + " -> " + v
            );

        });

        // =====================================================
        // 20. clone()
        // =====================================================

        HashMap<Integer,String> cloneMap =
                (HashMap<Integer,String>) map.clone();

        System.out.println("clone(): " + cloneMap);

        // =====================================================
        // 21. equals()
        // =====================================================

        System.out.println(
                "equals(): "
                + map.equals(cloneMap)
        );

        // =====================================================
        // 22. hashCode()
        // =====================================================

        System.out.println(
                "hashCode(): "
                + map.hashCode()
        );

        // =====================================================
        // 23. clear()
        // =====================================================

        HashMap<Integer,String> temp =
                new HashMap<>();

        temp.put(1, "A");
        temp.put(2, "B");

        temp.clear();

        System.out.println("clear(): " + temp);

        // =====================================================
        // 24. toString()
        // =====================================================

        System.out.println(
                "toString(): "
                + map.toString()
        );

        // =====================================================
        // 25. compute()
        // =====================================================

        map.compute(101, (k,v) -> v + "_LANG");

        System.out.println("compute(): " + map);

        // =====================================================
        // 26. computeIfAbsent()
        // =====================================================

        map.computeIfAbsent(
                200,
                k -> "NEW_VALUE"
        );

        System.out.println(
                "computeIfAbsent(): "
                + map
        );

        // =====================================================
        // 27. computeIfPresent()
        // =====================================================

        map.computeIfPresent(
                102,
                (k,v) -> v + "_UPDATED"
        );

        System.out.println(
                "computeIfPresent(): "
                + map
        );

        // =====================================================
        // 28. merge()
        // =====================================================

        map.merge(
                103,
                "_LANGUAGE",
                (oldVal,newVal)
                        -> oldVal + newVal
        );

        System.out.println("merge(): " + map);

    }
}