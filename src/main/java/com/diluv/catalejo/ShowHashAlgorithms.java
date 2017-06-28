package com.diluv.catalejo;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ShowHashAlgorithms {

    private static final void showHashAlgorithms (Provider prov, Class<?> typeClass) {

        final String type = typeClass.getSimpleName();

        final List<Service> algos = new ArrayList<>();

        final Set<Service> services = prov.getServices();
        for (final Service service : services) {
            if (service.getType().equalsIgnoreCase(type)) {
                algos.add(service);
            }
        }
        
        if (!algos.isEmpty()) {
            System.out.printf(" --- Provider %s, version %.2f --- %n", prov.getName(), prov.getVersion());
            for (final Service service : algos) {
                final String algo = service.getAlgorithm();
                System.out.printf("Algorithm name: \"%s\"%n", algo);

            }
        }

        // --- find aliases (inefficiently)
        final Set<Object> keys = prov.keySet();
        for (final Object key : keys) {
            final String prefix = "Alg.Alias." + type + ".";
            if (key.toString().startsWith(prefix)) {
                final String value = prov.get(key.toString()).toString();
                System.out.printf("Alias: \"%s\" -> \"%s\"%n", key.toString().substring(prefix.length()), value);
            }
        }
    }

    public static void main (String[] args) {

        final Provider[] providers = Security.getProviders();
        for (final Provider provider : providers) {
            showHashAlgorithms(provider, MessageDigest.class);
        }
    }
}