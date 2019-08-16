import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class RunExtension extends io.cloudbeat.junit.JUnitRunner implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        setWebDriver(DriverProvider.getWebDriver());
    }

    @Override
    public void close() throws Throwable {
    }
}
