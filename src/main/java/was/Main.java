package was;

import java.net.URL;
import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Provider p[] = Security.getProviders();
            for (int i = 0; i < p.length; i++) {
                System.out.println(p[i].getClass().getName());
                System.out.println("\t" + p[i]);
                for (Map.Entry<Object, Object> entry: p[i].entrySet()) {
                    if (entry.getKey().toString().startsWith("Alg.Alias.Cipher")) {
                        System.out.println("\t\t key='" + entry.getKey() + "' value='" + entry.getValue() + "'");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
