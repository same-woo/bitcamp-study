// bitcamp.myapp.handler.AuthService.java
package bitcamp.myapp.handler.Login;

import bitcamp.util.BreadcrumbPrompt;

public interface AuthService {
    boolean login(BreadcrumbPrompt prompt);
    void register();
}
