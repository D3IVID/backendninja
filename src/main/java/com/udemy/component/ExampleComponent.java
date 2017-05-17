package com.udemy.component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */
@Component("exampleComponent")
public class ExampleComponent {
    public static final Log LOG = LogFactory.getLog(ExampleComponent.class);

    public void hola(){
        LOG.info("Hola Mundo desde Componente");
    }

}
