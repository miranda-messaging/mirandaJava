package com.ltsllc.mirandaClient;

import com.ltsllc.miranda.PrivateKey;
import com.ltsllc.miranda.test.TestCase;
import com.ltsllc.miranda.user.User;
import com.ltsllc.miranda.util.Utils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.security.KeyStore;

/**
 * Created by Clark on 6/2/2017.
 */
public class TestSession extends TestCase {
    private Session session;

    public Session getSession() {
        return session;
    }

    public void reset () {
        super.reset();

        session = null;
    }

    public static final String USER_KEY_STORE = "userKeyStore";
    public static final String TEST_PASSWORD = "whatever";
    public static final String PRIVATE_KEY_ALIAS = "private";
    public static final String TEST_URL = "https://localhost";
    public static final String TRUST_STORE_PROPERTY = "javax.net.ssl.trustStore";

    @Before
    public void setup () {
        reset();

        super.setup();

        File file = new File("truststore");
        System.setProperty(TRUST_STORE_PROPERTY, "truststore");

        PrivateKey privateKey = null;
        try {
            KeyStore keyStore = Utils.loadKeyStore(USER_KEY_STORE, TEST_PASSWORD);
            java.security.PrivateKey jsPrivateKey = (java.security.PrivateKey) keyStore.getKey(PRIVATE_KEY_ALIAS, TEST_PASSWORD.toCharArray());
            privateKey = new PrivateKey(jsPrivateKey);
            User admin = new User("admin", User.UserTypes.Admin, "the admin user");
            session = new Session(admin, privateKey, TEST_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test () throws Exception {
        getSession().connect();
    }
}
