package Support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.omg.SendingContext.RunTime;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "Definitions",
        plugin = {"json:src/test/resource/report/cucumber_report.json"}
)
public class runTest {

    @AfterClass
    public static void finish() throws IOException {
        try{
            System.out.println("Generando el Reporte");
            String [] cmd={"cmd.exe","/c","npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Reporte Generado Correctamente");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
