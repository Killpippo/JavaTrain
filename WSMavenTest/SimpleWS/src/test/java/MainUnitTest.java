
import org.junit.Test;
import static org.junit.Assert.*;
import com.pippo.simplews.*;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;


public class MainUnitTest extends JerseyTest
{
    @Override
    protected Application configure()
    {
        Set<Class<?>> resources = new java.util.HashSet<>();
        
        resources.add(MainRoot.class);
        resources.add(Main2Resource.class);
        
        Application app = new ResourceConfig(resources);
        
        return app;
    }
    
    @Test
    public void MainTest()
    {
        final String result = target("main").request().get(String.class);
        
        assertEquals("main test working", result);        
    }
    
    @Test
    public void MainTest2()
    {
        final String result = target("main2").request().get(String.class);
        
        assertEquals("this is main2", result);        
    }
}
