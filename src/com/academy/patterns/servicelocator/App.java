package com.academy.patterns.servicelocator;

/**
 * Created by keos on 22.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Service locator нужен чтобы удешевить операции получения сервисов, например через JNDI
        // По сути мы один раз получаем сервис через JNDI, а после его кэшируем и локатор нам выдает кэш в следующий раз
        Service securityService = ServiceLocator.getService("jndi/securityService");
        securityService.execute();

        Service controlService = ServiceLocator.getService("jndi/controlService");
        controlService.execute();

        Service cachedSecurityService = ServiceLocator.getService("jndi/securityService");
        cachedSecurityService.execute();
    }
}
