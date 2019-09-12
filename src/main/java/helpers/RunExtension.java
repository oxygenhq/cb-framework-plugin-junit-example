package helpers;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class RunExtension extends io.cloudbeat.junit.JUnitRunner implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        DriverProvider.reload();
        setWebDriver(DriverProvider.getWebDriver());
    }

    @Override
    public void close() throws Throwable {
    }
}
