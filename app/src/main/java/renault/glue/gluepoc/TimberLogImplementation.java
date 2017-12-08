package renault.glue.gluepoc;

import timber.log.Timber;

/**
 * Created by az01699-dev on 07/09/2017.
 */

public class TimberLogImplementation {

    public static void init() {
        Timber.plant(new Timber.DebugTree() {
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return String.format("C:%s:%s",
                        super.createStackElementTag(element),
                        element.getLineNumber());
            }
        });
    }
}
