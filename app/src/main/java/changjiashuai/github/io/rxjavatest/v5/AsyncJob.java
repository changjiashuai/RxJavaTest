package changjiashuai.github.io.rxjavatest.v5;

import changjiashuai.github.io.rxjavatest.v4.Callback;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 23:49.
 */
public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);
}
