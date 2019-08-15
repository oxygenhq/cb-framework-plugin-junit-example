import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class RunExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource, io.cloudbeat.junit.JUnitRunner {
    @Override
    public void beforeAll(ExtensionContext context) {
        DriverProvider provider = new DriverProvider();
        setWebDriverGetter(provider::getWebDriver);
    }
}
