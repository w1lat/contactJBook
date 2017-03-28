package vi.talya.utils.postProcessor;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import vi.talya.utils.customAnnotations.Profilling;
import vi.talya.utils.mBeanControllers.ProfillingController;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vitalii on 28.03.17.
 */
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> annotatedBeansMap = new HashMap<>();
    private ProfillingController controller = new ProfillingController();
    private static final Logger LOGGER = Logger.getLogger(ProfilingHandlerBeanPostProcessor.class);

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        controller.setEnable(true);
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("profilling", "name", "profillinController"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

        if (beanClass.isAnnotationPresent(Profilling.class)) {
            annotatedBeansMap.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class beanClass = annotatedBeansMap.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (controller.isEnable()) {
                        LOGGER.info("PROFILLING");

                        long before = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        LOGGER.info("METHOD EXECUTED FOR " + (after - before) + " nano sec");
                        LOGGER.info("METHOD PROFILLING FINISHED");
                        return retVal;
                    } else{
                        return method.invoke(bean, args);
                    }
                }
            });
        }

        return bean;
    }
}
