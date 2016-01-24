package changjiashuai.github.io.rxjavatest.v5;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;
import changjiashuai.github.io.rxjavatest.v4.Callback;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 23:53.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(final String query){
        return new AsyncJob<Uri>() {
            @Override
            public void start(final Callback<Uri> callback) {
                apiWrapper.queryCats(query)
                        .start(new Callback<List<Cat>>() {
                            @Override
                            public void onResult(List<Cat> cats) {
                                Cat cutest = findCutest(cats);
                                apiWrapper.store(cutest)
                                        .start(new Callback<Uri>() {
                                            @Override
                                            public void onResult(Uri uri) {
                                                callback.onResult(uri);
                                            }

                                            @Override
                                            public void onError(Exception e) {
                                                callback.onError(e);
                                            }
                                        });
                            }

                            @Override
                            public void onError(Exception e) {
                                callback.onError(e);
                            }
                        });
            }
        };
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
