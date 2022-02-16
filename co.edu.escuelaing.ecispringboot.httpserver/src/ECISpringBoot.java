import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ECISpringBoot {

    private Map<String, Method> services = new HashMap();

    private static ECISpringBoot _instance = new ECISpringBoot();

    private ECISpringBoot(){}

    public static ECISpringBoot getInstance(){
        return _instance;
    }



    public void startServer(){
        loadComponents();
        try {
            HttpServer httpServer = new HttpServer();
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadComponents() {
        String[] componentList= searchComponentList();
        for(String componentName: componentList){
            loadServices(componentName);
        }
    }

    private void loadServices(String componentName) {
        try {
            Class c = Class.forName(componentName);
            Method[] declaredMethods = c.getDeclaredMethods();
            for(Method m: declaredMethods){
                if(m.isAnnotationPresent(Service.class)){
                    Service a = m.getAnnotation(Service.class);
                    String serviceName = a.value();

                    services.put(a.value(), m);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String invokeService(String serviceName) {
        Method serviceMethod = services.get(serviceName);
        try {
            return (String) serviceMethod.invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

        private String[] searchComponentList(){
            //TODO: Devolver los .class
            return new String[]{"co.edu.escuelaing.ecispringboot.httpserver.examples"};
        }
}

