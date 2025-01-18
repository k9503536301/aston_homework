import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HashCollisionExample {
    public static void main(String[] args) throws Exception {
        Map<CustomKey, String> map = new HashMap<>();
        for (int i=1; i < 10; i++) {
            CustomKey key = new CustomKey(i);
            map.put(key, "Value" + i);
            System.out.println("i = " + i);
            System.out.println("Map size = " + map.size());

            printBucketInfo(map,key);

            System.out.println();
        }
    }

    private static void printBucketInfo(Map<?, ?> map, Object key) throws Exception {
        Class<?> mapClass = map.getClass();
        Field tableField = mapClass.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(map);

        int hash = key.hashCode();
        int index = (hash & (table.length - 1));
        System.out.println("Element hash = " + hash);

        Object node = table[index];

        System.out.println("Node type - " + node.getClass().getSimpleName());

        System.out.println("Bucket index =" + index);
    }
}

class CustomKey {
    private int id;

    public CustomKey(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        CustomKey other = (CustomKey) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
