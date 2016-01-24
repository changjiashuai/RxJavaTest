package changjiashuai.github.io.rxjavatest.v4;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:31.
 */
public interface Callback<T> {
    void onResult(T result);
    void onError(Exception e);
}
