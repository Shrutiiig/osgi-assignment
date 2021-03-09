package com.mysite.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MyComponent {

    final Logger LOGGER = LoggerFactory.getLogger(MyComponent.class);

    @Activate
    protected void a() {
        LOGGER.info("My Component is activated");
    }

    @Deactivate
    protected void da() {
        LOGGER.info("My Component is deactivated");
    }

}
